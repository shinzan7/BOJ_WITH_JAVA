package backjoon;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class 실패_P2615_오목 {

	static int[][] map = new int[19][19];

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Test5.txt"));

		// 구현하세요.
		Scanner scan = new Scanner(System.in);

		for (int r = 0; r < 19; r++) {
			for (int c = 0; c < 19; c++) {
				map[r][c] = scan.nextInt();
			}
		}
		scan.close();
		// 입력완료
		int win = 0; // 승부결과
		int winR = 0;
		int winC = 0;

		outer: for (int r = 0; r < 19; r++) {
			for (int c = 0; c < 19; c++) {
				if (map[r][c] == 1) { // 검은 돌
					// 우상
					if (rightUp(r, c, 1)) {
						win = 1;
						winR = r + 1;
						winC = c + 1;
						break outer;
					}
					// 우
					else if (right(r, c, 1)) {
						win = 1;
						winR = r + 1;
						winC = c + 1;
						break outer;
					}

					// 우하
					else if (rightDown(r, c, 1)) {
						win = 1;
						winR = r + 1;
						winC = c + 1;
						break outer;
					}
					// 하
					else if (down(r, c, 1)) {
						win = 1;
						winR = r + 1;
						winC = c + 1;
						break outer;
					}

				} else if (map[r][c] == 2) { // 흰 돌
					// 우상
					if (rightUp(r, c, 2)) {
						win = 2;
						winR = r + 1;
						winC = c + 1;
						break outer;
					}
					// 우
					else if (right(r, c, 2)) {
						win = 2;
						winR = r + 1;
						winC = c + 1;
						break outer;
					}

					// 우하
					else if (rightDown(r, c, 2)) {
						win = 2;
						winR = r + 1;
						winC = c + 1;
						break outer;
					}
					// 하
					else if (down(r, c, 2)) {
						win = 2;
						winR = r + 1;
						winC = c + 1;
						break outer;
					}

				}
			}
		}
		System.out.println(win);

		if (win != 0) {
			System.out.print(winR + " " + winC);
		}

	} // main
	
	// 4가지 방향에 따른 메소드 정의

	public static boolean rightUp(int sr, int sc, int color) { // 우상
		boolean result = false;

		if (sr - 4 >= 0 && sc + 4 < 19) { // 배열 벗어나는지 검사

			for (int i = 1; i < 5; i++) { // 4번 탐색
				if (map[sr - i][sc + i] == color) {
					result = true;
				} else {
					result = false;
					break;
				}
			}

			if (sr - 5 >= 0 && sc + 5 < 19) {
				if (map[sr - 5][sc + 5] == color) { // 6번째 돌이 같은색인지 확인
					result = false;
				}
			}

		}
		return result;
	}

	public static boolean rightDown(int sr, int sc, int color) { // 우하
		boolean result = false;

		if (sr + 4 < 19 && sc + 4 < 19) { // 배열 벗어나는지 검사

			for (int i = 1; i < 5; i++) { // 4번 탐색
				if (map[sr + i][sc + i] == color) {
					result = true;
				} else {
					result = false;
					break;
				}
			}

			if (sr + 5 < 19 && sc + 5 < 19) {
				if (map[sr + 5][sc + 5] == color) { // 6번째 돌이 같은색인지 확인
					result = false;
				}
			}

		}
		return result;
	}

	public static boolean right(int sr, int sc, int color) { // 우
		boolean result = false;

		if (sc + 4 < 19) { // 배열 벗어나는지 검사

			for (int i = 1; i < 5; i++) { // 4번 탐색
				if (map[sr][sc + i] == color) {
					result = true;
				} else {
					result = false;
					break;
				}
			}

			if (sc + 5 < 19) {
				if (map[sr][sc + 5] == color) { // 6번째 돌이 같은색인지 확인
					result = false;
				}
			}

		}
		return result;
	}

	public static boolean down(int sr, int sc, int color) { // 하
		boolean result = false;

		if (sr + 4 < 19) { // 배열 벗어나는지 검사

			for (int i = 1; i < 5; i++) { // 4번 탐색
				if (map[sr + i][sc] == color) {
					result = true;
				} else {
					result = false;
					break;
				}
			}

			if (sr + 5 < 19) {
				if (map[sr + 5][sc] == color) { // 6번째 돌이 같은색인지 확인
					result = false;
				}
			}

		}
		return result;
	}

}
