package arithmetics;

import java.util.Arrays;
import java.util.Random;

/**
 * 冒泡排序
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = new int[5];
        Random random = new Random();
        for (int n = 0; n < arr.length; n++) {
            int i = random.nextInt(100 - 1);
            arr[n] = i;
        }
        //原始数组顺序
        print(arr);

        int[] arrSort = bubbleSort(arr);
        //冒泡排序后的顺序
        print(arrSort);

    }

    private static void print(int[] arrSort) {
        System.out.println(Arrays.toString(arrSort));
    }

    private static int[] bubbleSort(int[] arr) {
        int num;
        //外循环是数组长度-1 长度为n的数组只需要比较n-1次
        for (int i = 0; i < arr.length - 1; i++) {
            //-1 : 防止数组越界
            //-i : 每轮比较结束后就少比较一个数字
            for (int j = 0; j < arr.length - 1 - i; j++) {
                boolean is = arr[j] > arr[j + 1];
                if (is) {
                    num = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = num;
                }
            }
        }
        return arr;
    }
}
