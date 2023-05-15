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








    }

}
