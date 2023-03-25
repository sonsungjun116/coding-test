
import javax.swing.text.Style;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main{
    public static void main(String args[])throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int reps = Integer.parseInt(br.readLine());
        int count = 0;
        char select;
        char[] array = new char[26];

        int flag = 0;
//        System.out.println((int)a);
        // aaabbbccc -> 허용
        // aaabbbccca -> 불허
        // 다음문자로 바뀐 시점에 그문자를 배열에 저장해야 함

        for(int i = 0; i < reps; i++){
            String str = br.readLine();
            for(int j = 0; j < str.length()-1; j++){
                select = str.charAt(j);
                for(int k = j+1; k < str.length(); k++){
                    if(select != str.charAt(k)){
                        //배열에 select값을 저장
                        array[(int)select-97] = select;
                        // if문 으로 만약 배열안에 있는 값이라면 값을 카운트하면 안됨
                        if(str.charAt(k) == array[(int)str.charAt(k)-97]){
                            flag = 1;
                        }
                    }
                }

            }
            if(flag == 1){
                count--;
            }
            array = new char[26];
            flag = 0;
        }
    //    System.out.println("count :" + count);
        System.out.println(reps+count);

    }
}