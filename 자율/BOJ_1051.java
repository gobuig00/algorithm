package so;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1051 {
    static int max=1;
    static int [][] map;
    static int x,y;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(in.readLine());
        y=Integer.parseInt(st.nextToken());
        x=Integer.parseInt(st.nextToken());
        map = new int[y][x];
        for(int i=0;i<y;i++){
            String s=in.readLine();
            for(int j=0;j<x;j++){
                map[i][j]=s.charAt(j)-'0';
            }
        }

        search(false,Math.min(x,y));
        System.out.println(max*max);

    }
    static void search(boolean flag,int h){
        if(flag || h==0){
            return;
        }
        for(int i=0;i<y-h;i++){
            for(int j=0;j<x-h;j++){
                if(map[i][j]==map[i][j+h] && map[i+h][j]==map[i][j] && map[i+h][j+h] ==map[i][j]){
                    flag=true;
                    max=Math.max(max,h+1);
                    break;
                }
            }
            if(flag){
                break;
            }
        }
        search(flag,h-1);

    }
}
