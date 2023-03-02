package so;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2630 {
    static int[][] map;
    static int[][] visit;
    static int N;
    static int bc, wc;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

            }
        }

        count(0, 0, 1);
        System.out.println(wc);
        System.out.println(bc);
    }

    static void count(int x, int y, int div) {

        int color = map[y][x];
        int size = N / div;

        boolean flag = true;
        for (int i = y; i < y + (N / div); i++) {

            for (int j = x; j < x + (N / div); j++) {
                if (map[i][j] != color) {
                    flag = false;
                    break;
                }
            }
            if (!flag) {
                break;
            }
        }
        if (flag) {
            if (color == 1) {
                bc++;

            } else {
                wc++;
            }
            return;
        } else {
            count(x, y, div * 2);
            count(x, y + size, div * 2);
            count(x + size, y, div * 2);
            count(x + size, y + size, div * 2);
        }
        if (size == 1) {
            return;
        }


    }


}
