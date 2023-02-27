package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Study0220_2447 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader in= new BufferedReader(new InputStreamReader(System.in));
        N= Integer.parseInt(in.readLine());
        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                if(i%3==1 || i%3==0){
                    System.out.print("*");
                }else{
                    if(j%3==1 || j%3==0){
                        System.out.print("*");
                    }else{
                        System.out.print(" ");
                    }
                }
            }
            System.out.println();
        }

    }

}
