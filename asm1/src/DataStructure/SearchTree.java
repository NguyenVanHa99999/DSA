package DataStructure;

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

public class SearchTree {
    TreeNode root;

    public SearchTree() {
        // Xây dựng cây theo hình
        root = new TreeNode(18);
        root.left = new TreeNode(12);
        root.right = new TreeNode(35);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(15);
        root.left.left.left = new TreeNode(-2);
        root.left.left.right = new TreeNode(7);
        root.left.right.left = new TreeNode(13);
        root.left.right.right = new TreeNode(16);

        root.right.left = new TreeNode(22);
        root.right.right = new TreeNode(58);
        root.right.left.left = new TreeNode(19);
        root.right.left.right = new TreeNode(31);
        root.right.right.left = new TreeNode(40);
        root.right.right.right = new TreeNode(87);
    }

    // Phương thức đệ quy kiểm tra giá trị trong cây
    public boolean contains(int value) {
        return contains(root, value);
    }

    private boolean contains(TreeNode node, int value) {
        if (node == null) {
            return false;
        } else if (node.value == value) {
            return true;
        } else if (node.value > value) {
            return contains(node.left, value); // Tìm trong cây con trái
        } else {
            return contains(node.right, value); // Tìm trong cây con phải
        }
    }
    
}
