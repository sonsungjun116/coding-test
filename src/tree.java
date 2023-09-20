import java.util.*;
import java.io.*;

public class tree {

    public static void main(String args[])throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //쿼드 트리
        int N = Integer.parseInt(br.readLine());
        int[][]input_array = new int[N][N];

        for(int i = 0; i < N; i++){
            String input = br.readLine();
            for(int j = 0; j < input.length();j++) {
                char c = input.charAt(j);
                input_array[i][j] = input.charAt(j)-'0';
            }
        }

        System.out.println("array value = "+ Arrays.deepToString(input_array));

        // N * N 크기의 배열을 4등분으로 나누어 전체가 1인지 0인지 섞여있는지를 판별
        // (N/2) * (N/2)




    }
}
