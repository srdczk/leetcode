package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Process {
    private static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] ss = bf.readLine().split("]");
        int cnt = 0;
        List<Node> list = new ArrayList<>();
        for (String s : ss) {
            if (cnt++ == 0) {
                String[] p = s.substring(1).split(",");
                list.add(new Node(Integer.parseInt(p[0]), Integer.parseInt(p[1].substring(1))));
            } else {
                String[] p = s.substring(3).split(",");
                list.add(new Node(Integer.parseInt(p[0]), Integer.parseInt(p[1].substring(1))));
            }
        }
        Collections.sort(list, (a, b) -> b.y - a.y);
        cnt = 1;
        int x = list.get(0).y;
        for (int i = 0; i < list.size(); i++) {
            if (cnt == 88) System.out.println(list.get(i).x + "," + list.get(i).y);
            if (list.get(i).y != x) {
                cnt++;
                x = list.get(i).y;
            }
        }
    }
}
