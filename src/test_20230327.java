
import java.io.*;
import java.util.*;

public class test_20230327 {
    public static void main(String args[])throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //벌꿀담기
        // 9 9 4 1 4 9 9 -> 최대값 57 -> 첫번째 벌 맨왼쪽 9, 두번째 벌 1, 꿀통 맨 오른쪽 9에 할당
        int N = Integer.parseInt(br.readLine());
        int[]array1 = new int[N];
        int[]array2 = new int[N-2];
        int bee1;
        int honey_box;
        int start_index;
        int box_index;
        int answer;

        st = new StringTokenizer(br.readLine()," ");
        // 첫번째 벌과 꿀통 찾기
        for(int i = 0; i <N ; i++){
            array1[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println("array1 = " + Arrays.toString(array1));

        // 입력이 3인 경우
        if(N == 3){
            Arrays.sort(array1);
            System.out.println("입력 갯수가 3개인경우 ! = "+ array1[2]*2);
        }

        //첫번째 벌과 시작점 확인 -> 벌은 맨 앞과 뒤중 더 작은놈으로
        if(array1[0] > array1[N-1]){
            bee1 = array1[N-1];
            honey_box = array1[0];
            start_index = N-1;
            box_index = 0;
        }else{
            bee1 = array1[0];
            honey_box = array1[N-1];
            start_index = 0;
            box_index = N-1;
        }
        System.out.println("bee1 = " + bee1);
        System.out.println("honey_box = " + honey_box);
        System.out.println("start_index = " + start_index);
        System.out.println("box_index = " + box_index);

        for(int j = 1; j < N-1; j++){
            array2[j-1] = array1[j];
        }

        System.out.println("array2 = " + Arrays.toString(array2));

        // honey_box의 위치는?
        //0인경우는 내림차순, N-1인경우는 오름차순
        if(box_index == 0){

        }
        else if(box_index == N-1){

        }

    }

}
