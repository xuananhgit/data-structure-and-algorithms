package tree;

public class Test {
    public static void main(String[] args) {
        var n0 = new TreeNode(0);
        var n1 = new TreeNode(1);
        var n2 = new TreeNode(2);
        var n3 = new TreeNode(3);
        var n4 = new TreeNode(4);
        var n5 = new TreeNode(5);
        var n6 = new TreeNode(6);
        var n7 = new TreeNode(7);


        n0.left = n1;
        n0.right = n2;
        n1.left = n3;
        n1.right = n4;
        n2.right = n5;
        n4.left = n6;
        n4.right = n7;

        MyBST.postOrder(n0);

    }
}
