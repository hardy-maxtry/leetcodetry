package solution.solution100_200;

import bean.Node;

public class Solution116 {
    public Node connect(Node root) {
        if (root == null){
            return root;
        }
        if(root.left == null || root.right == null){
            root.next = null;
            return root;
        }
        root.left.next = root.right;
        root.next = null;
        calcNode(root.left, root);
        calcNode(root.right, root);
        return root;
    }

    public Node calcNode(Node n, Node parent){
        System.out.println(n.val);

        if(n.left != null && n.right != null){
            n.left.next = n.right;
        }
        // if(parent.next == null){
        //     n.next = null;
        // }else{
        //     if(n.next == null){
        //         n.next = parent.next.left;
        //     }
        // }
        if(n.next == null){

            if(parent.next == null){
                n.next = null;
            }else{
                n.next = parent.next.left;
            }
        }
        if(n.left == null || n.right == null){
            return n;
        }
        calcNode(n.left, n);
        calcNode(n.right, n);
        return n;
    }

    public static void  main(String[] args){
        Solution116 solution116 = new Solution116();
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        Node result= solution116.connect(root);
        System.out.println(result.val);
    }
}
