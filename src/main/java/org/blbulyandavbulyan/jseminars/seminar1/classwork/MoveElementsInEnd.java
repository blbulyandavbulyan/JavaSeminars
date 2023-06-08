package org.blbulyandavbulyan.jseminars.seminar1.classwork;

import java.util.Arrays;

//Дан массив nums = [3,2,2,3] и число val = 3.
//        Если в массиве есть числа, равные заданному, нужно перенести эти элементы в конец массива.
//        Таким образом, первые несколько (или все) элементов массива должны быть отличны от заданного, а остальные - равны ему.
public class MoveElementsInEnd {
    public static void main(String[] args) {
        int[] arr = new int[]{2,2,3,3,3,2,2,3,3};
        moveElementsInEnd(arr, 3);
        System.out.println(Arrays.toString(arr));
    }
    public static void moveElementsInEnd(int[] arr, int val){
        int endIndex = arr.length - 1;
        for(int i = arr.length - 1; i >= 0; i--){
            if(arr[i] == val)endIndex--;
            else break;
        }
        for (int i = 0; i <= endIndex; i++) {
            if(arr[i] == val){
                int temp = arr[endIndex];
                arr[endIndex] = arr[i];
                arr[i] = temp;
                endIndex--;
            }
        }
    }
}
