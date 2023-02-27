package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Study0227_3273 {
    static int cnt=0;
    static int n,x;
    static int [] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(in.readLine());
        arr = new int [n];
        StringTokenizer st= new StringTokenizer(in.readLine());
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        x = Integer.parseInt(in.readLine());
        Arrays.sort(arr);
        int start=0;
        int end=n-1;
        sum(start,end);
        System.out.println(cnt);
    }
    static void sum(int start,int end){
        while(true){
            if(start==end || start>end){

                    break;
            }
            int sum = arr[start]+arr[end];
            if(sum==x){
                start++;
                end--;
                cnt++;
            }else if(sum>x){
                end--;
            }else if(sum<x){
               start++;
            }

        }
    }
}
