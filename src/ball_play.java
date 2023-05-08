import java.io.*;
import java.util.*;

public class ball_play {

    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        char array[] = new char[N];
        String str = br.readLine();

        for(int i = 0; i < N; i++){
            array[i] = str.charAt(i);
        }

        System.out.println(Arrays.toString(array));
        System.out.println(N);
    }
}
