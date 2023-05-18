import java.io.*;
import java.util.*;

public class switch_and_bulb {

    public static void main(String args[])throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int array[] = new int[N];
        int array2[] = new int[N];

        String a = br.readLine();
        String b = br.readLine();


        for(int i = 0; i < N; i++){
            array[i] = a.charAt(i) - 48;
            array2[i] = b.charAt(i) - 48;
        }
        // 문제
        // N 개의 전구와 스위치가 있으며 전구는 꺼져 있던가 켜져 있던가 둘중 하나이다.
        // 스위치를 키면 스위치에 해당하는 번호의 i-1, i, i+1 의 전구가 전부 바뀐다.
        // 만약 1번 혹은 N번의 스위치를 키면 이 경우는 1,2 , N-1,N 만 바뀌게 된다.
        // a -> b 로 바뀌는 최소값을 구하고 만약 바꿀수 없다면 0을 출력한다.

        // 문제 풀이
        // N의 갯수 만큼 배열을 만들고 각 배열의 인덱스를 순회 하면서 스위치를 눌러 역수를 취하고
        // 그 배열을 통해서 순회하여 값을 찾아간다.
        // 순방향과 역방향을 둘다 구현하고 최소값을 구하라

        int ss[][] = new int[N][N];




        for(int i = 0; i < N; i++){
            for(int j = 0; j < N ; j++){
                if (j == 0){

                    if(array[0] == 0){
                        ss[i][0] = 1;
                    }else{
                        ss[i][0] = 0;
                    }

                    if(array[1] == 0){
                        ss[i][1] = 1;
                    }else{
                        ss[i][1] = 0;
                    }
                }else if(j == N-1){
                    if(array[N-1] == 0){
                        ss[i][N-1] = 1;
                    }else{
                        ss[i][N-1] = 0;
                    }

                    if(array[N-2] == 0){
                        ss[i][N-2] = 1;
                    }else{
                        ss[i][N-2] = 0;
                    }
                }
                //ss[i][j] =
            }
        }

        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(array2));








    }

}
