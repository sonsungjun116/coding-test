import java.util.*;
import java.io.*;

public class multitap{

    public static void main(String args[])throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = 0;
        int K = 0;
        int cnt = 0;
        int compare = 0;
        // 1. 콘센트의 수 인 N개의 크기 배열에 K개의 숫자 번호를 넣고 N+1번째 인덱스의 값이 배열에 있는지 확인
        // -> 해당 배열안에 N+1 인덱스의 값이 존재한다면 pass

        // 2. 존재하지 않는다면 해당 인덱스를 제외하고 그 다음 번째 인덱스부터 N개의 배열을 안의 배열과 비교하여 검사한다.

        // 3. 교체 시 다음 번째 인덱스부터 N개의 배열중 현재 배열과 같은것이 없는것으로 교체
        // -> 만약 모두 다르거나 몇가지가 다르다면 아무거나 교체

        for(int i = 0; i < 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
        }

        int multitap_hole[] = new int[N];
        int elect_product[] = new int[K];
        int compare_array[] = new int[N];
        ArrayList<Integer> compare_array2 = new ArrayList<Integer>(N);

        System.out.println("N = " + N);
        System.out.println("K = " + K);

        st = new StringTokenizer(br.readLine()," ");
        int s_count = st.countTokens();
        for(int i =0; i < K; i++){
            elect_product[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i < N; i++){
            multitap_hole[i] = elect_product[i];
        }

        for(int i = N; i < K-1; i++){
            for(int j = 0; j < N; j++){
                if(elect_product[i] == multitap_hole[j]){
                    continue;
                }

            }
            //여기까지 왔다는건 multitap_hole에 있는 값들중 같은것이 하나도 없다는 것
            compare = elect_product[i];
            // 그러나 총 elect_product수를 고민해야함
            if(N <= K-1-i) {
                for (int k = i + 1; k < i + 1 + N; k++) {
                    compare_array[k] = elect_product[k];
                }
            }else{
                    compare_array2 = new ArrayList<>(K-1-i);
            }
            cnt++;
        }

//            for(int i = 0 ; i < K; i++){
//                System.out.println("i = "+i);
//                st = new StringTokenizer(br.readLine(), " ");
//                elect_product[i] = Integer.parseInt(st.nextToken());
//            }
            System.out.println("elect_product = "+Arrays.toString(elect_product));
            System.out.println("multitap_hole = "+Arrays.toString(multitap_hole));

      //  st = new StringTokenizer(br.readLine()," ");


//        while(st.hasMoreTokens()){
//            System.out.println("st.nextToken() : " + st.nextToken());
//        }



    }
}
