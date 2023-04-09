import java.io.*;
import java.util.*;

public class Row_Column {

    public static void main(String args[])throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //행렬
        // 행렬값 첫번째 줄은 row수 두번쨰 수는 column수이다.
        // 행렬값은 0과 1로만 이루어져 있고 행렬은 a,b 두가지가 존재한다.
        // 목적은 행렬 a를 b의 형태로 변형 시키는 것 이다.
        // 연산의 기준은 3x3이다. -> row와 column수가 3을 넘지 않는다면 답은 자동으로 -1이 출력이 된다.
        // -> 즉 column수는 4이상부터는
        st = new StringTokenizer(br.readLine()," ");

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        // st = new StringTokenizer(br.readLine(),"");
        int[][] array_a = new int[R][C];
        int[][] array_b = new int[R][C];

        for(int i = 0; i < R*2; i++) {
            String test = br.readLine();
            if (i >= 0 && i < R ) {
                for (int k = 0; k < R; k++) {
                    for (int j = 0; j < test.length(); j++) array_a[k][j] = test.charAt(j) - 48;
                }
            }
            else if(i >= R && i < R*2){
                for (int k = 0; k < R; k++) {
                    for (int j = 0; j < test.length(); j++) array_b[k][j] = test.charAt(j) - 48;
                }
            }
//            System.out.println("array = "+ Arrays.toString(array));
        }

        System.out.println("array_a = "+Arrays.deepToString(array_a));
        System.out.println("array_b = "+Arrays.deepToString(array_b));

    }
}
