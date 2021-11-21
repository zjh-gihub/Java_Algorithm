package Algorithm.Sort;

import java.util.Arrays;

public class MergetSort {
    public static void main(String[] args) {
//        int arr[] = {8, 4, 5, 7, 1, 3, 6, 2};
//        int[] temp = new int[arr.length];
//
//        mergetsort(arr, 0, arr.length - 1, temp);
//        System.out.println(Arrays.toString(arr));
        int[] arr = new int[80000];
        for(int i =0; i < 80000;i++) {
            arr[i] = (int)(Math.random() * 8000000); //生成一个[0, 8000000) 数
        }

        long startTime = System.currentTimeMillis(); //获取开始时间

        int[] temp = new int[arr.length];
        mergetsort(arr, 0, arr.length - 1, temp);; //测试的代码段

        long endTime = System.currentTimeMillis(); //获取结束时间

        System.out.println("程序运行时间：" + (endTime - startTime) + "ms"); //输出程序运行时间



    }


    //分+合方法
    public static void mergetsort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2; //中间索引
            //向左递归进行分解
            mergetsort(arr, left, mid, temp);
            //向右递归进行分解
            mergetsort(arr, mid + 1, right, temp);
            //合并
            merge(arr, left, mid, right, temp);

        }
    }


    //合并的方法

    /**
     * @param arr   排序的原始数组
     * @param left  左边有序序列的初始索引
     * @param mid   中间索引
     * @param right 右边索引
     * @param temp  做中转的数组
     */
    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;//初始化i, 左边有序序列的初始索引
        int j = mid+1;//初始化j, 右边有序序列的初始索引
        int t = 0;// 指向temp数组的当前索引
        //(一)
        //先把左右两边(有序)的数据按照规则填充到temp数组
        //直到左右两边的有序序列，有一边处理完毕为止
        while (i <= mid && j <= right) {
            //如果左边的有序序列的当前元素，小于等于右边有序序列的当前元素
            //即将左边的当前元素，填充到 temp数组
            //然后 t++, i++
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                i++;
                t++;
            } else {//反之,将右边有序序列的当前元素，填充到temp数组
                temp[t] = arr[j];
                j++;
                t++;
            }
        }
        //(二)
        //把有剩余数据的一边的数据依次全部填充到temp
        while (i <= mid) {//左边有剩余
            temp[t] = arr[i];
            t++;
            i++;
        }
        while (j <= right) {//右边有剩余
            temp[t] = arr[j];
            t++;
            j++;
        }

        //(三)
        //将temp数组的元素拷贝到arr
        //注意，并不是每次都拷贝所有
        t = 0;
        int templeft = left;
        //第一次合并 tempLeft = 0 , right = 1 //  tempLeft = 2  right = 3 // tL=0 ri=3
        //最后一次 tempLeft = 0  right = 7
        while (templeft <= right) {
            arr[templeft] = temp[t];
            t++;
            templeft++;
        }
    }
}
