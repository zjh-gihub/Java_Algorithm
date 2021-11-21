package Algorithm.Sort;

/**
原始数组：3, 9, -1, 10, 20

        第一趟排序
        (1)  3, 9, -1, 10, 20   // 如果相邻的元素逆序就交换
        (2)  3, -1, 9, 10, 20
        (3)  3, -1, 9, 10, 20
        (4)  3, -1, 9, 10, 20

        第二趟排序
        (1) -1, 3, 9, 10, 20 //交换
        (2) -1, 3, 9, 10, 20
        (3) -1, 3, 9, 10, 20

        第三趟排序
        (1) -1, 3, 9, 10, 20
        (2) -1, 3, 9, 10, 20

        第四趟排序
        (1) -1, 3, 9, 10, 20


        小结冒泡排序规则
        (1) 一共进行 数组的大小-1 次 大的循环
        (2)每一趟排序的次数在逐渐的减少
        (3) 如果我们发现在某趟排序中，没有发生一次交换， 可以提前结束冒泡排序。这个就是优化
*/


public class BubbleSort {
    public static void main(String[] args) {
//        int arr[] = {3, 9, -1, 10, 20};
        int[] arr = new int[80000];
        for(int i =0; i < 80000;i++) {
            arr[i] = (int)(Math.random() * 8000000); //生成一个[0, 8000000) 数
        }

        long startTime = System.currentTimeMillis(); //获取开始时间

        bubbleSort(arr);; //测试的代码段

        long endTime = System.currentTimeMillis(); //获取结束时间

        System.out.println("程序运行时间：" + (endTime - startTime) + "ms"); //输出程序运行时间

    }

    // 将前面额冒泡排序算法，封装成一个方法
    public static void bubbleSort(int[] arr) {
        // 冒泡排序 的时间复杂度 O(n^2), 自己写出
        int temp = 0; // 临时变量
        boolean flag = false; // 标识变量，表示是否进行过交换
        for (int i = 0; i < arr.length - 1; i++) {

            for (int j = 0; j < arr.length - 1 - i; j++) {
                // 如果前面的数比后面的数大，则交换
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            //System.out.println("第" + (i + 1) + "趟排序后的数组");
            //System.out.println(Arrays.toString(arr));

            if (!flag) { // 在一趟排序中，一次交换都没有发生过
                break;
            } else {
                flag = false; // 重置flag!!!, 进行下次判断
            }
        }
    }
}
