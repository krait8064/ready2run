package org.example.reader;

import java.util.Stack;

/**
 * created by krait8064 at 2019/12/17
 */
public class TreeOrderVisit {
    static class Node {

        public Node getLeftNode() {
            return null;
        }

        public Node getRightNode() {
            return null;
        }
    }

    public static void preOrder_stack(Node root) {//先序遍历

        Stack<Node> stack = new Stack<Node>();
        Node node = root;

        while (node != null || stack.size() > 0) {//将所有左孩子压栈
            if (node != null) {//压栈之前先访问
                printNode(node);

                stack.push(node);
                node = node.getLeftNode();

            } else {
                node = stack.pop();
                node = node.getRightNode();
            }
        }
    }


    public static void inOrder_Stack(Node root) {//中序遍历

        Stack<Node> stack = new Stack<Node>();
        Node node = root;

        while (node != null || stack.size() > 0) {
            if (node != null) {
                stack.push(node);//直接压栈  
                node = node.getLeftNode();


            } else {
                node = stack.pop();//出栈并访问  
                printNode(node);
                node = node.getRightNode();
            }
        }
    }

    private static void printNode(Node node) {
    }


    public static void postOrder_Stack(Node root) {//后续遍历

        Stack<Node> stack = new Stack<Node>();
        Stack<Node> output = new Stack<Node>();//构造一个中间栈来存储逆后续遍历的结果  
        Node node = root;
        while (node != null || stack.size() > 0) {
            if (node != null) {
                output.push(node);
                stack.push(node);
                node = node.getRightNode();
            } else {
                node = stack.pop();
                node = node.getLeftNode();
            }
        }

        while (output.size() > 0) {
            printNode(output.pop());
        }

    }

    public static void preOrder(Node node) {
        if (node == null) {
            return;
        }
        printNode(node);
        preOrder(node.getLeftNode());
        preOrder(node.getRightNode());
    }

    public static void midOrder(Node node) {
        if (node == null) {
            return;
        }
        preOrder(node.getLeftNode());
        printNode(node);
        preOrder(node.getRightNode());
    }

    public static void postOrder(Node node) {
        if (node == null) {
            return ;
        }
        postOrder(node.getLeftNode());
        postOrder(node.getRightNode());
        printNode(node);
    }
}
