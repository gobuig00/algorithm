import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Study0220_16198 {
    static int N;
    static int arr[];
    static boolean visit[];
    static int max=0;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(in.readLine());
        arr= new int [N];
        visit = new boolean [N];
        StringTokenizer st= new StringTokenizer(in.readLine());
        ArrayList<Integer> al = new ArrayList<>();
        for(int i=0;i<N;i++){
           arr[i]=Integer.parseInt(st.nextToken());
        }
        dfs(0,0);
        System.out.println(max);
    }
    static void dfs(int d, int sum){
      if(N-2==d){
          max=Math.max(max,sum);
          return;
      }
      for(int i=1;i<N-1;i++){
          if(!visit[i]){
              visit[i]=true;
              int leftI=i-1;
              int rightI=i+1;
              while(visit[leftI]){
                  leftI--;
              }
              while(visit[rightI]){
                  rightI++;
              }
              sum+=arr[leftI]*arr[rightI];

              dfs(d+1,sum);
              visit[i]=false;
              sum-=arr[leftI]*arr[rightI];
          }
      }
    }
}
