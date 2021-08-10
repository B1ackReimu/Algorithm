package redblacktree;

public class RBTree<K extends Comparable<K>, V> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;
    private RBNode<K, V> root;

    private RBNode<K, V> parentOf(RBNode<K, V> node) {
        if (node != null) {
            return node.parent;
        }
        return null;
    }

    private boolean isRed(RBNode<K, V> node) {
        if (node != null) {
            return node.color == RED;
        }
        return false;
    }

    private boolean isBlack(RBNode<K, V> node) {
        if (node != null) {
            return node.color == BLACK;
        }
        return false;
    }

    private void setRed(RBNode<K, V> node) {
        if (node != null) {
            node.setColor(RED);
        }
    }

    private void setBlack(RBNode<K, V> node) {
        if (node != null) {
            node.setColor(BLACK);
        }
    }

    public void inOrderPrint() {
        inOrderPrint(this.root);
    }

    private void inOrderPrint(RBNode<K, V> node) {
        if (node != null) {
            inOrderPrint(node.left);
            System.out.println("key:" + node.getKey() + ",value:" + node.getValue());
            inOrderPrint(node.right);
        }
    }

    public void insert(K key, V value) {
        RBNode<K, V> node = new RBNode<>();
        node.setKey(key);
        node.setValue(value);
        // 新节点一定是红色！
        node.setColor(RED);
        insert(node);
    }

    private void insert(RBNode<K, V> node) {
        //查找当前node的父节点
        RBNode<K, V> parent = null;
        RBNode<K, V> x = this.root;
        while (x != null) {
            parent = x;
            int i = node.getKey().compareTo(x.getKey());
            if (i == 0) {
                x.setValue(node.getValue());
                return;
            } else if (i > 0) {
                x = x.getRight();
            } else {
                x = x.getLeft();
            }
        }

        if (parent == null) {
            this.root = node;
            return;
        }

        node.setParent(parent);
        int i = node.getKey().compareTo(parent.getKey());
        if (i > 0) {
            parent.right = node;
        } else {
            parent.left = node;
        }

        insertFixUp(node);
    }

    /**
     * 情景1：红黑树为空树，则将节点染色为黑色
     * 情景2：插入节点的key已存在，不需要处理
     * 情景3：插入节点的父节点为黑色，不需要处理
     * 情景4：插入节点的父节点为红色
     * 情景4.1：叔叔节点存在且为红色，将父和叔染为黑色，将爷染为红色，以爷作为当前节点进行后续操作
     * 情景4.2：叔叔节点不存在或为黑色，
     * LL 将父节点染黑，将爷节点染红，以爷节点右旋
     * LR 以父节点左旋，得到LL，以父作为当前节点进行后续操作
     * RR 将父节点染黑，将爷节点染红，以爷节点左旋
     * RL 以父节点右旋，得到RR，以父作为当前节点进行后续操作
     */
    private void insertFixUp(RBNode<K, V> node) {
        this.root.setColor(BLACK);
        RBNode<K, V> parent = parentOf(node);
        RBNode<K, V> gParent = parentOf(parent);
        if (isRed(parent)) {
            RBNode<K, V> uncle;
            if (parent == gParent.getLeft()) {
                uncle = gParent.getRight();
                if (isRed(uncle)) {
                    setBlack(parent);
                    setBlack(uncle);
                    setRed(gParent);
                    insertFixUp(gParent);
                    return;
                }
                if (uncle == null || isBlack(uncle)) {
                    if (node == parent.getLeft()) {
                        setBlack(parent);
                        setRed(gParent);
                        rightRotate(gParent);
                    } else {
                        leftRotate(parent);
                        insertFixUp(parent);
                    }
                }
            } else {
                uncle = gParent.getLeft();
                if (isRed(uncle)) {
                    setBlack(parent);
                    setBlack(uncle);
                    setRed(gParent);
                    insertFixUp(gParent);
                }
                if (uncle == null || isBlack(uncle)) {
                    if (node == parent.getRight()) {
                        setRed(gParent);
                        setBlack(parent);
                        leftRotate(gParent);
                    } else {
                        rightRotate(parent);
                        insertFixUp(parent);
                    }
                }
            }
        }
    }

    /**
     * 将x的左子节点的父节点更新成y，将y的右子节点更新为x的左子节点
     * 将y的父节点的子节点更新为x，将y的父节点更新为x，将x的左子节点更新为y
     */
    private void leftRotate(RBNode<K, V> x) {
        RBNode<K, V> y = x.getParent();
        if (y == null) {
            return;
        }
        x.getLeft().setParent(y);
        y.setRight(x.getLeft());
        if (y.getParent() == null) {
            this.root = x;
        } else if (y == y.getParent().getLeft()) {
            y.getParent().setLeft(x);
        } else {
            y.getParent().setRight(x);
        }
        x.setLeft(y);
        y.setParent(x);
    }

    /**
     * 将x的右子节点的父节点更新为y，将y的左子节点更新为x的右子节点
     * 将y的父节点的子节点更新为x，将y的父节点更新为x，将x的右子节点更新为y
     */
    private void rightRotate(RBNode<K, V> x) {
        RBNode<K, V> y = x.getParent();
        if (y == null) {
            return;
        }
        x.getRight().setParent(y);
        y.setLeft(x.getRight());
        if (y.getParent() == null) {
            this.root = x;
        } else if (y == y.getParent().getLeft()) {
            y.getParent().setLeft(x);
        } else {
            y.getParent().setRight(x);
        }
        x.setRight(y);
        y.setParent(x);
    }

    private void print(RBNode<K, V> tree, K key, int direction) {

        if (tree != null) {

            if (direction == 0)    // tree是根节点
                System.out.printf("%2s(B) is root\n", tree.key);
            else                // tree是分支节点
                System.out.printf("%2s(%s) is %s's %6s child\n", tree.key, isRed(tree) ? "R" : "B", key, direction == 1 ? "right" : "left");

            print(tree.left, tree.key, -1);
            print(tree.right, tree.key, 1);
        }
    }

    public void print() {
        if (root != null)
            print(root, root.key, 0);
    }

    static class RBNode<K extends Comparable<K>, V> {
        private RBNode<K, V> parent;
        private RBNode<K, V> left;
        private RBNode<K, V> right;
        private boolean color;
        private K key;
        private V value;

        public RBNode() {
        }

        public RBNode(RBNode<K, V> parent, RBNode<K, V> left, RBNode<K, V> right, boolean color, K key, V value) {
            this.parent = parent;
            this.left = left;
            this.right = right;
            this.color = color;
            this.key = key;
            this.value = value;
        }

        public RBNode<K, V> getParent() {
            return parent;
        }

        public void setParent(RBNode<K, V> parent) {
            this.parent = parent;
        }

        public RBNode<K, V> getLeft() {
            return left;
        }

        public void setLeft(RBNode<K, V> left) {
            this.left = left;
        }

        public RBNode<K, V> getRight() {
            return right;
        }

        public void setRight(RBNode<K, V> right) {
            this.right = right;
        }

        public boolean isColor() {
            return color;
        }

        public void setColor(boolean color) {
            this.color = color;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
}
