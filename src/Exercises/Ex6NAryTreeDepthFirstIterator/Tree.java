package Exercises.Ex6NAryTreeDepthFirstIterator;


import Exercises.Ex4PositionInterface.Position;

/**
 * An interface for a tree where nodes can have an arbitrary number of children.
 *
 * @author Abraham Duarte
 * @author Jose F. Velez
 * @author Jesus Sanchez-Oro
 * @param <E> Element stored in tree nodes.
 */
public interface Tree<E> extends Iterable<Position<E>> {

    /**
     * Returns whether the tree is empty.
     * @return 
     */
    public boolean isEmpty();

    /**
     * Returns the root of the tree.
     * @return 
     */
    public Position<E> root();

    /**
     * Returns the parent of a given node.
     * @param v
     * @return 
     */
    public Position<E> parent(Position<E> v);

    /**
     * Returns an iterable collection of the children of a given node.
     * @param v
     * @return 
     */
    public Iterable<? extends Position<E>> children(Position<E> v);

    /**
     * Returns whether a given node is internal.
     * @param v
     * @return 
     */
    public boolean isInternal(Position<E> v);

    /**
     * Returns whether a given node is external.
     * @param v
     * @return 
     */
    public boolean isLeaf(Position<E> v);

    /**
     * Returns whether a given node is the root of the tree.
     * @param v
     * @return 
     */
    public boolean isRoot(Position<E> v);
}