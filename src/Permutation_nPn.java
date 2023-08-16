import java.util.*;


public class Permutation_nPn {
        static int N; // 원소 개수
        static int[] numbers; // 순열을 저장하는 배열
        static boolean[] selected;
        static int tc; //  순열 개수


    private static void permutation(int idx) {
        // 기저조건
            if(idx == N) {
                tc++;
                System.out.println(Arrays.toString(numbers));
                return;
            }

            for(int i = 1; i <= N; i++){
                // 중복 검사 (이미 뽑은 경우 넘어감)
                if(selected[i]) continue;

                // 중복되지 않는 경우
                numbers[idx] = i;
                selected[i] = true;
                permutation(idx+1); // 다음 요소 뽑기
                selected[i] = false;

            }
    }
    public static void main(String[] args){
        N = 3;
        numbers = new int[N];
        selected = new boolean[N+1];
        permutation(0);


    }


}
