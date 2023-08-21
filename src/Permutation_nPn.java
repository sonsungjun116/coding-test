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
////                System.out.println(tc);
//                System.out.println("answer = "+ Arrays.toString(numbers));
//                System.out.println("answer = " + Arrays.toString(selected));

                return;
            }


            for(int i = 1; i <= N; i++){
                // 중복 검사 (이미 뽑은 경우 넘어감)
                if(selected[i]) continue;

                // 중복되지 않는 경우
                numbers[idx] = i;
                selected[i] = true;
                System.out.println("numbers = " + Arrays.toString(numbers));
                System.out.println("selected = " + Arrays.toString(selected));
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
// numbers[0] = 1,
// selected[1] = true;
// permutation(1)
// numbers[1] = 2;
// selected[2] = true;
// permutation(2)
// numbers[2] = 3;
// selected[3] = true;
// permutation(3);
// if(3 == 3) ->