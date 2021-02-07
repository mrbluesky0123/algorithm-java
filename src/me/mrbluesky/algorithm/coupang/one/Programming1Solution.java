package me.mrbluesky.algorithm.coupang.one;

public class Programming1Solution {
    private int[] A;
    public int solution(int []A, int S) {
        int answer = 0;
        this.A = A;
        int start = 0, end = 0;
        while(start <= A.length && end <= A.length) {
            int sum = getSum(start, end);
            if(sum < S) {
                if(end < A.length-1) {
                    end++;
                } else if(end == A.length-1) {
                    break;
                }
            } else if(sum > S) {
                start++;
            } else {
                answer++;
                if(start < A.length-1) {
                    start++;
                }
            }

        }
        return answer;
    }

    public int getSum(int start, int end) {
        int sum = 0;
        for(int i = start; i <= end; i++) {
            sum += A[i];
        }
        System.out.println("### " + start + ", " + end + ": " + sum);
        return sum;
    }
}
