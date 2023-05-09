import java.io.*;
import java.util.*;

public class ball_play {

    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        char array[] = new char[N];
        int array_cnt[] = new int[N];
        String str = br.readLine();

        for(int i = 0; i < N; i++){
            array[i] = str.charAt(i);
        }

        // 각각 빨간공과 파란공이 모여지는 경우의수를 각각 구하고 그수 를 비교하여 정답을 도출
        // 맨 왼쪽 또는 맨 오른쪽에 공이 있는 것이 기준 방향 1순위
        // 만약 양쪽다 존재한다면 맨 왼쪽이나 맨 오른쪽과 붙어 있는 쪽으로 이동
        // 그렇지 않다면 이동 회차는 선택한 색의 공수 -1

        int blue_cnt = 0;
        int red_cnt = 0;


        //빨간공 검사

//        if(array[0] == 'R' && array[N-1] == 'R'){
//
//        }else if(array[0] == 'R' || array[N-1] == 'R'){
//
//        }

        if(N == 1){
            System.out.println(0);
        }

        if(array[0] == 'R' && array[N-1] == 'R'){

        }
        else if(array[0] == 'R' || array[N-1] == 'R'){

            if (array[0] == 'R' && array[N-1] != 'R'){
                for(int i = 0; i < N-1; i++){
                    if(array[i] != array[i+1] && array[i+1] == 'R'){
                        red_cnt++;
                    }
                }
            }
            else if (array[0] != 'R' && array[N-1] == 'R'){

            }
        }else {
            for(int i = 0; i < N ; i++){
                if(array[i] == 'R'){
                    blue_cnt++;
                }
            }
        }

        //파란공 검사

        System.out.println(Arrays.toString(array));
        System.out.println(N);
        System.out.println("red_cnt = " + red_cnt);
    }
}
