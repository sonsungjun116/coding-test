import javax.sound.midi.SysexMessage;
import java.io.*;
import java.util.*;



public class seven_dwarf {

    public static void main(String args[])throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int sum = 0;
        // 백설공주 난쟁이 문제

        // 완전 탐색 알고리즘

        // 아홉개의 줄에 걸쳐 난쟁이들의 키가 주어지고 주어지는 키는 100을 넘지 않는 자연수이며, 아홉 난쟁이의 키는 모두 다르며, 가능한 정답이 여러 가지인 경우에는
        // 아무거나 출력한다.

        // 9가지의 숫자중 7가지를 선별하여 그들의 합이 100

        // 접근 방식
        // 9가지의 값을 전부 더한 후 이중 for문을 돌려 두개의 인덱스를 순회하면서 뺴보고 그 값이 100이 나오는 경우 배열값 출력


        int input_array[] = new int[9]; // 처음 값을 입력받는 배열
//        int seven_dwarf_array[] = new int[7];   // 9개의 입력값중 7개의 값을 선정
        //int remain_array[] = new int[2]; // 나머지 선정되지 않은 2개의 값

        for (int i = 0; i < input_array.length; i++) {
            input_array[i] = Integer.parseInt(br.readLine());
        }

        System.out.println("input_array = " + Arrays.toString(input_array));
        sum = Arrays.stream(input_array).sum();
        System.out.println("sum = " + sum);

        for(int i = 0; i < input_array.length-1; i++){
            for(int j = i+1; j < input_array.length; j++){
                if(sum - input_array[i] - input_array[j] == 100){
                    System.out.println("sum = > " + sum);
                    System.out.println("answer1 array = " + input_array[i]);
                    System.out.println("answer2 array = " + input_array[j]);
                    System.out.println("sum answer = " + ((sum - input_array[i]) - input_array[j]));
                    int minus1 = input_array[i];
                    int minus2 = input_array[j];

                    Arrays.sort(input_array);
                    System.out.println("minus1 = " + minus1);
                    System.out.println("minus2 = " + minus2);
                    for(int k = 0; k < input_array.length; k++){
                        if(input_array[k] == minus1 || input_array[k] == minus2)continue;
                            System.out.println("answer -> " + input_array[k]);


                    }

                }
            }


        }





    }
}

