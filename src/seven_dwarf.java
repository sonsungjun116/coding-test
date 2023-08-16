import javax.sound.midi.SysexMessage;
import java.io.*;
import java.util.*;



public class seven_dwarf {

    public static void main(String args[])throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int sum = 0;
        int difference;
        int compare = 0;
        // 백설공주 난쟁이 문제

        // 완전 탐색 알고리즘

        // 아홉개의 줄에 걸쳐 난쟁이들의 키가 주어지고 주어지는 키는 100을 넘지 않는 자연수이며, 아홉 난쟁이의 키는 모두 다르며, 가능한 정답이 여러 가지인 경우에는
        // 아무거나 출력한다.

        // 9가지의 숫자중 7가지를 선별하여 그들의 합이 100

        // 접근 방식
        // 1. 9개의 입력값들을 오름차순으로 정렬하고 앞 배열부터 7개로 잘라서 배열에 넣고 검사를 시작
        // 2. 경우의수
        // 2-1 100보다 작은 경우
            // 100에서 합계 값을 빼고 어떠한 배열을 바꾸면 그 부족한 숫자만큼 채워지는지 확인
        // 2-2 100보다 큰 경우
            // 합계에서 100을 빼고 어떠한 배열을 바꾸면 그 넘치는 숫자만큼 차감 할 수 있는지 확인


        int input_array[] = new int[9]; // 처음 값을 입력받는 배열
        int seven_dwarf_array[] = new int[7];   // 9개의 입력값중 7개의 값을 선정
        int remain_array[] = new int[2]; // 나머지 선정되지 않은 2개의 값

        for (int i = 0; i < input_array.length; i++) {
            input_array[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(input_array);

        System.out.println("input_array = " + Arrays.toString(input_array));

        for(int i = 0; i < input_array.length; i++) {
            if(i < 7) {
                seven_dwarf_array[i] = input_array[i];
            }else {
                remain_array[i-7] = input_array[i];
            }
        }

        System.out.println("seven_dwarf_array = " + Arrays.toString(seven_dwarf_array));
        System.out.println("remain_array = " + Arrays.toString(remain_array));

        sum = Arrays.stream(seven_dwarf_array).sum();

        System.out.println("sum = " + sum);

        loop:
        if(sum == 100){
            System.out.println("answer = " + Arrays.toString(seven_dwarf_array));
        }else if (sum < 100){ // 합계가 100이하라면
            difference = 100 - sum;
            // remain_array 배열의 첫번째 요소 교환
            for(int i = 0; i < seven_dwarf_array.length; i++){
                int sum_value = (sum - seven_dwarf_array[i]) + remain_array[0];
                if(sum_value == 100) {
                    seven_dwarf_array[i] = remain_array[0];
                    System.out.println("answer = " + Arrays.toString(seven_dwarf_array));
                    break loop;
                }
            }
            // remain_array 배열의 두번째 요소 교환
            for(int i = 0; i < seven_dwarf_array.length; i++){
                int sum_value = (sum - seven_dwarf_array[i]) + remain_array[1];
                if(sum_value == 100) {
                    seven_dwarf_array[i] = remain_array[1];
                    System.out.println("answer = " + Arrays.toString(seven_dwarf_array));
                    break loop;
                }
            }
            // 두개의 remain_array 배열의 요소를 삽입하여 도출

            // 초기 교환 인덱스
            int index1 = 0;
            int index2 = 1;
            // 비교 배열 생성
            int compare_array[] = new int[7];
            // seven_dwarf_array 배열값 복사
            System.arraycopy(seven_dwarf_array,0,compare_array,0,seven_dwarf_array.length);
            System.out.println("compare array = " + Arrays.toString(compare_array));
            for(int i = 0; i < seven_dwarf_array.length; i++){



            }



        }else if (sum > 100){ //합계가 100 이상이라면

        }




    }
}

