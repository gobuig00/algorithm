package so;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1719 {
    static int N,M;
    static int [][]map;
    static int []dis;
    static int [][]ans;
    static PriorityQueue<pair> pq;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(in.readLine());
        pq=new PriorityQueue<>((x1,x2)->x1.d-x2.d);
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        map=new int[N+1][N+1];
        dis=new int[N+1];
        for(int i=0;i<M;i++){
            st = new StringTokenizer(in.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int dis = Integer.parseInt(st.nextToken());
            map[from][to]=dis;
        }
        for(int i=1;i<=N;i++){
            dj(i,map[i][i]);
        }


    }
    static void init(){
        for(int i=1;i<=N;i++){
            dis[i]=Integer.MAX_VALUE;
        }
    }
    static void dj(int q,int w){
        init();
        pq=new PriorityQueue<>((x1,x2)->x1.d-x2.d);
        pq.offer(new pair(q,w));
        while(!pq.isEmpty()){
            int to=pq.peek().to;
            int d=pq.poll().d;
            for(int i=1;i<=N;i++){
                if(map[to][i]==0){
                    continue;
                }
                if(dis[i]>d+map[to][i]){
                    dis[i]=d+map[to][i];
                    pq.offer(new pair(i,dis[i]));
                }
            }
        }
        for(int i=1;i<=N;i++){
            if(q==i){
                System.out.print('-'+" ");
            }else{
                System.out.print(dis[i]+" ");
            }
        }
        System.out.println();
    }
    static class pair{
        int to, d;

        public pair(int to, int d) {
            this.to = to;
            this.d = d;
        }
    }
}
