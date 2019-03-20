package br.com.teste.JuniorDev;

import java.util.ArrayList;

public class Problem2 {

	public static void main(String[] args) {
		
		
		ArrayList<Integer> array = new ArrayList<Integer>();
		array.add(1);
		array.add(2);
		array.add(4);
		array.add(4);
		int sum = 8;
		Boolean result = HasPairWithSum(array, sum);
		System.out.println(result);
	}

	// Only numbers integer and a sort array
	private static Boolean HasPairWithSum(ArrayList<Integer> array, int sum) {
		int low = 0;
		int hight = array.size() - 1;
		
		while(low<hight) {
			int aux = array.get(low)+array.get(hight);
			if(aux == sum)
				return true;
			if(aux < sum)
				low++;
			if(aux > sum)
				hight++;
		}
		return false;
	}
}
