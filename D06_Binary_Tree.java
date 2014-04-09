import java.util.LinkedList;
import java.util.Stack;

/* BINARY TREE
 * only one or two nodes
 *
 * root is the middle number                    [middle == root]
 * left of root are smaler number than root     [left < root]
 * right of root are largger number than root   [right > root]
 */

/* search,insert,delete item quickly in a tree
 * search is faster than linked list
 */

/* 
 * Traveral = loop though all tree nodes
 * search = use traveral to search a node
 * */

/* TREE
 *      5
 *    /   \
 *   2     7
 *  / \     \
 * 1   3     8
 *            \
 *             9
 * 
 */

/* search
 * 1 - Uniformed Search
 *     - Breath first search
 *     - Uniform cost search
 *     - Depth first search
 *           - InOrder Traversal   [left][root][right]
 *           - PreOrder Traversal  [root][left][right]
 *           - PostOrder Traversal [left][right][root]
 *     - Depth limited search
 *     - iterative deepening depth first search
 *     - Bidirectional search
 * 2 - informed(heuristic) search
 *     - greedy best first search
 *     - A* search
 *     memory bounded heuristic search
 *     heuristics functions
 * */

public class D06_Binary_Tree {
	/*** CREATE NODE ***/
	private class node {
		private String name;
		private int age;
		private node left_child;
		private node right_child;

		/*** Constructor ***/
		public node() {
			name = "";
			age = 0;
			left_child = null;
			right_child = null;
		}

		public node(String n, int a) {
			name = n;
			age = a;
			left_child = null;
			right_child = null;
		}
		/*** End of constructor ***/
	}

	/*** End of Node class ***/

	/*** Linked List Fields ***/
	public node root_node;
	public node current_node = root_node;
	public node parent_node = root_node;
	public node new_node;

	/*** Binary Tree Constructor ***/
	public D06_Binary_Tree() {
		// TODO Auto-generated constructor stub
	}

	/*********************/
	/*** Insert Method ***/
	/*********************/
	public void insert(String n, int a) {
		current_node = root_node;
		parent_node = root_node;

		if (root_node == null) // if root is empty
		{
			root_node = new node(n, a);
			root_node.left_child = null;
			root_node.right_child = null;
		} else {
			while (true) {
				parent_node = current_node; // follow current_node in loop
				if (current_node.age > a) // LEFT HAND SIDE
				{
					current_node = current_node.left_child; // move current node
					if (current_node == null) // if empty
					{
						new_node = new node(n, a); // create new node
						parent_node.left_child = new_node; // parent is same as
															// current cude
						break;
					}
				} else /*** RIGHT SIDE OF TREE ***/
				{
					current_node = current_node.right_child;
					if (current_node == null) {
						new_node = new node(n, a);
						parent_node.right_child = new_node;
						break;
					}
				}
			}
		}
	}// End of Insert Method

	/*******************/
	/*** delete node ***/
	/*******************/
	// DOES NOT WORK RIGHT NOW - FIX IT LATER
	public boolean delete(int key) {
		node current_node = root_node;
		node parent_node = root_node;
		boolean isItALeftChild = true;

		// loop though tree
		while (current_node.age != key) {
			parent_node = current_node;

			// move current node left or right
			if (key < current_node.age) {
				isItALeftChild = true;
				current_node = current_node.left_child;
			} else {
				isItALeftChild = false;
				current_node = current_node.right_child;
			}

			if (current_node == null) {
				return false;
			}

		}

		// delete root node
		if (current_node.left_child == null && current_node.right_child == null) {
			if (current_node == root_node) {
				root_node = null;
			} else if (isItALeftChild) {
				parent_node.left_child = null;
			} else {
				parent_node.right_child = null;
			}
		} else if (current_node.right_child == null) {
			if (current_node == root_node) {
				root_node = current_node.left_child;
			} else if (isItALeftChild) {
				parent_node.left_child = current_node.left_child;
			} else {
				parent_node.right_child = current_node.left_child;
			}
		} else if (current_node.left_child == null) {
			if (current_node == root_node) {
				root_node = current_node.right_child;
			} else if (isItALeftChild) {
				parent_node.left_child = current_node.right_child;
			} else {
				parent_node.right_child = current_node.left_child;
			}
		} else {
			node replacement = getReplacementNode(current_node);
			if (current_node == root_node) {
				root_node = replacement;
			} else if (isItALeftChild) {
				parent_node.left_child = replacement;
			} else {
				parent_node.right_child = replacement;
			}
			replacement.left_child = current_node.left_child;
		}
		return true;
	}

