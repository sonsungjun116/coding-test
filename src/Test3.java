import java.io.*;
import java.util.*;

public class Test3 {
    public static void main(String args[])throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int array[][] = new int[N][2];

        //stringtokenizer는 string 형태로 받기 때문에 숫자를 받으려면 형변환을 해줘야 한다.
        for(int i = 0; i < N;i++){
            st = new StringTokenizer(br.readLine()," ");
            array[i][0] = Integer.parseInt(st.nextToken());
            array[i][1] = Integer.parseInt(st.nextToken());
        }
        // 배열값 전체 출력
//        for(int i = 0; i<N; i++){
//            System.out.print(array[i][0]);
//        }
//        System.out.println();
//        for(int i = 0; i<N; i++){
//            System.out.print(array[i][1]);
//        }
        // 2차원 배열부터는 비교 인터페이스를 만들거나 람다식을 이용해 정렬을 해야 한다.
//        Arrays.sort(array, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                // return o1[0]-o2[0]; // 첫번째 숫자 기준 오름차순 {1,30}{2,10}{3,50}{4,20}{5,40}
//                // return o2[0]-o1[0]; // 첫번째 숫자 기준 내림차순 {5,40}{4,20}{3,50}{2,10}{1,30}
//                //return o1[1]-o2[1]; // 두번째 숫자 기준 오름차순 {2,10}{4,20}{1,30}{5,40}{3,50}
//                //return o2[1]-o1[1]; // 두번째 숫자 기준 내림차순 {3,50}{5,40}{1,30}{4,20}{2,10}
//
//            }
//        });
        // 람다식을 통해 2차원 배열 정렬
        // 기본적으로 두번째 배열을 오름차 순으로 정렬
        Arrays.sort(array, (o1, o2) -> {
            // 만약 두번째 배열을 정렬할때 서로 같은 값이 있다면
            if(o1[1] == o2[1]){
            // 첫번째 배열에서 오름차순으로 정렬 -> 즉 작은수를 먼저 정렬
                return o1[0] -o2[0];
            }
            return o1[1] - o2[1];
        });
//        for(int[] arr1 : array){
//            for(int i : arr1){
//                System.out.println(i);
//            }
//        }
        int last = 0;
        int cnt = 0;

        for(int k = 0; k < N ; k++){
          //  for(int x = 0; x < 2; x++){
                if(last <= array[k][0]){
                    last = array[k][1];
                    cnt++;
                }
           // }
        }
    System.out.println(cnt);
    }
}
