package so;

import java.io.BufferedReader;
import java.util.Scanner;

public class BOJ_1547 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N= sc.nextInt();
        int [] arr = {0,1,2,3};
        for(int i=0;i<N;i++){
            int a=sc.nextInt();
            int b=sc.nextInt();
            int temp;
            temp=arr[a];
            arr[a]=arr[b];
            arr[b]=temp;
        }
        for(int i=1;i<=3;i++){
            if(arr[i]==1){
                System.out.println(i);
                break;
            }
        }

    }
}
