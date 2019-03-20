package br.com.teste.JuniorDev;

import java.util.ArrayList;

public class Problem1 {
	public static void main(String[] args) {
		
		for(int i = 1; i <= 10000; i++) {
			System.out.print(i + ": ");
			if(i%3 == 0)
				System.out.print("fizz");
			if(i%5 == 0)
				System.out.print("buzz");
			System.out.println();
			
		}
	}
}
