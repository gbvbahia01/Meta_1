package br.com.exam;

import java.util.Arrays;

public class Binario {

	public static void main(String[] args) {
		
		int[] A1 = {1,0,0,1,1  };//9
		int[] A2 = {1,1,0,1,0  };//-9
		
		int[] B1 = {1,1,0,0,1,0  };//15
		int[] B2 = {1,0,0,0,1,1  };//-15
		
		int[] C1 = {1,1,0,1,0,1,1  };//23
		int[] C2 = {1,0,0,1,1,1,0  };//-23
		
		//System.out.println(getNumber(A1));
		//System.out.println(getNumber(getArray(-getNumber(A1))));
		
		
	}
	
	private static final int BASE = -2;
	
	public static int getNumber(int[] binary){
		int lt = binary.length;
		int number = 0;
		for(int i = 0; i < lt; i++){
			int B = binary[i];
			number += (B * Math.pow(BASE, i));
		}
		return number;
	}
	
	public static int[] getArray(int n){
		
		return null;
	}
}
