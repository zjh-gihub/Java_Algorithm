package Algorithm.KMP;

import java.util.Arrays;

public class kmp_Demo {
    public static void main(String[] args) {
        String s = "ABACABAA";
        String s2 = "ACA";
        int []next = prefix_table(s);

        System.out.println(Arrays.toString(next));
        int []m_next = move_prefix(next);
        System.out.println(Arrays.toString(m_next));

        kmp_search(s,s2);
    }

    public static int[] prefix_table(String s){
        int []next=new int[s.length()];
        next[0]=0;
        for(int i = 1, j = 0; i < s.length(); i++) {
            //当s.charAt(i) != s.charAt(j) ，我们需要从next[j-1]获取新的j
            //直到我们发现 有  s.charAt(i) == s.charAt(j)成立才退出
            //这时kmp算法的核心点
            while(j > 0 && s.charAt(i) != s.charAt(j)) {
                j = next[j-1];
            }

            //当s.charAt(i) == s.charAt(j) 满足时，部分匹配值就是+1
            if(s.charAt(i) == s.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }

    public static int []move_prefix(int []prefix){
        int i ;
        int len = prefix.length;
        for(i=len-1;i>0;i--) {
            prefix[i] = prefix[i - 1];
        }
        prefix[0]=-1;
        return prefix;
    }

    public static void kmp_search(String s1,String s2){
        int len = s2.length();
        int[]prefix = new int[len];
        prefix = prefix_table(s2);
        move_prefix(prefix);
        //i为指向s1的指针，j为指向s2的指针
        for(int i=0,j=0;i<s1.length();){
            if(j==len-1 && s1.charAt(i)==s2.charAt(j)){
                System.out.printf("Found s2 at %d\n",i-j);
                j=prefix[j];
            }
            if(s1.charAt(i)==s2.charAt(j)){
                i++;
                j++;
            }else{
                j=prefix[j];
                if(j==-1){
                    i++;
                    j++;
                }
            }
        }
    }
}
