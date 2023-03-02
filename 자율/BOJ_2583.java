package so;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2583 {
    static int N,M,K;
    static int [][] map;
    static boolean [][] visit;
    static PriorityQueue<Integer> pq;
    static int[] dx={1,-1,0,0};
    static int[] dy={0,0,1,-1};
    static Queue<pair> q;
    static int cnt=1;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(in.readLine());
        M=Integer.parseInt(st.nextToken());
        N=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        q=new LinkedList<>();
        map=new int [N][M];
        for(int i=0;i<K;i++){
            st=new StringTokenizer(in.readLine());
            int lx=Integer.parseInt(st.nextToken());
            int ly=Integer.parseInt(st.nextToken());
            int rx=Integer.parseInt(st.nextToken());
            int ry=Integer.parseInt(st.nextToken());
            for(int j=ly;j<=ry-1;j++){
                for(int k=lx;k<=rx-1;k++){
                    map[j][k]=1;
                }
            }
        }
        int mapCnt=0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(!visit[i][j]){
                    q.offer(new pair(j,i));
                    visit[i][j]=true;
                    mapCnt++;
                    bfs();
                }
                pq.offer(cnt);
            }
            cnt=1;
        }
        System.out.println(mapCnt);
        for (Integer integer : pq) {
            System.out.print(integer+" ");
        }

    }
    static void bfs(){
        while(!q.isEmpty()){
            int x= q.peek().x;
            int y=q.poll().x;
            for(int i=0;i<4;i++){
                int nx=x+dx[i];
                int ny=y+dy[i];
                if(nx<0||ny<0||nx>=M||ny>=N||visit[ny][nx] || map[ny][nx]==0){
                    continue;
                }
                visit[ny][nx]=true;
                q.offer(new pair(nx,ny));
                cnt++;
            }
        }
    }
    static class pair{
        int x,y;

        public pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
