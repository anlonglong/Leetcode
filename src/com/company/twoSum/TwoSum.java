package com.company.twoSum;

import java.util.Arrays;

public class TwoSum {

    public static void main(String[] args) {
        int[] ints = twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println("ints = " + Arrays.toString(ints));
    }

    public static int[] twoSum(int[] numbs, int target){
        int[] index = new int[]{0,0};
        for (int i = 0; i < numbs.length; i++) {
            int item = numbs[i];
            for (int j = i+ 1 /*位置不相等*/; j < numbs.length; j++) {
                if (item + numbs[j] == target) {
                    index[0] = i;
                    index[1] = j;
                    break;//我们假定只执行一次
                }
            }
        }
        return index;
    }

}
