package so;
import java.util.*;
import java.lang.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;

public class P_42891 {
    public static void main(String[] args) {
        int [] food_times={3,1,2};
        long k = 5;
        int size = food_times.length;
        int [] clone = food_times.clone();
        Arrays.sort(clone);
        int index =0;
        int ans=0;
        if(k>clone[index]){
            ans=size%5;
        }
        while(k>clone[index]){
            
        }


    }
}
