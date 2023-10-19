import java.io.IOException;
import java.util.*;

public class stack_q_3 {
    public static void main(String args[])throws IOException {

        int[] progresses = {95,90,99,99,80,99};
        int[] speeds = {1,1,1,1,1,1};

        int[] answer = {};
        int count = 1;

        ArrayList<Integer> value = new ArrayList<>();
        boolean[] progresses_pass = new boolean[progresses.length];
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
//        for(int k = 0; k < cycle.length; k++){
//
//            if(progresses_pass[k] == false) {
//                progresses_pass[k] = true;
//                for(int i = k+1; i < cycle.length; i++){
//                    if(cycle[k] >= cycle[i] && progresses_pass[i] == false) {
//                        progresses_pass[i] = true;
//                        count++;
//                    }
//                }
//                value.add(count+1);
//                count = 0;
//            }
//        }
        for(int i = 0; i < cycle.length-1; i++){
            int standard_value = i;
            progresses_pass[i] = true;
            int cy_time = 0;
            if(cycle[i]%speeds[i] == 0){
                cy_time = cycle[i]/speeds[i];
            }else{
                cy_time = cycle[i]/speeds[i] + 1;
            }

            for(int j = i+1; j < cycle.length; j++){
                if(cycle[j]%speeds[j] == 0){
                    if(cy_time >= cycle[j]/speeds[j]){
                        progresses_pass[j] = true;
                    }
                }else{
                    if(cy_time >= cycle[j]/speeds[j] + 1){
                        progresses_pass[j] = true;
                    }
                }

                for(int k = j; k < progresses_pass.length; k++){
                   if(progresses_pass[k] == false) break;
                        count++;
                }
                value.add(count);
                count = 0;
            }
            System.out.println(Arrays.toString(progresses_pass));



        }

        System.out.println(value);
        System.out.println(Arrays.toString(cycle));
//        System.out.println(Arrays.toString(progresses_pass));

    }
}
