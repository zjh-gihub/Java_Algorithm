package Algorithm.Sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {-1, 2, 1};
        quicksort2(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

//        int[] arr = new int[80000];
//        for (int i = 0; i < 80000; i++) {
//            arr[i] = (int) (Math.random() * 8000000); //生成一个[0, 8000000) 数
//        }
//
//
//
        long startTime2 = System.currentTimeMillis(); //获取开始时间

        quicksort2(arr, 0, arr.length - 1);//测试的代码段

        long endTime2 = System.currentTimeMillis(); //获取结束时间

        System.out.println("第一个值作为基准值：" + (endTime2 - startTime2) + "ms"); //输出程序运行时间
//
//        long startTime = System.currentTimeMillis(); //获取开始时间
//
//        quicksort(arr, 0, arr.length - 1);
//        ; //测试的代码段
//
//        long endTime = System.currentTimeMillis(); //获取结束时间
//
//        System.out.println("中间基准值：" + (endTime - startTime) + "ms"); //输出程序运行时间
//

    }

    //以中间的数为基准
    public static void quicksort(int[] arr, int left, int right) {
        int l = left;//左下标
        int r = right;//右下标

        //pivot中轴值
        int pivot = arr[(left + right) / 2];
        int temp = 0;//临时变量，作为交换时使用
        //while循环的目的是让比pivot值小的放到左边
        //比pivot大的放在右边
        while (l < r) {
            //在pivot的左边一直找，找到大于等于pivot值，才推出
            while (arr[l] < pivot) {
                l += 1;
            }
            //在pivot的右边一直找，找到小于等于pivot值才退出
            while (arr[r] > pivot) {
                r -= 1;
            }

            //如果l>=r说明pivot的左右两的值，已经按照左边全是
            //小于等于pivot的值，右边全是大于等于pivot的值
            if (l >= r) {
                break;
            }

            //交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            //如果交换完成后，发现这个arr[l]==pivot值相等 则r--，前移
            if (arr[l] == pivot) {
                r -= 1;
            }
            //如果交换完成后，发现arr[r]==pivot值相等 则l++，后移
            if (arr[r] == pivot) {
                l += 1;
            }
        }
        //如果l==r，必须l++，r--，否则出现栈溢出
        if (l == r) {
            l += 1;
            r -= 1;
        }
        //向左递归
        if (left < r) {
            quicksort(arr, left, r);
        }
        //向右递归
        if (right > l) {
            quicksort(arr, l, right);
        }
    }


    //以第一个数为基准
    public static void quicksort2(int[] arr, int left, int right) {

        if (left > right) {
            return;
        }
        int basevalue = arr[left];
        int i = left, j = right;//左指针


        while (i != j) {
            //右指针从右至左遍历，直至遇见比基准值小的数
            while (arr[j] >= basevalue && i < j) {
                j--;
            }

            //左指针从第一个遍历，直至遇到
            while (arr[i] <= basevalue && i < j) {
                i++;
            }

            if (i < j) {//l与r没有相遇
                //交换位置
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }

        }
        //此时l与r相遇与基准值交换顺序
        arr[left] = arr[i];
        arr[i] = basevalue;


        quicksort2(arr, left, i - 1);
        quicksort2(arr, i + 1, right);

    }
}