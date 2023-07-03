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
        int flag = 0;
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

//        int multitap_hole[] = new int[N];
//        int elect_product[] = new int[K];
        ArrayList<Integer> multitap_hole = new ArrayList<>();
        ArrayList<Integer> elect_product = new ArrayList<>();
        ArrayList<Integer> compare_array = new ArrayList<>(N);
        ArrayList<Integer> duplicate_array = new ArrayList<>(N);

        System.out.println("N = " + N);
        System.out.println("K = " + K);

        st = new StringTokenizer(br.readLine()," ");
        int s_count = st.countTokens();
        // 두번쨰 행의 입력값을 가지고 있는 배열
        for(int i =0; i < K; i++){
            //elect_product[i] = Integer.parseInt(st.nextToken());
            elect_product.add(i,Integer.parseInt(st.nextToken()));
        }
        // 순차적으로 입력한 배열의 값을 정해놓은 N개의 콘센트 구멍수 만큼 값을 할당
        for(int i = 0; i < N; i++){
            //multitap_hole[i] = elect_product[i];
            multitap_hole.add(i,elect_product.get(i));
        }
        System.out.println("multitap_hole = " + multitap_hole);
        System.out.println("elect_product = " + elect_product);

        for(int i = N; i < K; i++){
            for(int j = 0; j < N; j++){
                System.out.println("logic confirm ->  index i = " + i +" , index j = " + j +" ->  elect_product[i] = " + elect_product.get(i) + "   multitap_hole[j] = " + multitap_hole.get(j) );

                if(elect_product.get(i) == multitap_hole.get(j)){
                    break;
                }
            }
            if(multitap_hole.contains(elect_product.get(i))){
                continue;
            }

            //여기까지 왔다는건 multitap_hole에 있는 값들중 같은것이 하나도 없다는 것
            compare = elect_product.get(i);
            // 그러나 총 elect_product수를 고민해야함

            // 남아있는 배열의 수가 N개보다 크거나 같을때 -> 비교대상 배열의 갯수를 N개로 지정
            if(N <= K-1-i) {
                // N개만큼 배열에 삽입
                System.out.println("level 1");
                for (int k = i + 1; k < i + 1 + N; k++) {
//                    compare_array[k] = elect_product[k];
                    compare_array.add(elect_product.get(k));
                }
                System.out.println("level 1-1 -> compare_array = " + compare_array);
                // 비교 배열과 멀티탭에 끼워진 값들의 배열과 비교
                for(int k = 0; k < N; k++){
                    for(int j = 0; j < N; j++){
                        if(multitap_hole.get(k) == compare_array.get(j)
                                                && (duplicate_array.contains(multitap_hole.get(k)) == false
                                                || duplicate_array.contains(compare_array.get(j)) == false)){
                            duplicate_array.add(compare_array.get(j));

                        }
                    }
                }
                // duplicate_array 과 multitap_hole를 비교해서 중복되지 않는 녀석중 가장 빠른 index의 배열 값을교체
                loop:
                for(int k = 0; k < N; k++){
                    for(int j = 0; j < duplicate_array.size(); j++){
                        if(multitap_hole.get(k) != duplicate_array.get(j)){
                            multitap_hole.set(k,compare);
                            cnt++;

                            break loop;
                        }
                    }
                }

                flag = 0;
                System.out.println("level 1-2 -> duplicate_array = " + duplicate_array);
                System.out.println("multitap_hole = " + multitap_hole);
                System.out.println("compare = " + compare);
                System.out.println("cnt = " + cnt);
                duplicate_array = new ArrayList<>();
                compare_array = new ArrayList<>();
            }
            // 남은 배열의 수가 N개보다 작은 경우
            else if(N > K-1-i){
                System.out.println("level 2");
                System.out.println("compare = " + compare);
                for (int k = i+1; k < K; k++) {
                    compare_array.add(elect_product.get(k));
                }
                System.out.println("level 2-1 -> compare_array = " + compare_array);
                for(int k = 0; k < N; k++) {
                    for (int j = 0; j < compare_array.size(); j++) {
                        if(multitap_hole.get(k) == compare_array.get(j)){
                            duplicate_array.add(compare_array.get(j));
                        }
                    }
                }
                loop:
                for(int k = 0; k < N; k++){
                    for(int j = 0; j < duplicate_array.size(); j++){
                        if(multitap_hole.get(k) != duplicate_array.get(j)){
                            multitap_hole.set(k,compare);
                            cnt++;
                            System.out.println("cnt = "+ cnt);
                            break loop;
                        }
                    }
                }
                if(duplicate_array.size() == 0){
                    multitap_hole.set(0,compare);
                    cnt++;
                }

                System.out.println("level 2-2 -> duplicate_array = " + duplicate_array);
                System.out.println("multitap_hole = " + multitap_hole);
                System.out.println("compare = " + compare);
                duplicate_array = new ArrayList<>();
                compare_array = new ArrayList<>();
            }
            compare = 0;
        }

//            for(int i = 0 ; i < K; i++){
//                System.out.println("i = "+i);
//                st = new StringTokenizer(br.readLine(), " ");
//                elect_product[i] = Integer.parseInt(st.nextToken());
//            }
            System.out.println("elect_product = "+ elect_product);
            System.out.println("multitap_hole = "+ multitap_hole);
            System.out.println("duplicate_array = "+ duplicate_array);
            System.out.println("cnt = "+ cnt);

      //  st = new StringTokenizer(br.readLine()," ");


//        while(st.hasMoreTokens()){
//            System.out.println("st.nextToken() : " + st.nextToken());
//        }

//        loop:
//        for(int k = 0; k < N; k++){
//            for(int j = 0; j < duplicate_array.size(); j++){
//                if(multitap_hole[k] != duplicate_array.get(j)){
//                    multitap_hole[k] = compare;
//                    cnt++;
//                    break loop;
//                }
//            }
//        }

    }
}
