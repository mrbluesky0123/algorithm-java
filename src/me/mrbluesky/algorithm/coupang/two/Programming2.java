package me.mrbluesky.algorithm.coupang.two;

import java.util.Arrays;

public class Programming2 {
    public static void main(String[] args) {
        Programming2Solution p2s = new Programming2Solution();
        String[] answer = p2s.solution(new String[]{"DS7651 A0", "CA0055 D+", "AI5543 C0", "OS1808 B-", "DS7651 B+", "AI0001 F", "DB0001 B-", "AI5543 D+", "DS7651 A+", "OS1808 B-"});
        for(String a : answer) {
            System.out.println(a);
        }
    }
}
