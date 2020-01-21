package com.datastructure;

import java.awt.HeadlessException;

public class TreeLevelTraversal {

	private Node root;
	private int max;
	int flag = 0;
	private int min;

	private Node add(Node root, int item) {
		if (root != null) {
			if (root.item > item) {
				root.left = add(root.left, item);
			} else if (root.item < item) {
				root.right = add(root.right, item);
			} else {
				return root;
			}
		} else {
			root = new Node(item);
		}
		return root;
	}

	private void insert(int item) {
		root = add(root, item);
	}

	private void print(Node root) {
		if (root != null) {
			print(root.left);
			System.out.print(root.item + " ");
			print(root.right);
		}
	}

	private void levelOrderTraversal(Node root) {
		int height = height(root);
		for (int i = 0; i <= height; i++) {
			printlevel(root, i);
		}
	}

	private void printlevel(Node root, int level) {
		if (root == null) {
			return;
		} else {
			if (level == 1) {
				System.out.print(root.item + " ");
			} else if (level > 1) {
				printlevel(root.left, level - 1);
				printlevel(root.right, level - 1);
			}
		}
	}

	private int height(Node root) {
		if (root == null) {
			return 0;
		} else {
			int lheight = height(root.left);
			int rheight = height(root.right);

			if (lheight > rheight) {
				return lheight + 1;
			} else {
				return rheight + 1;
			}
		}
	}

	private void leafNodes(Node root) {
		if (root != null) {
			if (root.left == null && root.right == null) {
				System.out.print(root.item + " ");
			} else {
				if (root.left != null)
					leafNodes(root.left);
				if (root.right != null)
					leafNodes(root.right);
			}
		}
	}

	private int maxElement(Node root) {
		if (root != null) {
			max = root.item;
			if (root.left != null && max < root.left.item)
				maxElement(root.left);
			if (root.right != null && max < root.right.item)
				maxElement(root.right);
		}
		return max;
	}

	private void leftView(Node root, int level) {

		if (root == null) {
			return;
		} else if (level == 1 && flag == 0) {
			System.out.print(root.item + " ");
			flag = 1;
		} else if (level > 1 && flag != 1) {
			leftView(root.left, level - 1);
			leftView(root.right, level - 1);
		}
	}

	private void view(Node root) {
		int height = height(root);
		for (int i = 0; i <= height; i++) {
			flag = 0;
			leftView(root, i);
		}
	}

	private int minElement(Node root) {
		if (root != null) {
			min = root.item;
			if (root.left != null && min > root.left.item)
				minElement(root.left);
			if (root.right != null && min > root.right.item)
				minElement(root.right);
		} else {
			return 0;
		}

		return min;
	}

	public static void main(String[] args) {
		TreeLevelTraversal tree = new TreeLevelTraversal();
		
		  tree.insert(5); tree.insert(2); tree.insert(3); tree.insert(1);
		  tree.insert(8); tree.insert(6); tree.insert(10); tree.insert(11);
		  tree.insert(4);
		 
		System.out.print("Inorder Traversal ");
		tree.print(tree.root);
		System.out.println();
		System.out.println("height "+tree.height(tree.root));
		System.out.print("Level Order Traversal ");
		tree.levelOrderTraversal(tree.root);
		System.out.println();
		System.out.print("Leaf Nodes ");
		tree.leafNodes(tree.root);
		int maxElement = tree.maxElement(tree.root);
		System.out.println();
		System.out.println("maxElement "+maxElement);
		System.out.print("Left View ");
		tree.view(tree.root);
		System.out.println();
		System.out.println("minElement "+tree.minElement(tree.root));

	}

}
