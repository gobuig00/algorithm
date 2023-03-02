package so;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_2606 {
    static ArrayList<Integer>[] al;
    static boolean [] visit;
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N= Integer.parseInt(in.readLine());
        al = new ArrayList[N+1];
        for(int i=0;i<N+1;i++){
            al[i]=new ArrayList<>();
        }
        visit = new boolean[N+1];
        int V = Integer.parseInt(in.readLine());
        for(int i=0;i<V;i++){
            StringTokenizer st= new StringTokenizer(in.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            al[from].add(to);
            al[to].add(from);
        }
        spread(1);
        System.out.println(cnt-1);
    }
    static void spread(int e){
        if(visit[e]){
            return;
        }
        visit[e]=true;
        cnt++;
        for(int i=0;i<al[e].size();i++){
            spread(al[e].get(i));
        }
    }
}
