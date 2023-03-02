package so;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1920 {
    static int [] arr;
    static int N,M;
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N= Integer.parseInt(in.readLine());
        arr = new int[N];
        StringTokenizer st= new StringTokenizer(in.readLine());
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        M = Integer.parseInt(in.readLine());
        st=new StringTokenizer(in.readLine());
        for(int i=0;i<M;i++){
            ans=0;
            bs(Integer.parseInt(st.nextToken()),0,N-1);
            System.out.println(ans);
        }

    }
    static void bs(int s,int first,int last){
        if(first == last){
            if(arr[last]==s){
                ans=1;
                return;
            }else{
                ans=0;
                return;
            }
        }else{
            int mid= (first+last)/2;
            if(arr[mid]<s){
                bs(s,mid+1,last);
            }else {
                bs(s,first,mid);
            }
        }

    }
}
