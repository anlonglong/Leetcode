package com.company.numEnclaves;

public class NumEnclaves {

    private static final int[][] grid  = {{0,0,0,0},{1,0,1,0},{0,1,1,0},{0,0,0,0}};

    public static void main(String[] args) {
        int num = Solution.numEnclaves(grid);
        System.out.println("Num = " + num);
    }
}
