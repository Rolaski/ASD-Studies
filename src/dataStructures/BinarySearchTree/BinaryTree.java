package dataStructures.BinarySearchTree;

import java.util.ArrayList;

public class BinaryTree {
    private TreeNode root;    //first node - root

    public BinaryTree()
    {
        root = null;
    }

    public TreeNode getRoot()
    {
        return root;
    }

    public void insert(int elem)
    {
        TreeNode newNode = new TreeNode();    //new node
        newNode.data = elem;        //save data

        if (root == null)
            root = newNode; //if tree is empty set it as root
        else
        {
            TreeNode current = root;       //search from root
            while (true)
            {
                TreeNode parent = current;
                if (elem < current.data)  //going to left "child"
                {
                    current = current.left;
                    if (current == null)  //if no left child
                    {
                        parent.left = newNode; //save node here - left side
                        newNode.parent = parent;
                        return;
                    }
                }
                else   //going to right child
                {
                    current = current.right;
                    if (current == null)  //if no right child
                    {
                        parent.right = newNode; //save node here - right side
                        newNode.parent = parent;
                        return;
                    }
                }
            }
        }
    }

    public boolean find(int elem)
    {
        if (root==null) return false;       //empty tree

        TreeNode current = root;            //search from root
        while (current.data != elem)        //until not found
        {
            if (elem < current.data)        // going left
                current = current.left;
            else                            // going right
                current = current.right;
            if (current == null)            // if no child
                return false;
        }
        return true; //found element
    }

    private TreeNode getSuccessor(TreeNode node)
    {
        TreeNode current = node.right;
        while (current.left != null) //go left side
        {
            current = current.left;
        }
        return current;
    }

    private void deleteWithoutChilds(TreeNode current)
    {
        if (current == root)             //if it is a root
        {
            root = null;                 //null our tree
        }
        else
        {
            if (current.parent.left == current) //if elem was left child
            {
                current.parent.left = null;    //unlink it
            }
            else //was right child
            {
                current.parent.right = null;  // unlink it
            }
            current.parent = null;
        }
    }

    private void deleteWithOneLeftChild(TreeNode current)
    {
        if (current == root)
        {
            root = current.left;
        }
        else
        {
            if (current.parent.left == current) //if elem was left child
            {
                current.parent.left = current.left;
            }
            else //was right child
            {
                current.parent.right = current.left;
            }
            current.left.parent = current.parent;
        }
    }

    private void deleteWithOneRightChild(TreeNode current)
    {
        if (current == root)
        {
            root = current.right;
        }
        else
        {
            if (current.parent.left == current) //if elem was left child
            {
                current.parent.left = current.right;
            }
            else //was right child
            {
                current.parent.right = current.right;
            }
            current.right.parent = current.parent;
        }
    }

    private void deleteWithTwoChilds(TreeNode current)
    {
        TreeNode successor = getSuccessor(current); //find next elem

        if (successor.left==null && successor.right==null) //if successor has no children
            deleteWithoutChilds(successor);
        else //successor has one (right) children
            deleteWithOneRightChild(successor);

        TreeNode parentCurr = current.parent; //if current elem = root  => its parent is null

        //switch deleted node on its successor

        if(current!=root)
        {
            if (parentCurr.left==current)
                parentCurr.left = successor;
            else //(parentCurr.right==current)
                parentCurr.right = successor;
        }

        successor.left = current.left;
        successor.right = current.right;

        successor.parent = parentCurr;
        if(successor.left != null)
            successor.left.parent = successor;
        if(successor.right != null)
            successor.right.parent = successor;

        if(current==root) //if elem to delete was a root - switch roots' successor to root
            root = successor;
    }

    public boolean delete(int elem)
    {
        if (root == null) return false;

        TreeNode current = root;

        while (current.data != elem)        //search for node
        {
            if (elem < current.data)         //go left
                current = current.left;
            else                            //go right
                current = current.right;

            if (current == null)             //end of search
                return false;                // ... no elems found
        }

        // but if there is found elem
        if (current.left == null && current.right == null) //delete without children
        {
            deleteWithoutChilds(current);
        }
        else
        if (current.right == null) //delete without right children
        {
            deleteWithOneLeftChild(current);
        }
        else
        if (current.left == null) // delete without left children
        {
            deleteWithOneRightChild(current);
        }
        else  // delete with two children
        {
            deleteWithTwoChilds(current);
        }

        return true;
    }

    public void view(TreeNode node,int level) //visualisation of tree
    {
        if (node==null) return;
        for (int i=0; i<level; i++) System.out.print("- ");
        System.out.println(node.data);
        view(node.left,level+1);
        view(node.right,level+1);
    }

    //copy tree to array
    private void copyBinaryTreeToArrayList(TreeNode node, ArrayList<TreeNode> nodeList)
    {
        if (node.left!=null) copyBinaryTreeToArrayList(node.left,nodeList);
        nodeList.add(node);
        if (node.right!=null) copyBinaryTreeToArrayList(node.right,nodeList);
    }

    public BinaryTreeIterator iterator() //set iterator
    {
        ArrayList<TreeNode> nodeList = new ArrayList<TreeNode>();
        if (root!=null)
        {
            copyBinaryTreeToArrayList(root,nodeList);
        }
        return new BinaryTreeIterator(nodeList);
    }


    public void print()
    {
        System.out.print("BST:");
        BinaryTreeIterator iterator = this.iterator();

        while (iterator.hasNext())      //until we habe elements
        {
            TreeNode node = iterator.next();
            System.out.print(node.toString()); //print them
            System.out.print(" ");
        }
        System.out.println();
    }


    public static void main(String[] args) //test
    {
        BinaryTree tree = new BinaryTree();

        //Wstawianie elementow
        tree.insert(50);
        tree.insert(25);
        tree.insert(75);
        tree.insert(12);
        tree.insert(37);
        tree.insert(43);
        tree.insert(30);
        tree.insert(33);
        tree.insert(87);
        tree.insert(63);
        tree.insert(97);

        tree.view(tree.getRoot(),0);

        System.out.println("\n\t<< del(50) >>");
        tree.delete(50);
        tree.view(tree.getRoot(),0);

        tree.print();

        boolean result1 = tree.find(33);
        System.out.println("Wynik wyszukania 33:"+result1);

        boolean result2 = tree.find(40);
        System.out.println("Wynik wyszukania 40:"+result2);

        System.out.println("\n\t<< del(37) >>");
        tree.delete(37);
        tree.view(tree.getRoot(),0);
        System.out.println("\n");

        System.out.println("\n\t<< del(43) >>");
        tree.delete(43);
        tree.view(tree.getRoot(),0);
        System.out.println("\n");

        System.out.println("\n\t<< del(25) >>");
        tree.delete(25);
        tree.view(tree.getRoot(),0);
        System.out.println("\n");

        tree.print();
    }
}