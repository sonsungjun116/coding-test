import java.io.*;
import java.sql.SQLData;
import java.util.*;


public class Eureka {

    public static void main(String args[])throws IOException{

        // 가우스의 삼각수 공식

        //Tn = n(n+1)/2
        // 자연수가 정확히 3개의 삼각수의 합으로 표현 될 수 있는지 여부를 판단하는 프로그램 작성

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcase_count = Integer.parseInt(br.readLine());
        int input_value[] = new int[testcase_count];
        int answer[] = new int[testcase_count];

        for(int i = 0; i < testcase_count; i++){
            input_value[i] = Integer.parseInt(br.readLine());
        }

        System.out.println("input_value - > " + Arrays.toString(input_value));
        System.out.println("answer -> " + Arrays.toString(answer));
        // 1000 이하의 모든 삼각수 구하기
        ArrayList<Integer> array_list = new ArrayList<Integer>();
        for(int i = 1; i*(i+1)/2 <= 1000; i++){
            array_list.add(i*(i+1)/2);
        }

        System.out.println("array_list = " + array_list);
        System.out.println("array list size = " + array_list.size());

        // 1. 3개의 삼각수가 모두 같은 경우
        // 2. 2개의 삼각수가 같은 경우
        // 3. 3개의 삼각수가 모두 다른 경우

        // 3개의 수가 모두 같거나 2개의 수가 같고 나머지 수가 다른 경우
        //loop:
        for(int i = 0; i < input_value.length; i++){
            // 삼각수 중에서 정수값의 -2 보다 작은 수들의 삼각수를 넣은 list배열
            ArrayList<Integer> compare_list = new ArrayList<Integer>();
            for(int j = 0; j < array_list.size(); j++){
                if(array_list.get(j) <= input_value[i]-2){
                    compare_list.add(array_list.get(j));
                };
            };
            System.out.println("index -> " + i + " compare list -> " + compare_list);
            // 동일한 숫자가 두번 반복하거나 세번 반복한 숫자들의 합 구하기
            loop:
            for(int k = 0; k < compare_list.size(); k++){
                // 두번 반복할 변수
                int factor_value = compare_list.get(k);

                for(int t = 0; t < compare_list.size(); t++){

                    if((factor_value * 2) + compare_list.get(t) == input_value[i]){
                        System.out.println("k -> " + k + " t -> " + t + " factor -> "+ factor_value + " compare_list(t) -> " + compare_list.get(t));
                        answer[i] = 1;
                        break loop;
                    };
                };
            };
            // 3개의 삼각수가 모두 다른 경우
            loop2:
            for(int l = 0; l < compare_list.size();l++){

                int first = compare_list.get(l);
                for(int m = 1; m < compare_list.size(); m++) {

                    int seconde = compare_list.get(m);
                    for (int n = 2; n < compare_list.size(); n++) {
                        if ((first + seconde + compare_list.get(n)) == input_value[i]) {
                            System.out.println("first -> " + first + " seconde -> " + seconde + " compare_list.get(n) -> " +  compare_list.get(n));
                            answer[i] = 1;
                            break loop2;
                        }

                    }
                }
            }

        }

        for(int x = 0; x < input_value.length; x++){
            System.out.println("answer = "+ answer[x]);
        }



    }

}
