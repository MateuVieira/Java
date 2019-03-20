package br.com.teste.JuniorDev;

import java.util.ArrayList;
import java.util.HashSet;

public class Problem3 {

	public static void main(String[] args) {
		
		
		ArrayList<Integer> array = new ArrayList<Integer>();
		array.add(1);
		array.add(2);
		array.add(4);
		array.add(4);
		int sum = 8;
		Boolean result = HasPairWithSumNoSort(array, sum);
		System.out.println(result);
	}

	// Only numbers integer and a sort array
	private static Boolean HasPairWithSumNoSort(ArrayList<Integer> array, int sum) {
		
		HashSet<Integer> complement = new HashSet<>(); 
		complement.add(0);
		for (Integer num : array) {
			int s = num - sum;
			if(complement.contains(s)) 
				return true;
			complement.add(s);
		}
		return false;
	}
}
