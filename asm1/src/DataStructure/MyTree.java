package DataStructure;

// Implement Tree in java
// Node(value, leftNode, rightNode)

class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    TreeNode(int value) {
        this.value = value;
        left = null;
        right = null;
    }
}

public class MyTree {
    // Nút gốc root
    TreeNode root;

    public MyTree() {
        this.root = null;
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);

        // Xây dựng cây theo thứ tự pre-order mong muốn: 1 2 4 3 5 7 8 6
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n3.left = n5;
        n3.right = n6;
        n5.left = n7;
        n5.right = n8;
        root = n1;
    }

    public void print() {
        printPreOrder(root);
        System.out.println(); // Kết thúc dòng sau khi in cây
    }

    // Phương thức đệ quy để in theo thứ tự pre-order
    private void printPreOrder(TreeNode node) {
        if (node != null) {
            System.out.print(node.value + " "); // Xử lý nút gốc
            printPreOrder(node.left);           // Duyệt cây con trái
            printPreOrder(node.right);          // Duyệt cây con phải
        }
    }
   
    
}
