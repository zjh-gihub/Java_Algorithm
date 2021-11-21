package Algorithm.Sort;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
//        int[] arr = { 8, 9, 1, 7, 2, 20,100,3, 5, 4, 6, 0 };
//        shellsort2(arr);
//        System.out.println(Arrays.toString(arr));

        int[] arr = new int[80000];
        for(int i =0; i < 80000;i++) {
            arr[i] = (int)(Math.random() * 8000000); //生成一个[0, 8000000) 数
        }
        long startTime = System.currentTimeMillis(); //获取开始时间

        shellsort2(arr);; //测试的代码段

        long endTime = System.currentTimeMillis(); //获取结束时间

        System.out.println("程序运行时间：" + (endTime - startTime) + "ms"); //输出程序运行时间

    }

    // 希尔排序时， 对有序序列在插入时采用交换法,
    // 思路(算法) ===> 代码
    public static void shellsort(int []arr){
        int temp=0;
        // 根据前面的逐步分析，使用循环处理
        for(int g=arr.length/2;g>0;g/=2){
            for(int i = g;i<arr.length;i++){
                // 遍历各组中所有的元素(共gap组，每组有个元素), 步长gap
                for(int j=i-g;j>=0;j-=g){
                    // 如果当前元素大于加上步长后的那个元素，说明交换
                    if(arr[j]>arr[j+1]){
                        temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                }
            }
        }

    }

    public static void shellsort2(int []arr){

        // 增量gap, 并逐步的缩小增量
        for(int g=arr.length/2;g>0;g/=2){
            // 从第gap个元素，逐个对其所在的组进行直接插入排序
            for(int i = g;i<arr.length;i++){
                int temp =arr[i];
                int index = i-g;
                while(index>=0&&temp<arr[index]){
                    //移动
                    arr[index+g]=arr[index];
                    index-=g;
                }
                // 当退出while循环时，说明插入的位置找到, insertIndex + 1
                //这里我们判断是否需要赋值
                //当退出while后，就给temp找到插入的位置
                if (index + g != i) {
                    arr[index + g] = temp;
                }
            }

        }
    }
}
