package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Study0227_2470 {
    static int []arr;
    static int N;
    static int leftV,rightV;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(in.readLine());
        StringTokenizer st= new StringTokenizer(in.readLine());
        arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        int left=0;
        int right=N-1;
        Arrays.sort(arr);
        sum(left,right);
        System.out.println(leftV+" "+rightV);
    }
    static void sum (int left, int right){
        while(true){
            if(left==right || left>right){
                break;
            }
            int sum = arr[left]+arr[right];
            if(Math.abs(sum)<min){
                leftV=arr[left];
                rightV=arr[right];
                min=Math.abs(leftV+rightV);
            }

            if(sum>0){
                right--;
            }else if(sum<0){
                left++;
            }else{
                break;
            }

        }
    }
}
