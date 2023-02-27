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
        int index = 0;
        while(k!=0){
            if(food_times[index]==0){
                if(index==size-1){
                    index=0;
                }else{
                    index++;
                }
                continue;
            }
            food_times[index]--;
            if(index==size-1){
                index=0;
            }
            index++;
            k--;
        }
        System.out.println(index);

    }
}
