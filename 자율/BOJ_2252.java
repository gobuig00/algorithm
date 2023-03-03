package so;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2252 {
    static int N, M;
    static ArrayList<Integer>[] al;
    static boolean[] visit;
    static int[] ck;
    static Queue<Integer> q;
    static Deque<Integer> dq;
    static Stack<Integer> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        al = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            al[i] = new ArrayList<>();
        }
        visit = new boolean[N + 1];
        ck = new int[N + 1];
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(in.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            al[from].add(to);
            ck[to]++;
        }
        stack = new Stack<>();
        dq = new LinkedList<>();
  //      dfs(1);
//        BFS
        q = new LinkedList<>();
        for(int i=1;i<=N;i++){
            if(ck[i]==0){
                q.offer(i);
            }
        }
        bfs();

        for(int i=1;i<=N;i++){
            System.out.println(dq.pollFirst());
        }

    }

        static void bfs(){


        while(!q.isEmpty()){
            int ed = q.poll();
            if(visit[ed]){
                continue;
            }
            visit[ed]=false;
            dq.addLast(ed);
            for(int i=0;i<al[ed].size();i++){
                ck[al[ed].get(i)]--;
                if(ck[al[ed].get(i)]==0){
                    q.offer(al[ed].get(i));

                }
            }
        }
    static void dfs(int start) {

        stack.push(start);
        for(int i=0;i<al[start].size();i++){
           stack.push(al[start].get(i));
        }
    }
}

