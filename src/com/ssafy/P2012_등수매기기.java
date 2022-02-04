package com.ssafy;

import java.util.Arrays;
import java.util.Scanner;

public class P2012_등수매기기 {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		long sum = 0;
		int[] scores = new int[N];
		
		for(int i=0; i<N; i++) {
			scores[i] = scan.nextInt();
		}
		scan.close();
		
		Arrays.sort(scores);
		
		for(int i=0; i<N; i++) {
			sum += Math.abs(scores[i]-(i+1));
		}
		
		System.out.println(sum);
		
	}// main

}
