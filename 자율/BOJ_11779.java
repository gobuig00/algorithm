package so;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_11779 {
    static int N, M;
    static ArrayList<bus>[] al;
    static pair[] dis;
    static boolean [] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        M = Integer.parseInt(in.readLine());
        al = new ArrayList[N + 1];
        dis = new pair[N + 1];
        visit = new boolean[N+1];
        for (int i = 0; i <= N; i++) {
            al[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int dis = Integer.parseInt(st.nextToken());
            al[from].add(new bus(to, dis));
        }
        StringTokenizer st = new StringTokenizer(in.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        PriorityQueue<bus> pq = new PriorityQueue<>((x1, x2) -> x1.d - x2.d);
        pq.offer(new bus(start, 0));
        init(N);
        dis[start] = new pair(0, 0);
        while (!pq.isEmpty()) {
            int t = pq.peek().t;
            int d = pq.poll().d;
            if(t==end){
                break;
            }
            visit[t]=true;
            for (int i = 0; i < al[t].size(); i++) {
                int next = al[t].get(i).t;
                int di = al[t].get(i).d;
                if (!visit[next]&&dis[next].x > d + di) {
                    dis[next].x = d + di;
                    dis[next].y = t;
                    pq.offer(new bus(next, d + di));

                }
            }
        }
        int a = end;
        ArrayList<Integer> route = new ArrayList<>();
        route.add(a);
        while (true) {
            if (dis[a].y == 0) {
                break;
            }
            route.add(dis[a].y);
            a = dis[a].y
            ;
        }

        System.out.println(dis[end].x);
        System.out.println(route.size());
        for (int i = route.size() - 1; i >= 0; i--) {
            System.out.print(route.get(i)+" ");
        }


    }

    static void init(int x) {
        for (int i = 1; i <= x; i++) {
            dis[i] = new pair(Integer.MAX_VALUE, 0);
        }
    }

    static class pair {
        int x, y;

        public pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class bus {
        int t, d;

        public bus(int t, int d) {
            this.t = t;
            this.d = d;
        }
    }
}
