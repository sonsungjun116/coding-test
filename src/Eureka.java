import java.io.*;
import java.util.*;


public class Eureka {

    public static void main(String args[])throws IOException{

        // 가우스의 삼각수 공식

        //Tn = n(n+1)/2
        // 자연수가 정확히 3개의 삼각수의 합으로 표현 될 수 있는지 여부를 판단하는 프로그램 작성

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcase_count = Integer.parseInt(br.readLine());
        int input_value[] = new int[testcase_count];

        for(int i = 0; i < testcase_count; i++){
            input_value[i] = Integer.parseInt(br.readLine());
        }

        System.out.println("input_value - > " + Arrays.toString(input_value));

        ArrayList<Integer> array_list = new ArrayList<Integer>();
        for(int i = 1; i*(i+1)/2 < 1000; i++){
            array_list.add(i*(i+1)/2);
        }

        System.out.println("array_list = " + array_list);

        // 1. 3개의 삼각수가 모두 같은 경우
        // 2. 2개의 삼각수가 같은 경우
        // 3. 3개의 삼각수가 모두 다른 경우








    }

}
