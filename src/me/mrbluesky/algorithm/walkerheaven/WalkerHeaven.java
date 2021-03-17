package me.mrbluesky.algorithm.walkerheaven;

public class WalkerHeaven {

    private int MOD = 20170805;
    private int[][] right;
    private int[][] down;
    private int r;
    private int c;
    private int map[][];
    public int solution(int m, int n, int[][] cityMap) {
        int answer = 0;
        right = new int[m+1][n+1];
        down = new int[m+1][n+1];
        r = m;
        c = n;
        map = cityMap;
        right[1][1] = down[1][1] = 1;
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(cityMap[i-1][j-1] == 0) {
                    right[i][j] += (right[i][j-1] + down[i-1][j]) % MOD;
                    down[i][j] += (right[i][j-1] + down[i-1][j]) % MOD;
                } else if(cityMap[i-1][j-1] == 2) {
                    right[i][j] = right[i][j-1];
                    down[i][j] = down[i-1][j];
                }
//                showProcess();
            }
        }
        return (right[m][n-1] + down[m-1][n]) % MOD;
    }

    public void showProcess() {
        System.out.println("---------------------------");
        System.out.println("<RIGHT>");
        for(int i = 0; i <= r; i++) {
            for(int j = 0; j <= c; j++) {
                System.out.print(" " + right[i][j]);
            }
            System.out.println();
        }
        System.out.println("<DOWN>");
        for(int i = 0; i <= r; i++) {
            for(int j = 0; j <= c; j++) {
                System.out.print(" " + down[i][j]);
            }
            System.out.println();
        }
    }

}


