package Algorithm.Sort;

import java.util.Arrays;
/**原始的数组 ： 101, 34, 119, 1
        第一轮排序 :   1, 34, 119, 101
        第二轮排序 :   1, 34, 119, 101
        第三轮排序 :   1, 34, 101, 119

        说明：
        1. 选择排序一共有 数组大小 - 1 轮排序
        2. 每1轮排序，又是一个循环, 循环的规则(代码)
        2.1先假定当前这个数是最小数
        2.2 然后和后面的每个数进行比较，如果发现有比当前数更小的数，就重新确定最小数，并得到下标
        2.3 当遍历到数组的最后时，就得到本轮最小数和下标
        2.4 交换 [代码中再继续说 ]*/

public class SelectSort {
    public static void main(String[] args) {
//        int [] arr = {101, 34,90,1,119,1, -1, 90, 123};
        int[] arr = new int[80000];
        for(int i =0; i < 80000;i++) {
            arr[i] = (int)(Math.random() * 8000000); //生成一个[0, 8000000) 数
        }

        long startTime = System.currentTimeMillis(); //获取开始时间

        selectsort(arr);; //测试的代码段

        long endTime = System.currentTimeMillis(); //获取结束时间

        System.out.println("程序运行时间：" + (endTime - startTime) + "ms"); //输出程序运行时间


    }


    public static void selectsort(int []arr){

        for(int i=0;i<arr.length;i++){
            int index = i;
            int max=arr[i];
            for(int j=i+1;j<arr.length;j++){
                if(max<=arr[j]){
                    max=arr[j];
                    index=j;
                }
            }
            if(index!=i) {
                arr[index] = arr[i];
                arr[i] = max;
            }
        }
    }

    public static void show(int []arr){
        for(int i=0;i<arr.length;i++){
            System.out.printf("%d"+" ",arr[i]);
        }
        System.out.println();
    }
}
