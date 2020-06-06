package arithmetics;

import api.MyArraysDemo;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = MyArraysDemo.getInts(5);
        //原始数组顺序
        print(arr);

        int[] arrSort = bubbleSort(arr);
        //冒泡排序后的顺序
        print(arrSort);

    }

    private static void print(int[] arrSort) {
        System.out.println(Arrays.toString(arrSort));
    }

    /**
     * 冒泡排序
     *
     * @param arr 需要排序的数组
     * @return 排序完成的数组
     */
    private static int[] bubbleSort(int[] arr) {
        int temp;
        //外循环是数组长度-1 长度为n的数组只需要比较n-1次
        for (int i = 0; i < arr.length - 1; i++) {
            //-1 : 防止数组越界
            //-i : 每轮比较结束后就少比较一个数字
            for (int j = 0; j < arr.length - 1 - i; j++) {
                boolean is = arr[j] > arr[j + 1];
                if (is) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }
}
