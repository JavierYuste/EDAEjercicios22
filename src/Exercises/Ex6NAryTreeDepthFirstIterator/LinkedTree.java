package Exercises.Ex6NAryTreeDepthFirstIterator;

import Exercises.Ex4PositionInterface.Position;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A linked class for a tree where nodes have an arbitrary number of children.
 *
 * @author Raul Cabido
 * @author Abraham Duarte
 * @author Jose Velez
 * @author Jesus Sanchez-Oro
 * @param <E> The element stored in the tree
 */
public class LinkedTree<E> implements NAryTree<E> {

    private class TreeNode<E> implements Position<E> {

        private E element;
        private TreeNode<E> parent;
        private List<TreeNode<E>> children;

        /**
         * Main constructor
         */
        public TreeNode(E e, TreeNode<E> p, List<TreeNode<E>> c) {
            this.element = e;
            this.parent = p;
            this.children = c;
        }

        /**
         * Returns the element stored at this position
         */
        @Override
        public E getElement() {
            return element;
        }

        /**
         * Sets the element stored at this position
         */
        public final void setElement(E o) {
            element = o;
        }

        /**
         * Returns the children of this position
         */
        public List<TreeNode<E>> getChildren() {
            return children;
        }

        /**
         * Sets the right child of this position
         */
        public final void setChildren(List<TreeNode<E>> c) {
            children = c;
        }

        /**
         * Returns the parent of this position
         */
        public TreeNode<E> getParent() {
            return parent;
        }

        /**
         * Sets the parent of this position
         */
        public final void setParent(TreeNode<E> v) {
            parent = v;
        }
    }

    private TreeNode<E> root;

    /**
     * Creates an empty tree.
     */
    public LinkedTree() {
        root = null;
    }

    /**
     * Returns whether the tree is empty.
     *
     * @return True if is empty.
     *
     */
    @Override
    public boolean isEmpty() {
        return (root == null);
    }

    /**
     * Returns whether a node is internal.
     * @param v
     * @return
     */
    @Override
    public boolean isInternal(Position<E> v) {
        return !isLeaf(v);
    }

    /**
     * Returns whether a node is external.
     * @param p
     * @return
     */
    @Override
    public boolean isLeaf(Position<E> p) {
        TreeNode<E> node = checkPosition(p);
        return (node.getChildren() == null) || (node.getChildren().isEmpty());
    }

    /**
     * Returns whether a node is the root.
     * @param p
     * @return
     */
    @Override
    public boolean isRoot(Position<E> p) {
        TreeNode<E> node = checkPosition(p);
        return (node == this.root());
    }

    /**
     * Returns the root of the tree.
     * @return
     */
    @Override
    public Position<E> root() {
        if (root == null) {
            throw new RuntimeException("The tree is empty");
        }
        return root;
    }

    /**
     * Returns the parent of a node.
     * @param p
     * @return
     */
    @Override
    public Position<E> parent(Position<E> p) {
        TreeNode<E> node = checkPosition(p);
        Position<E> parentPos = (Position<E>) node.getParent();
        if (parentPos == null) {
            throw new RuntimeException("No parent");
        }
        return parentPos;
    }

    /**
     * Returns an iterable collection of the children of a node.
     * @param p
     */
    @Override
    public Iterable<? extends Position<E>> children(Position<E> p) {
        TreeNode<E> node = checkPosition(p);
        return node.getChildren();
    }

    /**
     * Returns an iterator of the elements stored at the nodes. The nodes are
     * visited according to a breath-first search
     */
    @Override
    public Iterator<Position<E>> iterator() {
        return new DepthFirstTreeIterator<>(this); // An iterator of elements
    }


    /**
     * Replaces the element at a node.
     */
    @Override
    public E replace(Position<E> p, E e) {
        TreeNode<E> node = checkPosition(p);
        E temp = p.getElement();
        node.setElement(e);
        return temp;
    }

