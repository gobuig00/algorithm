package so;

import java.io.*;
import java.lang.*;
import java.util.*;

public class a1 {
    static int N;
    static int [] map;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(in.readLine());
        map=new int [N];
        StringTokenizer st= new StringTokenizer(in.readLine());
        for(int i=0;i<N;i++){
            map[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(map);
        int cnt=0;
        int max=0;
        int maxCnt=0;
        for(int i=0;i<N;i++){
            cnt++;
            if(maxCnt<map[i]){
                maxCnt=map[i];
            }
            if(maxCnt==cnt){
                max++;
                cnt=0;
                maxCnt=0;
            }

        }
        System.out.println(max);



    }
}
