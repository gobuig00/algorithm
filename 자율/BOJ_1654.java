package so;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1654 {
    static int N, K;
    static int [] arr;
    static long max=1;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int [N];
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(in.readLine());
        }
        Arrays.sort(arr);
        bs(1,arr[N-1]);
        System.out.println(max);

    }
    static void bs(long first,long last){
        if(first>last){
            return;
        }
        long mid = (first+last)/2;
        long a=count(mid);
        if(a>=K){
            max = Math.max(max,mid);
            bs(mid+1,last);
        }else{
            bs(first,mid-1);
        }


    }
    static long count(long t){
        long cnt=0;
        for (int i : arr) {
            cnt+=(i/t);
        }
        return cnt;
    }
}
