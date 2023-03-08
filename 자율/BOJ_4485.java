package so;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_4485 {
    static int N;
    static int [][] map;
    static int [][] dis;
    static int []dx={1,-1,0,0};
    static int []dy={0,0,1,-1};
    static PriorityQueue<loc> pq;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int tc=0;
        while(true){
            tc++;
            N=Integer.parseInt(in.readLine());
            if(N==0){
                break;
            }
            map = new int [N][N];
            dis = new int [N][N];
            pq = new PriorityQueue<>(new Comparator<loc>() {
                @Override
                public int compare(loc o1, loc o2) {
                    return o1.d-o2.d;
                }
            });
            for(int i=0;i<N;i++){
                StringTokenizer st= new StringTokenizer(in.readLine());
                for(int j=0;j<N;j++){
                    dis[i][j] = Integer.MAX_VALUE;
                    map[i][j]=Integer.parseInt(st.nextToken());
                }
            }
            pq.offer(new loc(0,0,map[0][0]));
            dis[0][0]=0;
            while(!pq.isEmpty()){
                int x=pq.peek().x;
                int y=pq.peek().y;
                int d=pq.poll().d;
                for(int i=0;i<4;i++){
                    int nx=x+dx[i];
                    int ny= y+dy[i];
                    if(nx<0 || ny<0 || nx>=N || ny>=N){
                        continue;
                    }
                    int a=0;
                    if(dis[ny][nx]>d+map[ny][nx]){
                        dis[ny][nx]=d+map[ny][nx];
                        pq.add(new loc(nx,ny,dis[ny][nx]));
                    }
                }
            }
            System.out.println("Problem "+tc+": "+dis[N-1][N-1]);

        }
    }
    static class loc{
        int x, y, d;

        public loc(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
}
