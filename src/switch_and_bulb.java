import java.io.*;
import java.util.*;

public class switch_and_bulb {

    public static void main(String args[])throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int array[] = new int[N];
        int array2[] = new int[N];

        // 서로 다른 배열을 비교해서 변환
        // 2 <= N <= 100000
        // 1 step -> 맨끝 값이 서로 다르냐?? -> 1과 N은 1,2,N-1,N까지만 변환 가능
        // 2 ~ N 은 본인이 i 일떄 i 기준으로 i-1 , i , i+1 변환 가능
        // 5부터 다른 값에 1,2 혹은 N-1,N인경우 풀리지 않고 있음

        // 문제 접근법
        // N => 2~4 사이인 경우는 스위치를 통해 무조건 변환 가능
        // N >= 5 이상인 경우부터는 변환이 불가능한 경우가 존재









    }

}
