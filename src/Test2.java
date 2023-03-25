
import javax.swing.text.Style;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Test2{
    public static void main(String args[])throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // 두자리 문자의 경우는 자신의 인덱스 +1 의 경우만 생각
        // 세자리 문자의 경우는 자신의 인덱스 +-1 의 경우를 생각
        // dz=의 경우도 count를 1로 세야 한다.
        // dz= 가 나오는 경우와 z=가 나오는 경우를 분리하여서 생각해야 한다.
        // 하나의 for문으로 처리를 한다.

        String x = br.readLine();
        int x_length = x.length();
        int count = 0;

        for(int i =0; i < x.length(); i++){
            if(1 < x.length() && i < x.length()-1 && x.charAt(i) == 'c'){
                if(x.charAt(i+1) == '=' || x.charAt(i+1) == '-'){
                    count++;
                }
                System.out.println("flag1");
            }
            else if(2 < x.length() && i < x.length()-2 && x.charAt(i) == 'd' && x.charAt(i+1) == 'z' && x.charAt(i+2) == '='){
                count += 2;
                System.out.println("flag2");
            }
            else if(1 < x.length() && i < x.length()-1 && x.charAt(i) == 'd'){
                if(x.charAt(i+1) == '-'){
                    count++;
                }
                System.out.println("flag3");
            }
            else if(1 < x.length() && i < x.length()-1 && x.charAt(i) == 'l'){
                if(x.charAt(i+1) == 'j'){
                    count++;
                }
                System.out.println("flag4");
            }
            else if(1 < x.length() && i < x.length()-1 && x.charAt(i) == 'n'){
                if(x.charAt(i+1) == 'j'){
                    count++;
                }
                System.out.println("flag5");
            }
            else if(1 < x.length() && i < x.length()-1 && x.charAt(i) == 's'){
                if(x.charAt(i+1) == '='){
                    count++;
                }
                System.out.println("flag6");
            }
//            else if(2 <= x.length() && i == x.length()-1 && x.charAt(i) == 'z' && x.charAt(i+1) == '='){
//
//                if (x.length() >= 3)
//                    continue;
//                count++;
//                System.out.println("flag7");
//            }
            else if(2 <= x.length() && i == 0 && x.charAt(i) == 'z' && x.charAt(i+1) == '='){
                count++;
                System.out.println("flag7");
            }
            else if(2 < x.length() && i > 0 && i < x.length()-1 && x.charAt(i-1) != 'd' && x.charAt(i) == 'z' && x.charAt(i+1) == '='){
                count++;
                System.out.println("flag8");
            }
        }
        // 길이가 2일때 z= count || 길이가 3 이상일때 z= 앞인덱스 d인지 확인
        System.out.println("x_length : " + x_length);
        System.out.println("count : " + count);
        System.out.println("answer : " + (x_length - count));

    }
}