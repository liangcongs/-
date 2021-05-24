package tree;

public class SearchTree {

   static Node pre;
    public static class Node {
        int data;
        Node left;
        Node right;
        int lTag;
        int rTag;

        public Node(int data) {
            this.data = data;
        }



    }
    public static void inthread(Node head) {
        if (head == null) {
            return;
        }
        inthread(head.left);
        process(head);
        inthread(head.right);
    }

    private static void process(Node head) {
        if (head.left == null) {
            head.left=pre;
            head.lTag=1;
        }
        if(pre != null && pre.right == null) {
            pre.right = head;
            pre.rTag = 1;
        }
        pre = head;
    }

    public static void main(String[] args) {
        Node head = new Node(5);
        head.left = new Node(4);
        head.right = new Node(7);
        head.left.left = new Node(8);
        inthread(head);
    }
}
