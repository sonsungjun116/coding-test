import java.io.*;
import java.util.*;

public class Test4 {
    public static void main(String args[])throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int index ;
        int index2 ;
        int count1 = 0;
        int count2 = 0;

        if(N%3 != 0 && N%2 != 0){
            N -= 1;
            count1++;
            count2++;
        }
        if(N%3 == 0){
            count1++;
            index = N/3;
            while (index != 1) {
                if(index % 3 == 0 && index % 2 ==0){
//                    System.out.println(index);
                    index = index/3;
                    count1++;
//                    System.out.println("case1");
                }
                else if (index != 1 && index % 3 == 0) {
                    index = index / 3;
                    count1++;
//                    System.out.println("case2");
                } else if (index != 1 && index % 2 == 0) {
                    index = index / 2;
                    count1++;
//                    System.out.println("case3");
                } else {
                    index -= 1;
                    count1++;
//                    System.out.println("case4");
                }
            }
        }
        else if(N%2 == 0){
            count1++;
            index = N/2;
            while (index != 1) {
                if(index % 3 == 0 && index % 2 ==0){
//                    System.out.println(index);
                    index = index/3;
                    count1++;
//                    System.out.println("case5");
                }
                else if (index != 1 && index % 3 == 0) {
                    index = index / 3;
                    count1++;
//                    System.out.println("case6");
                } else if (index != 1 && index % 2 == 0) {
                    index = index / 2;
                    count1++;
//                    System.out.println("case7");
                } else {
                    index -= 1;
                    count1++;
//                    System.out.println("case8");
                }
            }
        }

        if(N%3 == 0){
            count2++;
            index = N/3;
            while (index != 1) {
                if(index % 3 == 0 && index % 2 ==0){
//                    System.out.println(index);
                    index = index/3;
                    count2++;
//                    System.out.println("case1");
                }
                else if (index != 1 && index % 3 == 0) {
                    index = index / 3;
                    count2++;
//                    System.out.println("case2");
                } else if (index != 1 && index % 2 == 0) {
                    index = index / 2;
                    count2++;
//                    System.out.println("case3");
                } else {
                    index -= 1;
                    count2++;
//                    System.out.println("case4");
                }
            }
        }
        else if(N%2 == 0){
            count2++;
            index = N-1;
            while (index != 1) {
                if(index % 3 == 0 && index % 2 ==0){
//                    System.out.println(index);
                    index = index/3;
                    count2++;
//                    System.out.println("case5");
                }
                else if (index != 1 && index % 3 == 0) {
                    index = index / 3;
                    count2++;
//                    System.out.println("case6");
                } else if (index != 1 && index % 2 == 0) {
                    index = index - 1;
                    count2++;
//                    System.out.println("case7");
                } else {
                    index -= 1;
                    count2++;
//                    System.out.println("case8");
                }
            }
        }
//        System.out.println(count1);
//        System.out.println(count2);

        if(count1 > count2){
            System.out.println(count2);
        }
        else if (count1 < count2){
            System.out.println(count1);
        }
        else{
            System.out.println(count1);
        }

    }
}
