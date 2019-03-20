package br.com.alura.cliente;

import org.apache.http.client.fluent.Request;

public class ClienteWebService {

	public static void main(String[] args) throws Exception {
		
	
	String counteudo = Request
			.Post("http://localhost:8080/gerencidador/empresas")
			.addHeader("Accept","application/json").execute()
			.returnContent().asString();
	
	}
}
