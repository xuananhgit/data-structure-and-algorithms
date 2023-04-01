package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MyBST {
    public TreeNode mRoot;
    public int sum;

    public MyBST() {}

    public TreeNode insert(TreeNode root, int value) {
        TreeNode newNode = new TreeNode(value);
        if (Objects.isNull(root)) {
            mRoot = newNode;
            return mRoot;
        }
        var temp = root;
        while (true) {
            if (value > temp.value) {
                if (Objects.isNull(temp.right)) {
                    temp.right = newNode;
                    break;
                } else {
                    temp = temp.right;
                }
            } else {
                if (Objects.isNull(temp.left)) {
                    temp.left = newNode;
                    break;
                } else {
                    temp = temp.left;
                }
            }
        }
        return root;
    }

    public TreeNode insertIntoBST(TreeNode rootNode, int value) {
        var newRoot = new TreeNode(value);
        if (Objects.isNull(rootNode)) {
            mRoot = newRoot;
            return mRoot;
        }
        if (value < rootNode.value) {
            if (Objects.isNull(rootNode.left)) {
                rootNode.left = newRoot;
            } else {
                insertIntoBST(rootNode.left, value);
            }
        } else {
            if (Objects.isNull(rootNode.right)) {
                rootNode.right = newRoot;
            } else {
                insertIntoBST(rootNode.right, value);
            }
        }
        return rootNode;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (Objects.isNull(root)) {
            return null;
        }
        if (key < root.value) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.value){
            root.right = deleteNode(root.right, key);
        } else {
            if (Objects.isNull(root.left) && Objects.isNull(root.right)) {
                return null;
            }
            if (Objects.nonNull(root.left) && Objects.isNull(root.right)) {
                return root.left;
            }
            if (Objects.isNull(root.left)) {
                return root.right;
            }

            var leftModeNode = findLeftModeNode(root.right);
            root.value = leftModeNode.value;
            root.right = deleteNode(root.right, leftModeNode.value);

        }
        return root;
    }
    //104
    public int maxDepth(TreeNode root) {
        if (Objects.isNull(root)) {
            return 0;
        }
        var highLeft = maxDepth(root.left);
        var highRight = maxDepth(root.right);

        return Math.max(highLeft, highRight) + 1;
    }

    public boolean isLeaf(TreeNode root) {
        return Objects.isNull(root.left) && Objects.isNull(root.right);
    }
    public boolean duyet(TreeNode curNode, int curSum, int targetSum) {
        if (Objects.isNull(curNode)) return false;
        curSum += curNode.value;
        if (isLeaf(curNode)) {
            return curSum == targetSum;
        }
        //Duyet sang hai cay con ben de kiem tra
        boolean resultLeft = duyet(curNode.left, curSum, targetSum);
        boolean resultRight = duyet(curNode.right, curSum, targetSum);
        return resultLeft || resultRight;
    }
    // tim trong root xem co nhanh nao cong voi nhau = targetSum hay khong
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return duyet(root, 0, targetSum);
    }

    public TreeNode findLeftModeNode(TreeNode root) {
        if (Objects.isNull(root)) return null;
        var leftNodeMode = root;
        while (Objects.nonNull(leftNodeMode.left)) {
            leftNodeMode = leftNodeMode.left;
        }
        return leftNodeMode;
    }

    public TreeNode searchBST(TreeNode root, int val) {
        if (Objects.isNull(root)) {
            return null;
        }
        if (val < root.value) {
            return searchBST(root.left, val);
        } else if (val > root.value) {
            return searchBST(root.right, val);
        } else {
            return root;
        }
    }

    public static void preOder(TreeNode currentNode) {
        if (Objects.isNull(currentNode)) {
            return;
        }
        System.out.println(currentNode.value + " ");
        preOder(currentNode.left);
        preOder(currentNode.right);
    }

    public static void inOrder(TreeNode currentNode) {
        if (Objects.isNull(currentNode)) {
            return;
        }
        inOrder(currentNode.left);
        System.out.println(currentNode.value + " ");
        inOrder(currentNode.right);
    }

    public static void postOrder(TreeNode currentNode) {
        if (Objects.isNull(currentNode)) {
            return;
        }
        postOrder(currentNode.left);
        postOrder(currentNode.right);
        System.out.println(currentNode.value + " ");
    }


    List<Integer> duyetOrder = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if (Objects.isNull(root)) {
            return duyetOrder;
        }
        duyetOrder.add(root.value);
        preOder(root.left);
        preOder(root.right);
        return duyetOrder;
    }



    public void print(TreeNode node) {
        if (Objects.isNull(node)) {
            return;
        }
        sum += node.value;
        System.out.println(node.value);
        var r1 = node.left;
        var r2 = node.right;
        print(r1);
        print(r2);
    }

}
