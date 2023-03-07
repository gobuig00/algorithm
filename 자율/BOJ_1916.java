package so;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class BOJ_1916 {
    static int N,M;
    static ArrayList<pair>[] al;
    static PriorityQueue<pair> q;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(in.readLine());
        M=Integer.parseInt(in.readLine());
        al = new ArrayList[N+1];
        int [] dis = new int [N+1];
        for(int i=1;i<=N;i++){
            al[i]=new ArrayList<>();
        }
        for(int i=0;i<M;i++) {
                StringTokenizer st= new StringTokenizer(in.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                al[from].add(new pair(to,d));
        }
        q= new PriorityQueue<>(new Comparator<pair>() {
            @Override
            public int compare(pair o1, pair o2) {
                return o1.y-o2.y;
            }
        });
        StringTokenizer st= new StringTokenizer(in.readLine());
        int from = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());
        for(int i=1;i<=N;i++){
            dis[i]=Integer.MAX_VALUE;
        }
        dis[from]=0;

        q.offer(new pair(from,0));
        while(!q.isEmpty()){
            int t= q.peek().x;
            int d=q.poll().y;
            if(dis[t]<d){
                continue;
            }
            for(int i=0;i<al[t].size();i++){
                int next = al[t].get(i).x;
                int nextDis = al[t].get(i).y+d;
                if(dis[next]>nextDis){
                    dis[next]=nextDis;
                    q.offer(new pair(next,nextDis));
                }
            }

        }
        System.out.println(dis[to]);

    }
    static class pair{
        int x,y;

        public pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static class bus{
        int f,t,d;

        public bus(int f, int t, int d) {
            this.f = f;
            this.t = t;
            this.d = d;
        }
    }
}
