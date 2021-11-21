package Algorithm.Sort;

import java.util.Arrays;

public class InsertSort {

    public static void main(String[] args) {
//        int[] arr = {101, 34, 119, 1, -1, 89};
//        insertsort(arr);
//        System.out.println(Arrays.toString(arr));

        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 8000000); //生成一个[0, 8000000) 数
        }
        long startTime = System.currentTimeMillis(); //获取开始时间

        insertsort(arr);
        ; //测试的代码段

        long endTime = System.currentTimeMillis(); //获取结束时间

        System.out.println("程序运行时间：" + (endTime - startTime) + "ms"); //输出程序运行时间

    }


    public static void insertsort(int[] arr) {
        int insertval = 0;
        int insertindex = 0;
        for (int i = 1; i < arr.length; i++) {
            insertval = arr[i];
            insertindex = i - 1;
            // 给insertVal 找到插入的位置
            // 说明
            // 1. insertIndex >= 0 保证在给insertVal 找插入位置，不越界
            // 2. insertVal < arr[insertIndex] 待插入的数，还没有找到插入位置
            // 3. 就需要将 arr[insertIndex] 后移
            while (insertindex >= 0 && insertval < arr[insertindex]) {
                arr[insertindex + 1] = arr[insertindex];
                insertindex--;
            }
            // 当退出while循环时，说明插入的位置找到, insertIndex + 1
            //这里我们判断是否需要赋值
            if (insertindex + 1 != i) {
                arr[insertindex + 1] = insertval;
            }
        }
    }


}
