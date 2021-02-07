package me.mrbluesky.algorithm.changeword;

import java.util.ArrayList;

public class ChangeWordSolution {

    java.util.Queue<String> queue = new java.util.LinkedList<>();

    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        boolean hasTarget = false;
        for(int i = 0; i < words.length; i++) {
            if(words[i].equals(target)) {
                hasTarget = true;
                break;
            }
        }
        if(!hasTarget) return 0;

        queue.add(begin);
        String result = target;
        String changed = begin;
        int changeCount = 0;
//        System.out.println("### QUEUE SIZE: " + queue.size());
        while(!queue.isEmpty()) {
            printQueue();
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                String temp = queue.poll();
//                System.out.println("#### " + temp);
                if(temp.equals(target)){
//                    System.out.println("Fuck");
                    return changeCount;
                }
                for (String word : words) {
                    if (isOneEditDistance(temp, word)) {
                        queue.add(word);
                    }
                }
            }
            changeCount++;
        }

        return 0;
    }
    public boolean isOneEditDistance(String source, String target) {
        int cnt = 0;
        char[] sourceCharSeq = source.toCharArray();
        char[] targetCharSeq = target.toCharArray();
//        System.out.println("### Source = " + source + " Target: " + target);
        for(int i = 0; i < source.length(); i++) {
            if(sourceCharSeq[i] != targetCharSeq[i]) {
                cnt++;
                if(cnt > 1) {
                    return false;
                }
            }
        }
        if(cnt == 0) {
            return false;
        }
        return true;
    }

    public void printQueue() {
        System.out.println("############");
        for(String s: queue) {
            System.out.print(s + "\t");
        }
        System.out.println();
    }
}
