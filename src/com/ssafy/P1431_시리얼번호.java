package com.ssafy;

import java.util.Scanner;

public class P1431_시리얼번호 {
	static int N;
	static String[] arr;
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		arr = new String[N];
		
		for(int n=0; n<N; n++) {
			arr[n] = scan.next();
		}
		
		for(int i=N-1; i>0; i--) {
			for(int j=0; j<i; j++) {
				if(compare(arr[j], arr[j+1])) {
					String temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		for (String string : arr) {
			System.out.println(string);
		}
		
	}// main

public static boolean compare(String a, String b) { // true면 순서변경
	if(a.length() > b.length()) {
		return true;
	}else if(a.length() == b.length()) {
		int sumA = 0;
		int sumB = 0;
		
		for(int i=0; i<a.length(); i++) {
			if(Character.isDigit(a.charAt(i))) {
				sumA += (a.charAt(i) -'0');
			}
		}
		for(int i=0; i<b.length(); i++) {
			if(Character.isDigit(b.charAt(i))) {
				sumB += (b.charAt(i) -'0');
			}
		}
		if(sumA > sumB) {
			return true;
		}else if(sumA == sumB) {
			if(a.compareTo(b) > 0) {
				return true;
			}
		}
	}
	
	return false;
}
	
}
