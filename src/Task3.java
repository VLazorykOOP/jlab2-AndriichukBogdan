public class Task3 {
    static class BinaryTree {
        static class Node {
            int value;
            Node left, right;

            public Node(int value) {
                this.value = value;
                left = right = null;
            }
        }

        Node root;

        // Додавання елемента
        public void add(int value) {
            root = addRecursive(root, value);
        }

        private Node addRecursive(Node current, int value) {
            if (current == null) {
                return new Node(value);
            }

            if (value < current.value) {
                current.left = addRecursive(current.left, value);
            } else if (value > current.value) {
                current.right = addRecursive(current.right, value);
            }

            return current;
        }

        // Пошук елемента
        public boolean contains(int value) {
            return containsRecursive(root, value);
        }

        private boolean containsRecursive(Node current, int value) {
            if (current == null) {
                return false;
            }
            if (value == current.value) {
                return true;
            }
            return value < current.value
                    ? containsRecursive(current.left, value)
                    : containsRecursive(current.right, value);
        }

        // Видалення елемента
        public void remove(int value) {
            root = removeRecursive(root, value);
        }

        private Node removeRecursive(Node current, int value) {
            if (current == null) {
                return null;
            }

            if (value == current.value) {
                // Вузол для видалення знайдено
                if (current.left == null && current.right == null) {
                    return null; // Листок
                }
                if (current.right == null) {
                    return current.left; // Один дочірній елемент
                }
                if (current.left == null) {
                    return current.right;
                }

                int smallestValue = findSmallestValue(current.right);
                current.value = smallestValue;
                current.right = removeRecursive(current.right, smallestValue);
                return current;

            }
            if (value < current.value) {
                current.left = removeRecursive(current.left, value);
                return current;
            }

            current.right = removeRecursive(current.right, value);
            return current;
        }

        private int findSmallestValue(Node root) {
            return root.left == null ? root.value : findSmallestValue(root.left);
        }

        // Друк дерева (In-Order Traversal)
        public void traverseInOrder(Node node) {
            if (node != null) {
                traverseInOrder(node.left);
                System.out.print(node.value + " ");
                traverseInOrder(node.right);
            }
        }
    }
        public static void main(String[] args) {
            BinaryTree tree = new BinaryTree();

            tree.add(5);
            tree.add(3);
            tree.add(7);
            tree.add(1);
            tree.add(4);

            System.out.println("Пошук 4: " + tree.contains(4));
            System.out.println("Пошук 10: " + tree.contains(10));

            System.out.print("Дерево до видалення: ");
            tree.traverseInOrder(tree.root);
            System.out.println();

            tree.remove(3);

            System.out.print("Дерево після видалення 3: ");
            tree.traverseInOrder(tree.root);
        }


}
