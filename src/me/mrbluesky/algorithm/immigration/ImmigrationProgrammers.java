package me.mrbluesky.algorithm.immigration;

import java.util.Arrays;
import java.util.OptionalInt;

public class ImmigrationProgrammers {
    public static void main(String[] args) {
        int[] items = {7, 10};
        System.out.println(solution(6, items));
    }

    public static long solution(int n, int[] times) {
        int max = -999;
        for(int i = 0; i < times.length; i++) {
            max = Math.max(max, times[i]);
        }
        long start = 1;
        long end = max * n;
        long answer = max * n;
        while(start < end) {
            long mid = (start + end) / 2;
            long temp = 0;
            for(int i = 0; i < times.length; i++) {
                temp += mid / times[i];
            }
            if(temp < n) {
                start = mid + 1;
            } else {
                answer = Math.min(answer, mid);
                end = answer;
            }

        }
//        Arrays.stream(items).forEach(() -> {});
        return answer;
    }
}
