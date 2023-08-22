import java.util.*;

public class Permutation2 {

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4}; // 뽑을 배열
        per permutation = new per(); // per 클래스의 인스턴스 permutation을 생성
        permutation.permutation(arr, 0, 2);

        System.out.println("총 개수:");
        System.out.println(permutation.count);

    }
}
    class per{
        public int count; // 순열 경우의 수

        public per(){
            this.count = 0;
        }


        //permutation arr에 있는 숫자들 중 r개 순열로 뽑기
        public void permutation(int[] arr,int depth,int r){
            if(depth == r){
                for(int i = 0; i < r; i++){
                    System.out.print(arr[i]);
                    System.out.print("");
                }
                System.out.println();
                count++;
                return;
            }
            for(int i = depth; i<arr.length;i++){
                this.Swap(arr, depth, i);
                this.permutation(arr,depth+1,r); // 재귀함수 시작
                this.Swap(arr,depth,i); // 복구
            }


        }

        public void Swap(int[] arr,int index1,int index2){
            int tmp = arr[index1];
            arr[index1] = arr[index2];
            arr[index2] = tmp;

        }



    }



