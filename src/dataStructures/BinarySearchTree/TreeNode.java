package dataStructures.BinarySearchTree;

public class TreeNode {
    public int data;
    public TreeNode parent;       //parent node
    public TreeNode left;         //left child
    public TreeNode right;        //right child

    public TreeNode()
    {
        data = 0;
        parent = null;
        left = null;
        right = null;
    }

    public String toString()
    {
        return "{"+data+"}";
    }
}