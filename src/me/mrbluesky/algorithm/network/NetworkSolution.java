package me.mrbluesky.algorithm.network;

public class NetworkSolution {
    private boolean[][] visited;
    private int[][] computers;

    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[computers.length][computers[0].length];

        this.computers = computers;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < computers[i].length; j++) {
                if(computers[i][j] == 1 && !visited[i][j]) {
                    System.out.println("Target: " + i);
                    int cnt = visitComputer(i);
                    answer++;
                }
            }
        }
        return answer;
    }

    public int visitComputer(int comNum) {
//        printVisited(comNum);
        int cnt = 1;
        for(int i = 0; i < computers[comNum].length; i++) {
            if(computers[comNum][i] == 1 && !visited[comNum][i]) {
                visited[comNum][i] = true;
                if(comNum != i)
                    cnt += visitComputer(i);
            }
        }
        return cnt;
    }

    public void printVisited(int comNum) {
        System.out.println("############### comNum: " + comNum);
        for(int i = 0; i < this.visited.length; i++) {
            System.out.print("||\t");
            for(int j = 0; j < this.visited[0].length; j++) {
                System.out.print(this.visited[i][j] + "\t||\t");
            }
            System.out.println();
        }
        System.out.println();
    }
}
