package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Process {
    private static class Node {
        double len, s;
        public Node(double x, double y) {
            len = x;
            s = y;
        }
    }
    private static double FI = Math.PI / 2.0;
    private static boolean isZero(double d) {
        return Math.abs(d) < 1e-6;
    }
    public static double[][] generateField(double x) {
        int len = (int)(x * 10);
        //分成100个角度
        int n = 200;
        double dx = x / len;
        double[][] res = new double[len][len];
        List<Node>[][] nodes = new List[len][len];

        for (int i = 0; i < len; i++) {
            nodes[i] = new List[len];
            for (int j = 0; j < len; j++) {
                nodes[i][j] = new ArrayList<>();
            }
        }
        //计算第i条线会和哪些格点相交, 只需要计算一半
        //由于对称性,只需要计算
        //k == 0 时候, 不计算
        for (int k = 1; k <= n / 2; k++) {
            //当小于45度时候
            double tanA = Math.tan(Math.PI / 2.0 / n * k);
            double sinA = Math.sin(Math.PI / 2.0 / n * k);
            double cosA = Math.cos(Math.PI / 2.0 / n * k);
            if (k < n / 2) {
                //计算和格点相交
                for (int i = 1; i <= len; i++) {
                    double dy = (i * dx) * tanA;
                    int s = (int)(dy / dx);
                    double pd = dx * tanA;
                    double py = dy - s * dx;
                    if (!isZero(py)) {
                        if (py > pd) {
                            nodes[i - 1][s].add(new Node(dx / cosA, ((double)k / n) * FI * x));
                            nodes[s][i - 1].add(new Node(dx / cosA, ((double)(n - k) / n) * FI * x));
                        } else {
                            nodes[i - 1][s].add(new Node(py / sinA, ((double)k / n) * FI * x));
                            nodes[s][i - 1].add(new Node(py / sinA, ((double)(n - k) / n) * FI * x));
                        }
                    }
                }
            } else {
                //当等于45度的时候
                for (int i = 0; i < len; i++) {
                    nodes[i][i].add(new Node(dx / Math.cos(Math.PI / 4), 0.5 * FI * x));
                }
            }
        }
        //当角度等于90度的时候, 还未计算
        for (int i = 0; i < len; i++) {
            nodes[0][i].add(new Node(dx, FI * x));
        }

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (nodes[i][j].size() == 0) {
                    res[i][j] = 0;
                } else {
                    double p = 0;
                    double q = 0;
                    for (Node node : nodes[i][j]) {
                        p += node.len * node.s;
                        q += node.len;
                    }
                    res[i][j] = p / q;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        double[][] d = generateField(3);
        for (double[] c : d) {
            for (double p : c) System.out.print(p + " ");
            System.out.println();
        }
    }
}
