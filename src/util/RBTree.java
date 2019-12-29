package util;

import com.sun.org.apache.regexp.internal.RE;

/**
 * @Auther: srd-czk
 * @Date: 2019/12/29
 * @Description: util
 * @version: 1.0
 */
public class RBTree<K extends Comparable<K>, V> {

    private static final boolean RED = true, BLACK = false;

    private class Node {
        private K key;
        private V val;
        private boolean color;
        private Node left, right;
        public Node(K k, V v) {
            key = k;
            val = v;
            color = RED;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public RBTree() {
        root = null;
        size = 0;
    }

    public void add(K k, V v) {
        root = add(root, k, v);
        root.color = BLACK;
    }


    private boolean isRed(Node node) {
        return node != null && node.color;
    }

    // 红黑树  的 左旋转
    private Node leftRotate(Node node) {
        Node x = node.right;
        node.right = x.left;
        x.left = node;
        x.color = node.color;
        node.color = RED;
        return x;
    }

    // 红黑树的右旋转
    private Node rightRotate(Node node) {
        Node x = node.left;
        node.left = x.right;
        x.right = node;
        x.color = node.color;
        node.color = RED;
        return node;
    }

    private void colorFilp(Node node) {
        node.color = RED;
        node.left.color = BLACK;
        node.right.color = BLACK;
    }

    private Node add(Node node, K k, V v) {
        if (node == null) {
            size++;
            return new Node(k, v);
        }
        if (k.compareTo(node.key) < 0) node.left = add(node.left, k, v);
        else if (k.compareTo(node.key) > 0) node.right = add(node.right, k, v);
        else node.val = v;

        if (!isRed(node.left) && isRed(node.right)) node = leftRotate(node);

        if (isRed(node.left) && isRed(node.left.left)) node = rightRotate(node);

        if (isRed(node.left) && isRed(node.right)) colorFilp(node);

        return node;
    }

}
