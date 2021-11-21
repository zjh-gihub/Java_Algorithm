package Algorithm.Search;

import java.util.Arrays;

public class InsertValueSearch {
    public static void main(String[] args) {
        int [] arr = new int[100];
        for(int i=0;i<100;i++){
            arr[i]=i+1;
        }
//        System.out.println(Arrays.toString(arr));

        System.out.println(insertcaluesearch2(arr,100));
    }

    
    //编写插值查找算法递归
    /**
     *
     * @param arr 数组
     * @param left 左边索引
     * @param right 右边索引
     * @param findvalue 查找值
     * @return int 如果找到，就返回对应的下标，如果没有找到，返回-1
     * @author JianHui
     * @date 2021/10/25 16:57
     */
    public static int insertcaluesearch(int[] arr, int left, int right, int findvalue) {

        //注意：findVal < arr[0]  和  findVal > arr[arr.length - 1] 必须需要
        //否则我们得到的 mid 可能越界
        if (left > right || findvalue < arr[0] || findvalue > arr[arr.length - 1]) {
            return -1;
        }

        int mid = left + (right - left) * (findvalue - arr[left]) / (arr[right] - arr[left]);

        if (findvalue > arr[mid]) {
            return insertcaluesearch(arr, left + 1, right, findvalue);
        } else if (findvalue < arr[mid]) {
            return insertcaluesearch(arr, left, right - 1, findvalue);
        } else {
            return mid;
        }

    }


    //非递归编写
    /**
     *
     * @param arr   数组
     * @param fiandvalue    查找值
     * @return int
     * @author JianHui
     * @date 2021/10/25 17:28
     */
    public static int insertcaluesearch2(int []arr,int fiandvalue){
        int left = 0;
        int right = arr.length-1;
        while(left<=right){
            int mid = left + (right - left) * (fiandvalue - arr[left]) / (arr[right] - arr[left]);
            if(fiandvalue>arr[mid]){
                left+=1;
            }else if(fiandvalue<arr[mid]){
                right+=1;
            }else {
                return mid;
            }
        }
        return left;
    }
}