    /**
     * Adds a root node to an empty tree
     */
    @Override
    public Position<E> addRoot(E e) {
        if (!isEmpty()) {
            throw new RuntimeException("Tree already has a root");
        }
        root = new TreeNode<>(e, null, new ArrayList<>());
        return root;
    }

    /**
     * Swap the elements at two nodes
     */
    @Override
    public void swapElements(Position<E> p1, Position<E> p2) {
        TreeNode<E> node1 = checkPosition(p1);
        TreeNode<E> node2 = checkPosition(p2);
        E temp = p2.getElement();
        node2.setElement(p1.getElement());
        node1.setElement(temp);
    }

    /**
     * If v is a good tree node, cast to TreePosition, else throw exception
     */
    private TreeNode<E> checkPosition(Position<E> p) {
        if (p == null || !(p instanceof TreeNode)) {
            throw new RuntimeException("The position is invalid");
        }
        TreeNode<E> aux = (TreeNode<E>) p;

        return aux;
    }

    /**
     * Add a new node whose parent is pointed by a given position.
     *
     * @param p The position of the parent, e the element stored in the new
     * created node.
     */
    @Override
    public Position<E> add(E element, Position<E> p) {
        TreeNode<E> parent = checkPosition(p);
        TreeNode<E> newNode = new TreeNode<>(element, parent, new ArrayList<>());
        List<TreeNode<E>> l = parent.getChildren();
        l.add(newNode);
        return newNode;
    }

    /**
     * Add a new node whose parent is pointed by a given position,
     * and set the child at the position n if possible.
     *
     * @param p The position of the parent, e the element stored in the new
     * created node.
     */
    @Override
    public Position<E> add(E element, Position<E> p, final int n) {
        TreeNode<E> parent = checkPosition(p);
        TreeNode<E> newNode = new TreeNode<>(element, parent, new ArrayList<>());
        List<TreeNode<E>> l = parent.getChildren();
        if (n > l.size())
            throw new RuntimeException("The element can't be inserted at specified position.");
        l.add(n, newNode);
        return newNode;
    }



    /**
     * Remove a node and its corresponding subtree rooted at node.
     *
     * @param p The position of the node to be removed.
     */
    @Override
    public void remove(Position<E> p) {
        TreeNode<E> node = checkPosition(p);
        if (node.getParent() != null) {
            TreeNode<E> parent = node.getParent();
            parent.getChildren().remove(node);
        } else {
            this.root = null;
        }
    }

    /**
     * Create un new tree from node v.
     *
     * @param v new root node
     * @return  The new tree.
     */
    @Override
    public LinkedTree<E> subTree(Position<E> v) {
        remove(v);
        TreeNode<E> newRoot = checkPosition(v);
        newRoot.parent = null;
        LinkedTree<E> tree = new LinkedTree<>();
        tree.root = newRoot;
        return tree;
    }

    /**
     * Attach tree t as children of node p
     * @param p - Node in which t will be attached or null if t is attached in the root.
     * @param t - Tree to be attached.
     */
    @Override
    public void attach(Position<E> p, NAryTree<E> t) {

        if (t.getClass()!= this.getClass()) {
            throw new RuntimeException("Cannot attach trees of different classes");
        } else if (t == this) {
            throw new RuntimeException("Cannot attach a tree over himself");
        } else if ((p == null) && (this.root != null)) {
            throw new RuntimeException("Cannot attach a tree t in this root beacuse this tree is not empty");
        }

        LinkedTree<E> lt = (LinkedTree<E>) t;

        if (p == null) {
            root = lt.root;
            lt.root = null;
        } else {
            TreeNode<E> node = checkPosition(p);

            if (!t.isEmpty()) {
                TreeNode<E> r = checkPosition(t.root());
                node.children.add(r);
                r.setParent(node);
                lt.root = null;
            }
        }
    }

}
