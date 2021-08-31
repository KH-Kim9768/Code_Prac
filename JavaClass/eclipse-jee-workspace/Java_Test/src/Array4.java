
import java.util.ArrayList;

public class Array4 {
    // 추가 : n차원 배열(리스트)에 대한 재귀 출력 함수
    public static <T> void showArray(ArrayList<T> arr){
        for(int i = 0; i < arr.size(); i++){
            if(arr.get(i) instanceof ArrayList){
                showArray((ArrayList<T>) arr.get(i));
            }
            else{
                System.out.print(arr.get(i) + "\t");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[][] = {
            {10,    20,     30,     40},
            {11,    22,     33,     44},
            {1,     2,      3,      4}};

        for (int[] v : arr){
            for (int w : v){
                System.out.print(w + "\t");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println();


        // n차원 배열을 위한 동적 할당 배열(리스트)
        ArrayList arrL = new ArrayList();
        for (int v[] : arr){
            ArrayList temp = new ArrayList();
            for(int w : v){
                temp.add(w);
            }
            arrL.add(temp);
        }

        showArray(arrL);
    }
}