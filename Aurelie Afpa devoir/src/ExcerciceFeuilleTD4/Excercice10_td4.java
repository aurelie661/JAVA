package ExcerciceFeuilleTD4;

import java.util.Arrays;

public class Excercice10_td4 {
	static int[] doubleTableau(int t[]){
		for (int i = 0; i < t.length; i++) {
			t[i]=t[i]*2;
		}
		return t;
	}
	public static void main(String[] args) {
		int tab[]= {10,20,30,40,50};
		doubleTableau(tab);
		System.out.println(Arrays.toString(tab));
		
		}
}