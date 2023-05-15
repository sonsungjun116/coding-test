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

        // 입력값이 1인경우
        if(N == 1){
            System.out.println(0);
        }
        //양쪽다 R이 존재하는경우
        if(array[0] == 'R' && array[N-1] == 'R'){
            int left_red_cnt = 0;
            int right_red_cnt = 0;
            // 왼쪽으로 순회하는경우
            for(int i = 0; i < N-1; i++){
                if(array[i] != array[i+1] && array[i+1] == 'R'){
                    left_red_cnt++;
                }
            }
            // 오른쪽으로 순회하는 경우
            for(int i = N-1 ; i >= 1 ;i--){
                if(array[i-1] != array[i] && array[i-1] == 'R'){
                    right_red_cnt++;
                }
            }
            // 제일 작은 값을 red_cnt에 대입
            if(left_red_cnt > right_red_cnt) red_cnt = right_red_cnt;
            else if(left_red_cnt < right_red_cnt) red_cnt = left_red_cnt;
            else if(left_red_cnt == right_red_cnt) red_cnt = left_red_cnt;


        }
        else if(array[0] == 'R' || array[N-1] == 'R'){
            //맨왼쪽 배열이 R이고 맨 오른쪽은 R이 아닌경우
            if (array[0] == 'R' && array[N-1] != 'R'){
                for(int i = 0; i < N-1; i++){
                    if(array[i] != array[i+1] && array[i+1] == 'R'){
                        red_cnt++;
                    }
                }
            }
            //맨왼쪽 배열이 R이 아니고 맨 오른쪽이 R인 경우
            else if (array[0] != 'R' && array[N-1] == 'R'){
                for(int i = N-1 ; i >= 1 ;i--){
                    if(array[i-1] != array[i] && array[i-1] == 'R'){
                        red_cnt++;
                    }
                }
            }
        }else {
            for(int i = 0; i < N ; i++){
                if(array[i] == 'R'){
                    red_cnt++;
                }
            }
        }

        //파란공 검사
        //양쪽다 B가 존재하는경우
        if(array[0] == 'B' && array[N-1] == 'B'){
            int left_blue_cnt = 0;
            int right_blue_cnt = 0;
            // 왼쪽으로 순회하는경우
            for(int i = 0; i < N-1; i++){
                if(array[i] != array[i+1] && array[i+1] == 'B'){
                    left_blue_cnt++;
                }
            }
            // 오른쪽으로 순회하는 경우
            for(int i = N-1 ; i >= 1 ;i--){
                if(array[i-1] != array[i] && array[i-1] == 'B'){
                    right_blue_cnt++;
                }
            }
            // 제일 작은 값을 blue_cnt에 대입
            if(left_blue_cnt > right_blue_cnt) blue_cnt = right_blue_cnt;
            else if(left_blue_cnt < right_blue_cnt) blue_cnt = left_blue_cnt;
            else if(left_blue_cnt == right_blue_cnt) blue_cnt = left_blue_cnt;


        }
        else if(array[0] == 'B' || array[N-1] == 'B'){
            //맨왼쪽 배열이 B이고 맨 오른쪽은 B가 아닌경우
            if (array[0] == 'B' && array[N-1] != 'B'){
                for(int i = 0; i < N-1; i++){
                    if(array[i] != array[i+1] && array[i+1] == 'B'){
                        blue_cnt++;
                    }
                }
            }
            //맨왼쪽 배열이 B가 아니고 맨 오른쪽이 B인 경우
            else if (array[0] != 'B' && array[N-1] == 'B'){
                for(int i = N-1 ; i >= 1 ;i--){
                    if(array[i-1] != array[i] && array[i-1] == 'B'){
                        blue_cnt++;
                    }
                }
            }
        }else {
            for(int i = 0; i < N ; i++){
                if(array[i] == 'B'){
                    blue_cnt++;
                }
            }
        }

        if (red_cnt > blue_cnt) System.out.println("answer = " + blue_cnt);
        else if(red_cnt < blue_cnt) System.out.println("answer = " + red_cnt);
        else if(red_cnt == blue_cnt) System.out.println("answer = " + red_cnt);

        //System.out.println(Arrays.toString(array));
        //System.out.println(N);
        //System.out.println("red_cnt = " + red_cnt);
    }
}
