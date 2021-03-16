package me.mrbluesky.algorithm.walkerheaven;

public class WalkerHeavenMain {
    public static void main(String[] args) {
        WalkerHeaven wh = new WalkerHeaven();
        int[][] a = new int[][]{{0, 2, 0, 0, 0, 2}, {0, 0, 2, 0, 1, 0}, {1, 0, 0, 2, 2, 0}};
        System.out.println(wh.solution(3, 6, a));
    }
}
