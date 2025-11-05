public class BinarySearchTreeDemo {

	static class TreeNode {
		int value;
		TreeNode left;
		TreeNode right;
		TreeNode parent;

		TreeNode(int value) {
			this.value = value;
		}
	}

	static class BinarySearchTree {

		TreeNode root;
		public TreeNode findValue(TreeNode current, int target) {
			if (current == null) {
				return null;
			}

			if (current.value == target) {
				return current;
			}

			if (target < current.value) {
				return findValue(current.left, target);
			} else {
				return findValue(current.right, target);
			}
		}

		public TreeNode find(int target) {
			return findValue(root, target);
		}

		public void insertNode(TreeNode current, int newValue) {
			if (newValue == current.value) {
				System.out.println("Valor duplicado");
				return;
			}

			if (newValue < current.value) {
				if (current.left != null) {
					insertNode(current.left, newValue);
				} else {
					current.left = new TreeNode(newValue);
					current.left.parent = current;
				}
			} else {
				if (current.right != null) {
					insertNode(current.right, newValue);
				} else {
					current.right = new TreeNode(newValue);
					current.right.parent = current;
				}
			}
		}

		public void insert(int newValue) {
			if (root == null) {
				root = new TreeNode(newValue);
			} else {
				insertNode(root, newValue);
			}
		}

		
		private void inorderRec(TreeNode node) {
			if (node != null) {
				inorderRec(node.left);
				System.out.print(node.value + " ");
				inorderRec(node.right);
			}
		}

		public void inorder() {
			System.out.print("Recorrido In-Order: ");
			inorderRec(root);
			System.out.println();
		}

		private void preorderRec(TreeNode node) {
			if (node != null) {
				System.out.print(node.value + " ");
				preorderRec(node.left);
				preorderRec(node.right);
			}
		}

		public void preorder() {
			System.out.print("Recorrido Pre-Order: ");
			preorderRec(root);
			System.out.println();
		}

		private void postorderRec(TreeNode node) {
			if (node != null) {
				postorderRec(node.left);
				postorderRec(node.right);
				System.out.print(node.value + " ");
			}
		}

		public void postorder() {
			System.out.print("Recorrido Post-Order: ");
			postorderRec(root);
			System.out.println();
		}
		private TreeNode findMin(TreeNode node) {
			while (node.left != null) {
				node = node.left;
			}
			return node;
		}

		private TreeNode deleteRec(TreeNode root, int value) {
			if (root == null) return root;

			if (value < root.value) {
				root.left = deleteRec(root.left, value);
			} else if (value > root.value) {
				root.right = deleteRec(root.right, value);
			} else {
				if (root.left == null) {
					return root.right;
				} else if (root.right == null) {
					return root.left;
				}
				TreeNode temp = findMin(root.right);
				root.value = temp.value;
				root.right = deleteRec(root.right, temp.value);
			}

			return root;
		}

		public void delete(int value) {
			root = deleteRec(root, value);
			System.out.println("Nodo " + value + " eliminado (si existía).");
		}
	}

	public static void main(String[] args) {

		BinarySearchTree tree = new BinarySearchTree();

		System.out.println("Creando árbol binario de búsqueda");

		int[] values = {8, 3, 10, 1, 6, 14, 4, 7, 13};

		for (int v : values) {
			tree.insert(v);
		}

		tree.inorder();
		tree.preorder();
		tree.postorder();

		System.out.println("\nEliminando el nodo 10:");
		tree.delete(10);

		tree.inorder();
	}
}


