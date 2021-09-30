package hard;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree {

    public String serialize(TreeNode root) {

        StringBuilder sb = new StringBuilder();

        serializeInternal(sb, root);
        return sb.toString();
    }

    private void serializeInternal(StringBuilder sb, TreeNode node) {

        if (node == null) {
            sb.append("X").append(",");
            return;
        }

        // preorder traverse
        sb.append(node.val).append(",");
        serializeInternal(sb, node.left);
        serializeInternal(sb, node.right);
    }

    public TreeNode deserialize(String data) {

        String[] split = data.split(",");

        Queue<String> nodes = new LinkedList<>(Arrays.asList(split));

        return deserializeInternal(nodes);
    }

    private TreeNode deserializeInternal(Queue<String> nodes) {

        String node = nodes.remove();

        if (node.equals("X")) {
            return null;
        }

        // preorder traverse
        TreeNode treeNode = new TreeNode(Integer.parseInt(node));
        treeNode.left = deserializeInternal(nodes);
        treeNode.right = deserializeInternal(nodes);

        return treeNode;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {

        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);

        t1.left = t2;
        t1.right = t3;
        t3.left = t4;
        t3.right = t5;

        SerializeAndDeserializeBinaryTree ser = new SerializeAndDeserializeBinaryTree();
        String s = ser.serialize(t1);
        System.out.println(s);

        SerializeAndDeserializeBinaryTree deser = new SerializeAndDeserializeBinaryTree();
        TreeNode treeNode = deser.deserialize(s);
    }
}
