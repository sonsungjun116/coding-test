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

        // N의 갯수 만큼 index i 로 각각 한번씩 순회 하여 스위치를 누른 배열 값을 생성
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N ; j++){
                // index 가 1인경우 -> 1,2만 역수
                if (i == 0){
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
                }
                // index 가 맨 마지막인 경우 -> N,N-1 이지만 for 문 배열에서는 0 부터 시작 하므로
                else if(i == N-1){
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
                }else {

                    if(array[i-1] == 0){
                        ss[i][i-1] = 1;
                    }else {
                        ss[i][i-1] = 0;
                    }
                    if(array[i] == 0){
                        ss[i][i] = 1;
                    }else {
                        ss[i][i] = 0;
                    }
                    if(array[i+1] == 0){
                        ss[i][i+1] = 1;
                    }else {
                        ss[i][i+1] = 0;
                    }
                }
            }
        }

        int key[][] = new int[N][N];
        int store[][] = new int[N][N];
        int min = Integer.MAX_VALUE;
        int count = 0;
        // 경우의 수 순회
//        for(int i = 0; i < N; i++){
//            for(int j = 0; j < N; j++) {
//                for (int x = 0; x < N; x++) {
//                    if(i == 0){
//                        if(ss[j][0] == 0){
//                            key[j][0] = 1;
//                        }else{
//                            key[j][0] = 0;
//                        }
//                        if(ss[j][1] == 0){
//                            key[j][1] = 1;
//                        }else{
//                            key[j][1] = 0;
//                        }
//                        key[j][x] = ss[j][x];
//
//                    }else if(i == N-1){
//                        if(key[j][N-1] == 0){
//                            key[j][N-1] = 1;
//                        }else{
//                            key[j][N-1] = 0;
//                        }
//                        if(key[j][N-2] == 0){
//                            key[j][N-2] = 1;
//                        }else{
//                            key[j][N-2] = 0;
//                        }
//                        System.out.println(Arrays.deepToString(key));
//                        //key[j][x] = key[j][x];
//
//                    }else{
//                        if(key[j][i-1] == 0){
//                            key[j][i-1] = 1;
//                        }else{
//                            key[j][i-1] = 0;
//                        }
//                        if(key[j][i] == 0){
//                            key[j][i] = 1;
//                        }else{
//                            key[j][i] = 0;
//                        }
//                        if(key[j][i+1] == 0){
//                            key[j][i+1] = 1;
//                        }else{
//                            key[j][i+1] = 0;
//                        }
//
//                    }
//                    // 바꾸고 ss와 같은지 검사
//                    for (int k = 0; k < N; k++) {
//                        if (ss[i][k] == key[i][k]) {
//
//                        }
//                    }
//
//
//                }
//            }
//            System.out.println("index = "+ i + " -> " + Arrays.deepToString(key));
//            count++;
//        }


        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++) {
                for (int x = 0; x < N; x++) {
                    if(i == 0){
                        if(ss[j][0] == 0){
                            key[j][0] = 1;
                        }else{
                            key[j][0] = 0;
                        }
                        if(ss[j][1] == 0){
                            key[j][1] = 1;
                        }else{
                            key[j][1] = 0;
                        }
                        key[j][x] = ss[j][x];
                        //store[j][x] = key[j][x];

                        System.out.println("key = " + "i = " + i + ", " + "j = " + j + ", " + "x = " + x + " " + Arrays.deepToString(key));
                    }else if(i == N-1){
                        if(key[j][N-1] == 0 && x == 0){
                            key[j][N-1] = 1;
                        }else{
                            key[j][N-1] = 0;
                        }if(key[j][N-2] == 0 && x == 0){
                            key[j][N-2] = 1;
                        }else{
                            key[j][N-2] = 0;
                        }

                        System.out.println("key = " + "i = " + i + ", " + "j = " + j + ", " + "x = " + x + " " + Arrays.deepToString(key));
                    }else{
                        if(key[j][i-1] == 0){
                            key[j][i-1] = 1;
                        }else{
                            key[j][i-1] = 0;
                        }
                        if(key[j][i] == 0){
                            key[j][i] = 1;
                        }else{
                            key[j][i] = 0;
                        }
                        if(key[j][i+1] == 0){
                            key[j][i+1] = 1;
                        }else{
                            key[j][i+1] = 0;
                        }

                    }

                    // 바꾸고 ss와 같은지 검사
                    for (int k = 0; k < N; k++) {
                        if (ss[i][k] == key[i][k]) {

                        }
                    }


                }
            }
            System.out.println("index = "+ i + " -> " + Arrays.deepToString(key));
            count++;
        }


        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(array2));
        System.out.println(Arrays.deepToString(ss));
        System.out.println("store = " + Arrays.deepToString(store));


    }

}