	private node getReplacementNode(node replacedNode) {
		node replacementParent = replacedNode;
		node replacement = replacedNode;

		node current_node = replacedNode.right_child;

		while (current_node != null) {
			replacementParent = replacement;
			replacement = current_node;
			current_node = current_node.left_child;
		}

		if (replacement != replacedNode.right_child) {
			replacementParent.left_child = replacement.right_child;
			replacement.right_child = replacedNode.right_child;
		}
		return replacement;
	}

	// /////////////////////////////////////////////////////////////////////////////////////
	// SEARCH--//////////////////////////////////////////////////////////////////////////////
	// //////////////////////////////////////////////////////////////////////////////////////
	/***************************/
	/*** Breath-first search ***/
	/***************************/
	// level by level and righ to left
	public void breathFirstSearch(node root_node) {
		// BFS uses Queue(FIFO) data structure
		LinkedList<node> queue = new LinkedList<node>();
		queue.add(root_node);

		if (root_node == null)
			System.out.println("binary tree is empty");

		while (!queue.isEmpty()) {
			node current = (node) queue.remove();
			// do search here ...
			System.out.print("[" + current.name + " " + current.age + "] ");
			if (current.left_child != null)
				queue.add(current.left_child);
			if (current.right_child != null)
				queue.add(current.right_child);
		}
	}// End of breath first search

	/***************************/
	/*** Uniform cost search ***/
	/***************************/
	public void uniformCostSearch(node root_node) {
		// CODE WHEN YOU ARE FREE
	}// End of uniform cost search

	/**************************/
	/*** depth first search ***/
	/**************************/

	/*********************************/
	/*** IN ORDER TRAVERSAL METHOD ***/
	/*********************************/
	// in order traversal - print all value lowest to heightest
	public void inOrderTraversal(node root_node) {
		// use root_node or wont work
		if (root_node == null) {
			// System.out.println("Binary Tree is empty!");
		} else {
			inOrderTraversal(root_node.left_child);
			System.out.print("[" + root_node.name + " " + root_node.age + "] ");
			inOrderTraversal(root_node.right_child);
		}
	}// END OF IN ORDER TRAVERSAL METHOD

	/*********************************/
	/*** PREORDER TRAVERSAL METHOD ***/
	/*********************************/
	/*** print tree starting from root ***/
	public void PreOrderTraversal(node root_node) {
		// use root_node or wont work

		if (root_node == null) {
			// System.out.println("Binary Tree is empty!");
		} else {
			System.out.print("[" + root_node.name + " " + root_node.age + "] ");
			PreOrderTraversal(root_node.left_child);
			PreOrderTraversal(root_node.right_child);
		}
	}// END OF PREORDER TRAVERSAL METHOD

	/*********************************/
	/*** PREORDER TRAVERSAL METHOD ***/
	/*********************************/
	public void PostOrderTraversal(node root_node) {
		// use root_node or wont work

		if (root_node == null) {
			// System.out.println("Binary Tree is empty!");
		} else {
			PostOrderTraversal(root_node.left_child);
			PostOrderTraversal(root_node.right_child);
			System.out.print("[" + root_node.name + " " + root_node.age + "] ");
		}
	}// END OF PREORDER TRAVERSAL METHOD

