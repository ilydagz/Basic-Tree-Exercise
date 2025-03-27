package pa2;

import java.util.LinkedList;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {

		Node root = buildTree("43-12+*");
		printTree(root);
	}

	public static Node buildTree(String postfixFormula) {
		Stack<Node> stack = new Stack<Node>();

		for (int i = 0; i < postfixFormula.length(); i++) {
			char ch = postfixFormula.charAt(i);

			Node node = new Node(ch);

			if (isOperator(ch)) {

				node.right = stack.pop();
				node.left = stack.pop();
			}

			stack.push(node);
		}

		return stack.pop();
	}

	public static Node printTree(Node root) {
		if (root == null)
			return null;

		LinkedList<Node> queue = new LinkedList<Node>();
		queue.addFirst(root);

		while (!queue.isEmpty()) {
			int size = queue.size();

			for (int i = 0; i < size; i++) {
				Node current = queue.removeLast();
				System.out.print(current.c + " ");

				if (current.left != null)
					queue.addFirst(current.left);
				if (current.right != null)
					queue.addFirst(current.right);
			}

			System.out.println();
		}
		return root;
	}

	private static boolean isOperator(char c) {
		return c == '+' || c == '-' || c == '*' || c == '/';
	}
}
