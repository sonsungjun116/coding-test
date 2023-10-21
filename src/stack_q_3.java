import java.io.IOException;
import java.util.*;

public class stack_q_3 {
    public static void main(String args[])throws IOException {

//        int[] progresses = {95,90,99,99,80,99};
//        int[] speeds = {1,1,1,1,1,1};

        int[] progresses = {93,30,55};
        int[] speeds = {1,30,5};

        int[] answer = {};
        int count = 1;

        ArrayList<Integer> value = new ArrayList<>();
        //boolean[] progresses_pass = new boolean[progresses.length];
        int [] cycle = new int[progresses.length];

        // 1. 100을 뺀 나머지를 구해 남은 업무 측정
        for(int i = 0; i < progresses.length; i++){
            progresses[i] = 100 - progresses[i];
        }
        // 2. 각각 speed에 따른 cycle계산
        for(int j = 0; j < cycle.length; j++){
            if(progresses[j] % speeds[j] == 0){
                cycle[j] = progresses[j] / speeds[j];
            }else{
                cycle[j] = (progresses[j] / speeds[j]) + 1;
            }
        }
        // 3. 사이클 구상하기 ex 7,3,9
        int standard = cycle[0];
        for(int i = 1; i < cycle.length; i++){

            // value arraylist에 값대입
            if(standard >= cycle[i]){
                count++;
            }else{
                value.add(count);
                count = 1;
                standard = cycle[i];
            }

        }
        value.add(count);

        System.out.println(Arrays.toString(cycle));
        System.out.println(value);


    }
}
