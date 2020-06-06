package arithmetics;

/**
 * 二分查找法
 */
public class BinarySearch {
    public static void main(String[] args) {
        //一个int类型的数组从小到大排列,从中找出一个给定的int值,如果存在返回该数组的索引,否则返回-1
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        //定义需要查找的int类型的值
        int num = 1;

        int index = binarySearch(arr, num);
        System.out.println(index);
    }

    /**
     * 二分查找法
     *
     * @param arr 数组中的元素从小到大
     * @param num 需要查找的数
     * @return 数组的索引, 如果没找到或者不存在返回 -1
     */
    private static int binarySearch(int[] arr, int num) {
        //最大索引
        int max = arr.length - 1;
        //最小索引
        int min = 0;
        //中间索引
        int mid;
        while (max >= min) {
            mid = (max + min) >> 1;
            if (arr[mid] < num) {
                //中位数小于查找的值
                min = mid + 1;
            } else if (arr[mid] > num) {
                //中位数大于查找的值
                max = mid - 1;
            } else {
                //中位数等于查找的值
                return mid;
            }
        }
        return -1;
    }
}
