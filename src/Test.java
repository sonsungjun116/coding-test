import java.io.*;
import java.util.*;

public class Test {
    public static void main(String args[])throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        char[] alpha = new char[26];
        int[] int_array = new int[26];
        int x = 97;

        for(int i = 0; i < 26; i++){
            alpha[i] = (char)(x);
            //System.out.print(alpha[i] + " ");
            x++;
        }
        for(int c = 0; c < 26; c++){
            int_array[c] = -1;
        }
        String A = br.readLine();
        //char 배열의 길이를 정의 하기전에 여기서 문자의 중복을 제거 해야 한다.
        for(int i = 0; i < A.length()-1; i++){
            for(int j = i+1; j < A.length(); j++){
                if(A.charAt(i) == A.charAt(j)){
                   A = A.substring(0,j) + "X" + A.substring(j+1);
                }
            }
        }
        // 중복을 제거하고 문자열의 길이는 그대로 맞추기 위해서 대문자 X를 대입함으로서 중복 인덱스를 제거하고 길이 까지 유지함
        System.out.println(A);
        //
        char[] array2 = new char[A.length()];

        for(int i = 0; i < A.length(); i++){
            array2[i] = A.charAt(i);
          //  System.out.println(array2[i]);
        }

        for(int k = 0; k < 26; k++) {
          for(int b = 0; b < array2.length; b++){
              if(array2[b] == alpha[k]){
                  int_array[k] = b;
              }
          }
          System.out.print(int_array[k] + " ");
        }

    }

}
