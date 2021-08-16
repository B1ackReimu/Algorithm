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

    private RBNode<K, V> searchNode(K key) {
        RBNode<K, V> node = this.root;
        while (node != null) {
            int i = key.compareTo(node.getKey());
            if (i == 0) {
                return node;
            } else if (i < 0) {
                node = node.getLeft();
            } else {
                node = node.getRight();
            }
        }
        return null;
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
            setBlack(node);
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
                    return;
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

    public void delete(K key) {
        RBNode<K, V> node = searchNode(key);
        if (node == null) {
            return;
        }
        delete(node);
    }

    private void delete(RBNode<K, V> node) {
        if (node.getRight() != null && node.getLeft() != null) {
            RBNode<K, V> rightMin = rightMin(node);
            cloneNode(node, rightMin);
            node = rightMin;
        }

        RBNode<K, V> child;
        if ((child = node.getLeft()) != null) {
            child.setParent(node.getParent());
        } else if ((child = node.getRight()) != null) {
            child.setParent(node.getParent());
        }

        if (node.getParent() == null) {
            root = child;
        } else if (node == node.getParent().getLeft()) {
            node.getParent().setLeft(child);
        } else {
            node.getParent().setRight(child);
        }

        deleteFixUp(node);
    }

    private void deleteFixUp(RBNode<K, V> node) {
        if (isBlack(node)) {
            if (node.getLeft() != null) {
                setBlack(node.getLeft());
            } else if (node.getRight() != null) {
                setBlack(node.getRight());
            } else {
                RBNode<K, V> parent = node.getParent();
                RBNode<K, V> cousin = getCousin(node);
                if (isBlack(cousin)) {
                    deleteFixUp2(parent, cousin);
                } else {
                    if (cousin == parent.getLeft()) {
                        rightRotate(cousin);
                    } else {
                        leftRotate(cousin);
                    }
                    boolean color = cousin.isColor();
                    cousin.setColor(parent.isColor());
                    parent.setColor(color);
                }
            }
        }

    }

    private void deleteFixUp2(RBNode<K, V> parent, RBNode<K, V> cousin) {
        if ((cousin.getLeft() == null && cousin.getRight() == null) || (isBlack(cousin.getLeft()) && isBlack(cousin.getRight()))) {
            setRed(cousin);
            if (isRed(parent)) {
                setBlack(parent);
            } else {
                deleteFixUp(parent);
            }
        } else {
            boolean color = cousin.isColor();
            if (parent.getLeft() == cousin) {
                if (isBlack(cousin.getLeft())) {
                    leftRotate(cousin);
                    cousin.setColor(cousin.getRight().isColor());
                    cousin.getRight().setColor(color);
                }
                deleteFixUp2221(parent, cousin);
            } else {
                if (isBlack(cousin.getRight())) {
                    rightRotate(cousin);
                    cousin.setColor(cousin.getLeft().isColor());
                    cousin.getLeft().setColor(color);
                }
                deleteFixUp2222(parent, cousin);
            }
        }
    }

    private void deleteFixUp2221(RBNode<K, V> parent, RBNode<K, V> cousin) {
        rightRotate(parent);
        boolean color = cousin.isColor();
        cousin.setColor(parent.isColor());
        parent.setColor(color);
        setBlack(cousin.getLeft());
    }

    private void deleteFixUp2222(RBNode<K, V> parent, RBNode<K, V> cousin) {
        leftRotate(parent);
        boolean color = cousin.isColor();
        cousin.setColor(parent.isColor());
        parent.setColor(color);
        setBlack(cousin.getRight());
    }

    private RBNode<K, V> getCousin(RBNode<K, V> node) {
        if (node == node.getParent().getLeft()) {
            return node.getParent().getRight();
        } else {
            return node.getParent().getLeft();
        }
    }

    private RBNode<K, V> precursorNode(RBNode<K, V> node) {
        RBNode<K, V> x = node.getLeft();
        if (x != null) {
            while (x != null) {
                node = x;
                x = x.getRight();
            }
        } else {
            if (node.getParent() == null) {
                return null;
            }
            if (node == node.getParent().getRight()) {
                node = node.getParent();
            } else {
                node = node.getParent().getParent();
            }
        }
        return node;
    }

    private RBNode<K, V> rightMin(RBNode<K, V> node) {
        RBNode<K, V> x = node.getRight();
        while (x != null) {
            node = x;
            x = x.getLeft();
        }
        return node;
    }

    private void cloneNode(RBNode<K, V> dest, RBNode<K, V> origin) {
        dest.setValue(origin.getValue());
        dest.setKey(origin.key);
    }

    private void leftRotate(RBNode<K, V> x) {
        RBNode<K, V> y = x.getRight();
        if (y == null) {
            return;
        }
        x.setRight(y.getLeft());
        y.getLeft().setParent(x);
        y.setParent(x.getParent());
        if (x.getParent() == null) {
            this.root = y;
        } else if (x == x.getParent().getLeft()) {
            x.getParent().setLeft(y);
        } else {
            x.getParent().setRight(y);
        }
    }

    private void rightRotate(RBNode<K, V> x) {
        RBNode<K, V> y = x.getLeft();
        if (y == null) {
            return;
        }
        x.setLeft(y.getRight());
        y.getRight().setParent(x);
        y.setParent(x.getParent());
        if (x.getParent() == null) {
            this.root = y;
        } else if (x == x.getParent().getLeft()) {
            x.getParent().setLeft(y);
        } else {
            x.getParent().setRight(y);
        }
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
