package com.datastructure;

class Node {
	int item;
	Node left;
	Node right;

	Node(int item) {
		this.item = item;
	}
}

public class BinaryTree {

	Node root;

	BinaryTree() {
		root = null;
	}

	private Node add(Node root, int item) {
		if (root != null) {
			if (root.item > item) {
				Node node = new Node(item);
				root.left = add(root.left, item);
			} else if (root.item < item) {
				Node node = new Node(item);
				root.right = add(root.right, item);
			} else {
				return root;
			}
			return root;
		} else {
			Node node = new Node(item);
			root = node;
			return root;
		}
	}

	public void insert(int item) {
		root = add(root, item);
	}

	public void print(Node root) {
		if (root != null) {
			print(root.left);
			System.out.print(root.item+" ");
			print(root.right);
		}
	}
	
	private void traversalPreOrder(Node root) {
		if(root!=null) {
			System.out.print(root.item+" ");
			traversalPreOrder(root.left);
			traversalPreOrder(root.right);
		}
	}
	
	private void traversalPostOrder(Node root) {
		if(root!=null) {
			traversalPostOrder(root.left);
			traversalPostOrder(root.right);
			System.out.print(root.item+" ");
		}
	}

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.insert(45);
		tree.insert(32);
		tree.insert(67);
		tree.insert(33);
		tree.insert(78);
		tree.insert(10);
		tree.print(tree.root);
		System.out.println();
		tree.traversalPreOrder(tree.root);
		System.out.println();
		tree.traversalPostOrder(tree.root);
		
	}

}
