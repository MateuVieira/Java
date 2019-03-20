package java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OrdenaStrings {

	public static void main(String[] args) {
		
		List<String> palavras = new ArrayList<String>();
		palavras.add("alura online");
		palavras.add("editora casa do codigo");
		palavras.add("caelum");
		
		Comparator<String> comparador = new ComparadorporTamanho();
		//Collections.sort(palavras,comparador);
		
//		palavras.sort(comparador);
//		System.out.println(palavras);
		
		palavras.forEach(s -> System.out.println(s));
		System.out.println();
		//lambda
		//palavras.sort((s1, s2) -> s1.length() - s2.length());
		//Comparator
		palavras.sort(Comparator.comparing(s -> s.length()));
		palavras.sort(Comparator.comparing(String::length));
		palavras.forEach(s -> System.out.println(s));
		palavras.forEach(System.out::println);
		
		
		System.out.println();
		
		
	}
}

class ComparadorporTamanho implements Comparator<String>{

	@Override
	public int compare(String o1, String o2) {
		if(o1.length() < o2.length() )
			return -1;
		if(o1.length() > o2.length())
			return 1;
		
		return 0;
	}
	
}