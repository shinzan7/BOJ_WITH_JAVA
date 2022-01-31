package com.ssafy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P1120_문자열 {

	public static void main(String[] args){

		Scanner scan = new Scanner(System.in);
		String str1 = scan.next();
		String str2 = scan.next();
		scan.close();
		
		List<Character> copy1 = new ArrayList<Character>();
		List<Character> copy2 = new ArrayList<Character>();
		for (Character c : str1.toCharArray()) {
			copy1.add(c);
		}
		for (Character c : str2.toCharArray()) {
			copy2.add(c);
		}
		
		int cnt = Integer.MAX_VALUE; // 두 문자열의 차이의 개수
		int temp = 0;
		
		for(int i=0; i<str2.length() - str1.length() + 1; i++) {// 검사 시작위치
			for(int j=0; j<str1.length(); j++) {// str1 문자 한개씩 검사
				if(copy1.get(j).equals(copy2.get(i + j)));
				else {
					temp++;
				}
			}
			if(cnt > temp) { // 최솟값 갱신
				cnt = temp;
			}
			temp = 0; // temp 초기화
		}
		
		System.out.println(cnt);
		
	}// main

}
