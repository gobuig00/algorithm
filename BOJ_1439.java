package so;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1439 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s1= in.readLine();
        String s2=s1;
        char[] arr1 = s1.toCharArray();
        char[] arr2= s2.toCharArray();
        int cnt1=0;
        int cnt2=0;
        for(int i=0;i<s1.length();i++){
            if(arr1[i]=='0') {
                int right = i;
                while (right<s1.length()&&arr1[right] == '0') {
                    arr1[right] = '1';
                    right++;
                }
                cnt1++;
            }
            if(arr2[i]=='1'){
                int left =i;
                while(left<s1.length()&&arr2[left]=='1'){
                    arr2[left]='0';
                    left++;
                }
                cnt2++;
            }
        }
        System.out.println(Math.min(cnt1,cnt2));

    }
}
