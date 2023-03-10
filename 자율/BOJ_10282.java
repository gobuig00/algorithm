package so;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_10282 {
    static int N,D,C;
    static int []dis;
    static boolean[] visit;
    static ArrayList<Vir>[] al;
    static PriorityQueue<Vir> pq;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(in.readLine());
        for(int t=0;t<tc;t++){
            StringTokenizer st= new StringTokenizer(in.readLine());
            N= Integer.parseInt(st.nextToken());
            D= Integer.parseInt(st.nextToken());
            C= Integer.parseInt(st.nextToken());
            visit = new boolean[N+1];
            dis= new int[N+1];
            dis[C]=0;
            visit[C]=true;
            for(int i=1;i<=N;i++){
                dis[i]=Integer.MAX_VALUE;
            }
            al = new ArrayList[N+1];
            pq=new PriorityQueue<>((x1,x2)->x1.d-x2.d);
            for(int i=1;i<=N;i++){
                al[i] = new ArrayList<>();
            }
            for(int i=0;i<D;i++){
                st = new StringTokenizer(in.readLine());

                int to = Integer.parseInt(st.nextToken());
                int from = Integer.parseInt(st.nextToken());
                int dis = Integer.parseInt(st.nextToken());
                al[from].add(new Vir(to,dis));

            }
            pq.offer(new Vir(C,0));
            while(!pq.isEmpty()){
                int to= pq.peek().t;
                int d= pq.poll().d;
                visit[to]=true;
                for(int i=0;i<al[to].size();i++){

                    int next=al[to].get(i).t;
                    int di=al[to].get(i).d;
                    if(visit[next]){
                        continue;
                    }
                    if(dis[next]>d+di){
                        dis[next]=di+d;

                        pq.offer(new Vir(next,di+d));
                    }
                }

            }
            int cnt=1;
            int max=0;
            for(int i=1;i<=N;i++){
                if(dis[i]!=Integer.MAX_VALUE){
                    cnt++;
                    max=Math.max(dis[i],max);
                }
            }
            System.out.println(cnt+" "+max);


        }

    }
    static class Vir{
        int t,d;

        public Vir(int t, int d) {
            this.t = t;
            this.d = d;
        }
    }
}
