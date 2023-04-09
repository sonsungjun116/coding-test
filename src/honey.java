import java.io.*;
import java.util.*;

public class honey {
    public static void main(String args[])throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //1. 벌이 왼쪽 꿀통이 오른쪽에 있는경우
        //2. 벌이 오른쪽 꿀퉁이 왼쪽에 있는경우
        //3. 왼쪽 오른쪽 벌이 고정되어있고 꿀통이 움직이는 경우

        int N = Integer.parseInt(br.readLine());
        int[] array = new int[N];
        int sum = 0;
        int max = 0;

        st = new StringTokenizer(br.readLine()," ");
        for(int i = 0; i < N; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        //System.out.println("array = "+Arrays.toString(array));
        //1. 벌이 왼쪽에 고정되고 꿀통이 맨 오른쪽인 경우
        // 첫번째 벌의 경우 맨 왼쪽을 기준으로 하였기때문에 모든 배열의 합에서 자기 자신인 array[0]을 뺀다
        int first_bee = Arrays.stream(array).sum() - array[0];
        // 이녀석은 값은 고정이고 for문의 i 인자에 따라 값이 바뀌는것
        int second_bee  = first_bee;
        // 두번째 놈은 시작은 first_bee와 동일하나 for문의 i 배열이 돌아갈수록 작아짐 -> 두번째 벌은 값이 오른쪽으로 갈 수록 작아지기 때문
        //System.out.println("first_bee = "+ first_bee);

        for(int i = 1; i < array.length-1; i++){
            sum = first_bee - array[i];// 계속 초기화 될 것
            second_bee -= array[i]; // 계속 값을 가져갈 것
            sum += second_bee;

            max = Math.max(max,sum);
        }
        //System.out.println(max);
        //2. 벌이 오른쪽에 고정되고 꿀통이 맨 왼쪽인 경우

        first_bee = first_bee + array[0] - array[array.length-1];
        second_bee = first_bee;
        for(int i = array.length-1; i < 0; i--){
            sum = first_bee - array[i];
            second_bee -= array[i];
            sum += second_bee;

            max = Math.max(max,sum);
        }

        //3.양쪽 맨 끝에 벌이 있고 꿀통이 움직이는 경우
        // 원래 생각한것은 second_bee의 값은 전체 합에서 array[0]과 array[array.length-1]의 값을 뺀 것이라 생각했지만
        // 이 경우에는 만약 N= 3인 경우에 max값을 도출 해 낼 수가 없다.
        // 따라서 second_bee 의 값을 마지막 배열 값인 array[array.length-1]값만 뺀값으로 지정하고
        // for문에 따라 순회하면서 second의 값을 array[i-1]부터 빼간다.
        first_bee = 0;
        second_bee = Arrays.stream(array).sum() - array[array.length-1];

        for(int i = 1; i < array.length-1; i++){
            first_bee += array[i];
            second_bee -= array[i-1];

            max = Math.max(max,first_bee+second_bee);

        };

//        System.out.println("first_bee = " + first_bee);
//        System.out.println("second_bee = " + second_bee);
        System.out.println(max);

    }
}
