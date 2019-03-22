package br.com.casadocodigo.loja.infra;

import java.io.File;
import java.io.IOException;

import javax.management.RuntimeErrorException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileSaver {

	@Autowired
	private HttpServletRequest request;

	public String write(String baseFolder, MultipartFile file) {
		try {
			String realPath = request.getServletContext().getRealPath("/" + baseFolder);
			String pathName = realPath + "/" + file.getOriginalFilename();
			file.transferTo(new File(pathName));

			return pathName;
			
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
