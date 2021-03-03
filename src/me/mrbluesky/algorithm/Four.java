package me.mrbluesky.algorithm;

import java.util.Arrays;
public class Four {
    int solution(int[] A, int[] B) {
        int n = A.length;
        int m = B.length;;
        Arrays.sort(A);
        Arrays.sort(B);
        int i = 0;
        for (int k = 0; k < n; k++) {
            if (i < m - 1 && B[i] < A[k])
                i += 1;
            if (A[k] == B[i])
                return A[k];
        }
        return -1;
    }
}

/*

public class Four {
    int solution(int[] A, int[] B) {
        int n = A.length;
        int m = B.length;;
        Arrays.sort(A);
        Arrays.sort(B);
        int i = 0;
        for (int k = 0; k < n;) {
            System.out.println("k = " + k + ", i = " + i + " ## A[" + k + "] = " + A[k] + ", B[" + i + "] = " + B[i]);
            if (i < m - 1 && B[i] < A[k])
                i += 1;
            if (A[k] == B[i])
                return A[k];
            else k += 1;
        }
        return -1;
    }
}
*/
