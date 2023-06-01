import java.util.*;
import java.io.*;

public class switch_and_bulb2 {

    public static void main(String args[])throws IOException {

        // 1. 첫번째 전구를 킨 경우와 키지 않은 경우로 구분 지어서 구현

        // 2. 2 ~ n-1 인덱스를 순회하여 값을 찾는다

        //7
        //0010100
        //0111010

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int start[] = new int[N];
        int goal[] = new int[N];
        int toy[] = new int[N];
        int answer = Integer.MAX_VALUE;
        int cnt = 0;

        String a = br.readLine();
        String b = br.readLine();


        for(int i = 0; i < N; i++){
            start[i] = a.charAt(i) - 48;
            goal[i] = b.charAt(i) - 48;
        }

        System.out.println("start = "+Arrays.toString(start));
        System.out.println("goal = " +Arrays.toString(goal));

        // 첫번째 불을 킨경우
        for(int i = 0; i < N-1; i++){
            if(i == 0 || i == 1) {
                if (start[i] == 0) {
                    toy[i] = 1;
                } else {
                    toy[i] = 0;
                }
            }else {
                toy[i] = start[i];
            }
        }
        System.out.println("toy = "+Arrays.toString(toy));

        for(int i = 1; i < N-1; i++){
            if(goal[i-1] != toy[i-1]){
                if(toy[i-1] == 0){
                    toy[i-1] = 1;
                }
                else if(toy[i-1] == 1){
                    toy[i-1] = 0;
                }
                if(toy[i] == 0){
                    toy[i] = 1;
                }
                else if(toy[i] == 1){
                    toy[i] = 0;
                }
                if(toy[i+1] == 0){
                    toy[i+1] = 1;
                }
                else if(toy[i+1] == 1){
                    toy[i+1] = 0;
                }

                cnt++;
            }
        }


        System.out.println(cnt);
        System.out.println("toy = "+Arrays.toString(toy));

        if(Arrays.equals(toy,goal)){
            System.out.println("정답 도출");
            answer = Math.min(cnt,answer);
        }else{
            System.out.println("실패");
        }

        cnt = 0;

        // 첫번째 불을 안킨 경우
        for(int i = 0 ; i < N; i++ ){
            toy[i] = start[i];
        }
        System.out.println("초기화된 배열값"+ Arrays.toString(toy));
        for(int i = 1; i < N-1; i++){
            if(goal[i-1] != toy[i-1]){
                if(toy[i-1] == 0){
                    toy[i-1] = 1;
                }
                else if(toy[i-1] == 1){
                    toy[i-1] = 0;
                }
                if(toy[i] == 0){
                    toy[i] = 1;
                }
                else if(toy[i] == 1){
                    toy[i] = 0;
                }
                if(toy[i+1] == 0){
                    toy[i+1] = 1;
                }
                else if(toy[i+1] == 1){
                    toy[i+1] = 0;
                }

                cnt++;
            }
            System.out.println("index = "+i + " toy = " +Arrays.toString(toy));
        }
        if(Arrays.equals(toy,goal) == false){
            if(toy[N-2] == 0){
                toy[N-2] = 1;
            }
            else if(toy[N-2] == 1){
                toy[N-2] = 0;
            }
            if(toy[N-1] == 0){
                toy[N-1] = 1;
            }
            else if(toy[N-1] == 1){
                toy[N-1] = 0;
            }
            cnt++;
        }

        if(Arrays.equals(toy,goal)){
            System.out.println("정답 도출");
            answer = Math.min(cnt,answer);
        }else{
            System.out.println("실패");

        }
        answer = Math.min(cnt,answer);
        System.out.println("answer = "+answer);

    }
}
