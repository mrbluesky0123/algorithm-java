package me.mrbluesky.algorithm.immigration;

import java.util.Scanner;

public class Immigration {

    public static void main(String[] args) {
        int n, m = 0;
        long time[] = new long[100000];
        long val = 0;

        Scanner s = new Scanner(System.in);
        n = Integer.parseInt(s.next());
        m = Integer.parseInt(s.next());

        for(int i = 0; i < n; i++) {
            time[i] = s.nextLong();
            val = Math.max(val, time[i]);
        }

        long start = 1;
        long end = val * m;
        long result = val * m;
        while(start < end) {
            long mid = (start + end) / 2;
            long temp = 0;
            for(int i = 0; i < n; i++) {
                temp += mid / time[i];
            }
            if(temp < m) {
                start = mid + 1;
            } else {
                result = Math.min(result, mid);
                end = result;
            }

        }

        System.out.println(result);

    }

}

