package so;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_14938 {
    static int N, M, R;
    static ArrayList<Item>[] al;
    static int[] dis;
    static boolean[] visit;
    static PriorityQueue<Item> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        al = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            al[i] = new ArrayList<>();
        }

        int[] arr = new int[N + 1];
        st = new StringTokenizer(in.readLine());
        for (int i = 1; i <= N; i++) {

            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(in.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int dis = Integer.parseInt(st.nextToken());
            al[from].add(new Item(to, dis));
            al[to].add(new Item(from, dis));
            System.out.println(i);
        }
        int max = 0;
        System.out.println(1);
        for (int i = 1; i <= N; i++) {
            dis = new int[N + 1];
            visit = new boolean[N + 1];
            pq = new PriorityQueue<>((x1, x2) -> x1.d - x2.d);
            pq.offer(new Item(i, 0));
            while (!pq.isEmpty()) {
                int t = pq.peek().t;
                int d = pq.poll().d;
                visit[t] = true;
                for (int j = 0; j < al[t].size(); j++) {
                    int next = al[t].get(i).t;
                    int di = al[t].get(i).d;
                    if (visit[next]) {
                        continue;
                    }
                    if (dis[next] > di + d) {
                        dis[next] = di + d;
                        pq.offer(new Item(next, di + d));
                    }
                }
            }
            int cnt = 0;
            for (int j = 1; j <= N; j++) {
                if (dis[j] <= M) {
                    cnt += arr[j];
                }
            }
            max = Math.max(max, cnt);
        }
        System.out.println(max);

    }

    static class Item {
        int t, d;

        public Item(int t, int d) {
            this.t = t;
            this.d = d;
        }
    }
}
