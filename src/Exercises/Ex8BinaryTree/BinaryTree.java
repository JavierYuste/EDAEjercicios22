package Exercises.Ex8BinaryTree;


import Exercises.Ex4PositionInterface.Position;
import Exercises.Ex6NAryTreeDepthFirstIterator.Tree;

/**
 * An interface for a binary tree, where each node can have zero, one, or two
 * children.
 *
 * @author A. Duarte, J. Vélez
 * @param <E>
 */
public interface BinaryTree<E> extends Tree<E>, Iterable<Position<E>> {

    /**
     * Returns the left child of a node.
     *
     * @param v
     * @return
     */
    public Position<E> left(Position<E> v);

    /**
     * Returns the right child of a node.
     *
     * @param v
     * @return
     */
    public Position<E> right(Position<E> v);

    /**
     * Returns whether a node has a left child.
     *
     * @param v
     * @return
     */
    public boolean hasLeft(Position<E> v);

    /**
     * Returns whether a node has a right child.
     *
     * @param v
     * @return
     */
    public boolean hasRight(Position<E> v);

    /**
     * Returns whether a node is internal.
     */
    @Override
    public boolean isInternal(Position<E> v);

    /**
     * Returns whether a node is external.
     *
     * @param p
     */
    @Override
    public boolean isLeaf(Position<E> p);

    /**
     * Returns whether a node is the root.
     *
     * @param p
     */
    @Override
    public boolean isRoot(Position<E> p);

    /**
     * Returns the root of the tree.
     */
    @Override
    public Position<E> root();

    public E replace(Position<E> p, E e);

    /**
     * Return the sibling of a node
     *
     * @param p
     * @return
     */
    public Position<E> sibling(Position<E> p);

    /**
     * Adds a root node to an empty tree
     *
     * @param e
     * @return
     */
    public Position<E> addRoot(E e);

    /**
     * Inserts a left child at a given node.
     *
     * @param p
     * @param e
     * @return
     */
    public Position<E> insertLeft(Position<E> p, E e);

    /**
     * Inserts a right child at a given node.
     *
     * @param p
     * @param e
     * @return
     */
    public Position<E> insertRight(Position<E> p, E e);

    /**
     * Removes a node with zero or one child.
     *
     * @param p
     * @return
     */
    public E remove(Position<E> p);
    
    /**
     * Swap the elements at two nodes
     *
     * @param p1
     * @param p2
     */
    public void swap(Position<E> p1, Position<E> p2);

}
