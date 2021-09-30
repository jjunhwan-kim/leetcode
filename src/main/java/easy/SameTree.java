package easy;

public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {

        String s1 = serialize(p);
        String s2 = serialize(q);

        return s1.equals(s2);
    }

    private String serialize(TreeNode root) {

        StringBuilder sb = new StringBuilder();
        serializeInternal(sb, root);

        return sb.toString();
    }

    private void serializeInternal(StringBuilder sb, TreeNode node) {

        if (node == null) {
            sb.append("X").append(",");
            return;
        }

        sb.append(node.val).append(",");
        serializeInternal(sb, node.left);
        serializeInternal(sb, node.right);
    }

    /*
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return isSame(p, q);
    }

    private boolean isSame(TreeNode p, TreeNode q) {

        boolean isLeftSubTreeSame = false;
        boolean isRightSubTreeSame = false;
        boolean isCurrentNodeSame = false;

        if (p == null && q == null) {
            isCurrentNodeSame = isLeftSubTreeSame = isRightSubTreeSame = true;
        }
        if (p != null && q != null) {
            isCurrentNodeSame = (p.val == q.val);

            if (p.left == null && q.left == null) {
                isLeftSubTreeSame = true;
            }
            if (p.left != null && q.left != null) {
                isLeftSubTreeSame = isSame(p.left, q.left);
            }

            if (p.right == null && q.right == null) {
                isRightSubTreeSame = true;
            }
            if (p.right != null && q.right != null) {
                isRightSubTreeSame = isSame(p.right, q.right);
            }
        }

        return (isLeftSubTreeSame && isRightSubTreeSame && isCurrentNodeSame);
    }
    */

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {

        }
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
