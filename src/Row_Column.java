import java.io.*;
import java.util.*;

public class Row_Column {

    public static int[][] array_a;
    public static int[][] array_b;

    public static void main(String args[])throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //행렬
        // 행렬값 첫번째 줄의 첫번째수는 row수 두번쨰 수는 column수이다.
        // 행렬값은 0과 1로만 이루어져 있고 행렬은 a,b 두가지가 존재한다.
        // 목적은 행렬 a를 b의 형태로 변형 시키는 것 이다.
        // 연산의 기준은 반드시 3x3이다. -> row와 column수가 3을 넘지 않는다면 답은 자동으로 -1이 출력이 된다.
        // 또한 만약 행렬 a를 b의 형태로 연산이 불가능하면 -1이 출력된다.
        // 또한 연산에 해당되면 무조건 값은 0 -> 1로 1 ->0으로 변환된다. -> 즉 연산을하면 3x3범위는 전부 변환
        st = new StringTokenizer(br.readLine()," ");

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        // st = new StringTokenizer(br.readLine(),"");
        //int[][] array_a = new int[R][C];
        //int[][] array_b = new int[R][C];
        array_a = new int[R][C];
        array_b = new int[R][C];

        // count index
//        int k = 0;
//        for(int i = 0; i < R*2; i++) {
//            String test = br.readLine();
//            // a 행렬값
//            if (i >= 0 && i < R ) {
//               // for (int k = 0; k < R; k++) {
//
//                    for (int j = 0; j < test.length(); j++) array_a[k][j] = test.charAt(j) - 48;
//                    k += 1;
//               // }
//                // count index 초기화
//                if(i == R-1) k = 0;
//            }
//            else if(i >= R && i < R*2){
//              //  for (int k = 0; k < R; k++) {
//                    for (int j = 0; j < test.length(); j++) array_b[k][j] = test.charAt(j) - 48;
//                    k += 1;
//              //  }
//            }
//        }
        // matrix A
        for(int i = 0; i < R; i++){
            String test = br.readLine();
            for(int j = 0; j < C; j++){
                array_a[i][j] = test.charAt(j) - 48;
            }
        }
        // matrix B
        for(int i = 0; i < R; i++){
            String test = br.readLine();
            for(int j = 0; j < C; j++){
                array_b[i][j] = test.charAt(j) - 48;
            }
        }
        // 검사 방식으로는 2차원 배열을 한줄씩 검사하고 만약 B와 다르다면 연산을 수행하는 것으로 진행한다
        // 연산 수행시 cnt 증가
        // 우선 column수는 3으로 가정하고 진행해본다.

        int CNT = 0;
       // if(R >= 2 || C >=2) System.out.println("-1");

//        for(int i = 0; i < R; i++){
//            for(int j = 0; j < C;j++){
//                if(array_a[R][C] != array_b[R][C]){
//                    // 행렬 A와 B의 R행 값이 다르므로 R행은 연산의 적용 대상이다.
//                    // 적용대상 행은 R행기준 R ~ R+2행 까지 이다.
//                }
//            }
//
//        }

        System.out.println("array_a = "+Arrays.deepToString(array_a));
        System.out.println("array_b = "+Arrays.deepToString(array_b));


        // 배열 검사
//        for(int i = 0; i < R ; i++){
//            for(int j = 0; j < C; j++){
//                //검사하고자 하는 행렬 (i,j) 가 서로 다르고 검사하는 (i,j)의 J 다음의 열이 2이상 남아있는경우
//                if(array_a[i][j] != array_b[i][j] || C-j >= 3){
//                    CNT++;
//                    for(int k = i; k < i+3; k++){
//                        for(int n = j; n < j+3; n++){
//
//                        }
//                    }
//                }
//            }
//        }

        System.out.println("array_a[0][0] = " + array_a[0][0]);
        System.out.println("array_b[0][0] = " + array_b[0][0]);
        // 행렬 검사 -> 이 경우는 row값 colunm 값이 범위에서 벗어나면 안되므로 -2를 각각 해서 for문으로 순회
        for(int i = 0; i < R-2; i++){
            for(int j = 0; j < C-2; j++){
                //만약 matrix a 와 matrix b가 틀린 경우
                if(array_a[i][j] != array_b[i][j]){
                    // 행렬 변환 메서드 구현
                  //  System.out.println("pass");
                    change(i,j);
                    CNT++;
                }
            }
        }

        int flag = 0;
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if(array_a[i][j] == array_b[i][j]){
                    flag++;
                }
            }
        }

        System.out.println("flag = " + flag);
        System.out.println("R * C = " + R*C);
        System.out.println("CNT = " + CNT);
        if(flag == R * C){
            System.out.println(CNT);
        }else{
            System.out.println("-1");
        }




    }
    // 비트논리 연산자 사용
    // ^ -> 두 비트중 하나는 1이고 다른하나가 0인경우에만 연산결과가 1
    public static void change(int x,int y) {
        for(int i = x; i < x+3; i++){
            for(int j = y; j < y+3; j++){
                array_a[i][j] = array_a[i][j] ^ 1;
            }
        }
    }

}
