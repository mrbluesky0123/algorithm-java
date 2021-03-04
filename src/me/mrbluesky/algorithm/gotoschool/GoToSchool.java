package me.mrbluesky.algorithm.gotoschool;

public class GoToSchool {
    int[][] puddles = null;
    int[][] map = null;
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        this.map = new int[n+1][m+1];
        this.puddles = puddles;

        for(int j = 1; j <= n; j++) {
            for(int i = 1; i <= m; i++) {
                if(i == 1 && j == 1) {
                    map[j][i] = 1;
                } else if(map[j][i] == -1) {
                    map[j][i] = 0;
                } else {
                    map[j][i] = (map[j-1][i] + map[j][i-1]) % 1000000007;
                }
            }
        }

        for(int j = 0; j < map.length; j++) {
            for(int i = 0; i < map[0].length; i++) {
                System.out.print(map[j][i] + " ");
            }
            System.out.println();
        }



        return map[n][m];
    }

    public void init() {
        for(int[] puddle: this.puddles) {
            this.map[puddle[1]][puddle[0]] = -1;
        }
    }

}
