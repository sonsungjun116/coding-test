import java.util.*;
import java.io.*;

public class permutation_practice {

    public static void main(String[] args) {
        int n = 3;
        int []arr = {1,2,3};

        permutation(arr,0,n,2);
    }
    // arr = {1,2,3} 인 경우 결국 depth = 0을 기점으로 순회하면서 생성
    // depth = 0 , i = 0; -> {1,2,3} and {1,3,2}
    // depth = 0 , i = 1 -> {2,1,3} and {2,3,1}
    // depth = 0 , i = 2 -> {3,1,2} and {3,2,1}
    // 맨뒤 swap은 결국 해당 depth가 끝나면 순서가 변경된 arr배열을 원래 값인 {1,2,3} 으로 초기화 하는 역할 수행
    static void permutation (int[] arr, int depth, int n, int r) {
            if(depth == r){
                System.out.println(Arrays.toString(arr));
                return;
            }

            for(int i = depth; i < n; i++){
                swap(arr,depth,i);
                permutation(arr, depth + 1, n, r);
                swap(arr, depth, i);

            }
    }

    static void swap(int[] arr, int depth, int i) {
        int temp = arr[depth];
        arr[depth] = arr[i];
        arr[i]  = temp;

    }


}
