package so;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_1063 {
    static int N;
    static int[][] map;
    static int[] dx = {1, -1, 0, 0, 1, -1, 1, -1};
    static int[] dy = {0, 0, -1, 1, 1, 1, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        String king = st.nextToken();
        String stone = st.nextToken();
        N = Integer.parseInt(st.nextToken());
        int KingX = king.charAt(0) - 64;
        int KingY = king.charAt(1) - 48;
        int stoneX = stone.charAt(0) - 64;
        int stoneY = stone.charAt(1) - 48;
        map = new int[9][9];
        Map<String, Integer> comd = new HashMap<>();
        comd.put("R", 0);
        comd.put("L", 1);
        comd.put("B", 2);
        comd.put("T", 3);
        comd.put("RT", 4);
        comd.put("LT", 5);
        comd.put("RB", 6);
        comd.put("LB", 7);
        for (int i = 0; i < N; i++) {
            String s = in.readLine();
            int num = comd.get(s);
            int tky = KingY;
            int tkx = KingX;
            int sky = stoneY;
            int skx = stoneX;
            if (KingY + dy[num] >= 1 && KingX + dx[num] >= 1 && KingY + dy[num] <= 8 && KingX + dx[num] <= 8) {
                KingY += dy[num];
                KingX += dx[num];
                if ((stoneY == KingY) && (stoneX == KingX)) {
                    if (stoneY + dy[num] >= 1 && stoneX + dx[num] >= 1 && stoneY + dy[num] <= 8 && stoneX + dx[num] <= 8) {
                        stoneY += dy[num];
                        stoneX += dx[num];
                    }else{
                        KingY=tky;
                        KingX=tkx;
                    }
                }

            }
        }
        KingX+=64;
        stoneX+=64;
        String kingL = (char) KingX + Integer.toString(KingY);
        String stoneL = (char) stoneX + Integer.toString(stoneY);
        System.out.println(kingL);
        System.out.println(stoneL);
    }
}
