package so;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class a3 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s = in.readLine();
        int cnt=0;
        char last= s.charAt(0);
        for(int i=1;i<s.length();i++){
            if(last!=s.charAt(i)){
                cnt++;
                last=s.charAt(i);
            }
        }
        System.out.println(cnt);
    }
}
