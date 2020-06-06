package api;

import java.util.Arrays;
import java.util.Random;

/**
 * @author hongzf
 * @date 2020/6/6
 */
public class MyArraysDemo {
    public static void main(String[] args) {
        //排序 从小到大
        int[] ints = {86, 23, 78, 5, 81, 91, 32, 92, 15, 49};
        System.out.println(Arrays.toString(ints));
        Arrays.sort(ints);
        System.out.println(Arrays.toString(ints));

        //二分查找法查找指定数字在数组中的位置
        //注意,数组中的元素必须是有序的
        int index = Arrays.binarySearch(ints, 49);
        System.out.println(index);
    }

    /**
     * 构建一个0~99的随机数组
     *
     * @param arrLength 数组长度
     * @return 数组
     */
    public static int[] getInts(int arrLength) {
        int[] arr = new int[arrLength];
        Random random = new Random();
        for (int n = 0; n < arr.length; n++) {
            int i = random.nextInt(100 - 1);
            arr[n] = i;
        }
        return arr;
    }
}
