package org.blbulyandavbulyan.jseminars.seminar1.classwork;
//Дан массив двоичных чисел, например [1,1,0,1,1,1], вывести максимальное количество подряд идущих 1.


public class ArrayTask {
    public static void main(String[] args) {
        System.out.println(countOfOnes(new int[]{1,1,0,1,1,1}));
    }
    public static int countOfOnes(int[] arr){
        int count = 0;
        int maxCount = 0;
        for (int j : arr) {
            if (j == 0) {
                if (count > maxCount) maxCount = count;
                count = 0;
            } else if (j == 1) count++;
        }
        if(count > maxCount)maxCount = count;
        return maxCount;
    }
}
