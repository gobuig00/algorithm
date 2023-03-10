package so;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1504 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(in.readLine());
        N= Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        for(int i=0;i<N;i++){
            st= new StringTokenizer(in.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int dis = Integer.parseInt(st.nextToken());
        }
        st= new StringTokenizer(in.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

    }
    static class pair{
        int t,d;

        public pair(int t, int d) {
            this.t = t;
            this.d = d;
        }
    }
}
