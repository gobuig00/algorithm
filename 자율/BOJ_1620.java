package so;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_1620 {
    public static void main(String[] args) throws IOException {
        HashMap<String,Integer> hm = new HashMap<>();
        ArrayList<String> al = new ArrayList<>();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(in.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        for(int i=0;i<N;i++){
            String s = in.readLine();
            al.add(s);
            hm.put(s,i);
        }
        for(int i=0;i<M;i++){
            String s = in.readLine();
            if(s.charAt(0)>=48 && s.charAt(0)<=57){
                System.out.println(al.get(Integer.parseInt(s)-1));
            }else{
                System.out.println(hm.get(s)+1);
            }
        }
    }
}
