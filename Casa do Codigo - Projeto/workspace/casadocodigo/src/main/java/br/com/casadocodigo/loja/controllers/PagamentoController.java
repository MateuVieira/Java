package br.com.casadocodigo.loja.controllers;

import java.util.concurrent.Callable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.casadocodigo.loja.models.CarrinhoCompras;
import br.com.casadocodigo.loja.models.DadosPagamento;
import br.com.casadocodigo.loja.models.Usuario;

@RequestMapping("/pagamento")
@Controller
public class PagamentoController {

	@Autowired
	private CarrinhoCompras carrinho;
	
	@Autowired
	private MailSender sender;

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping(value = "/finalizar", method = RequestMethod.POST)
	public Callable<ModelAndView> finalizar(@AuthenticationPrincipal Usuario usuario, RedirectAttributes model) {

		return() -> {			
			System.out.println(carrinho.getTotal());
			
			String uri = "http://book-payment.herokuaap.com/payment";
			
			try {
				String response = restTemplate.postForObject(uri, new DadosPagamento(carrinho.getTotal()), String.class);
				enviaEmailCompraProduto(usuario);
				model.addFlashAttribute("sucesso", response);
			} catch (Exception e) {
				e.printStackTrace();
				model.addFlashAttribute("sucesso", "Valor maior que o permitido");
				return new ModelAndView("redirect:/produtos");
			}
			
			return new ModelAndView("redirect:/produtos");
		};
	}

	private void enviaEmailCompraProduto(Usuario usuario) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setSubject("Compra finalizada com sucesso.");
		message.setTo(usuario.getEmail());
		message.setText("Compra aprovada com sucesso no valor de " + carrinho.getTotal());
		message.setFrom("compras@casadocodigo.com.br");
		
		sender.send(message);
		
		
	}
}