	/**************************/
	/*** depth first search ***/
	/**************************/
	// Depth first search using stacks
	public void depthFirstSearch(node root_node) {
		// GFS uses stack(FILO) data structure
		Stack<node> stack = new Stack<node>();
		stack.push(root_node);

		if (root_node == null)
			System.out.println("Binary tree is empty");

		while (!stack.isEmpty()) {
			node current = (node) stack.peek();
			System.out.print("[" + current.name + " " + current.age + "] ");
			// do search here ...
			if (current.left_child != null)
				stack.push(current.left_child);
			if (current.right_child != null)
				stack.push(current.right_child);

			depthFirstSearch(root_node);
		}
	}// End of depth first search

	// //////////////////////////////////////////////////////////////////////////////////////
	// Get-Information-//////////////////////////////////////////////////////////////////////
	// //////////////////////////////////////////////////////////////////////////////////////
	/*****************************/
	/*** Minimum Value in tree ***/
	/*****************************/
	private int findMin(node root_node) {
		if (root_node == null)
			return -1000; // empty list
		else if (root_node.left_child == null)
			return root_node.age;
		return findMin(root_node.left_child);
	}

	/*****************************/
	/*** Maximum Value in tree ***/
	/*****************************/
	private int findMax(node root_node) {
		if (root_node == null)
			return -1000; // empty list
		else if (root_node.right_child == null)
			return root_node.age;
		return findMax(root_node.right_child);
	}

	// may has error - test this method later
	// The height of the binary search tree
	public int max_height(node root_node) {
		int left = 0;
		int right = 0;

		if (root_node == null) {
			return -1;
		} else {
			left = max_height(root_node.left_child);
			right = max_height(root_node.right_child);
		}

		if (left > right) {
			return left + 1;
		} else {
			return right + 1;
		}
	}

	/*****************************/
	/*** find max depth of tree ***/
	/*****************************/
	public int getMaxDepth(node root_node) {
		int valueLeft = 0;
		int valueRight = 0;

		if (root_node.left_child != null)
			valueLeft = getMaxDepth(root_node.left_child) + 1;
		if (root_node.right_child != null)
			valueRight = getMaxDepth(root_node.right_child) + 1;

		return valueLeft > valueRight ? valueLeft : valueRight;
	}

	/*********************************/
	/** check if root node is empty **/
	/*********************************/
	public boolean isEmpty() {
		if (root_node == null) {
			return true;
		}
		return false;
	}

	/*******************/
	/*** Main Method ***/
	/*******************/
	public static void main(String[] args) {
		D06_Binary_Tree m = new D06_Binary_Tree();

		// insert -----------------------------------------
		m.insert("a", 5);
		m.insert("b", 2);
		m.insert("c", 1);
		m.insert("d", 3);
		m.insert("e", 7);
		m.insert("f", 8);
		m.insert("g", 9);

		// search ---------------------------------------------
		System.out.print("breath First Search: ");
		m.breathFirstSearch(m.root_node);

		System.out.print("\nUniform cost search: ");
		m.uniformCostSearch(m.root_node);

		System.out.println("\nDepth first search: ");
		System.out.print("\tIn Order Traversal:");
		m.inOrderTraversal(m.root_node);
		System.out.print("\n\tPre Order Traversal:");
		m.PreOrderTraversal(m.root_node);
		System.out.print("\n\tPost Order Traversal:");
		m.PostOrderTraversal(m.root_node);
		System.out.println("\n");
		// m.depthFirstSearch(m.root_node);
		System.out.println("\n");

		// information about tree -----------------------------
		// Minimum Value in tree
		System.out.println("INFORMATION:");
		int minValue = m.findMin(m.root_node);
		System.out.println("Min Value: " + minValue);

		// Maximum Value in tree
		int maxValue = m.findMax(m.root_node);
		System.out.println("Max Value: " + maxValue);

		// int i = m.max_height(m.root_node);
		// System.out.println(i);

		if (m.isEmpty()) {
			System.out.println("tree is empty");
		} else {
			System.out.println("tree is not empty");
		}

		int treeDepth = m.getMaxDepth(m.root_node);
		System.out.println("tree depth: " + treeDepth);
	}
}