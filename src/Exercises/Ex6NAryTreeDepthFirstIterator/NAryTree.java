package Exercises.Ex6NAryTreeDepthFirstIterator;


import Exercises.Ex4PositionInterface.Position;

/**
 *
 * @author jvelez
 * @param <E> Elements stored in the tree nodes
 */
public interface NAryTree<E> extends Tree<E> {

    /**
     * Adds a root node to an empty tree
     * @param e
     * @return 
     */
    public Position<E> addRoot(E e);

    /**
     * Add a new node whose parent is pointed by a given position.
     *
     * @param element
     * @param p The position of the parent, e the element stored in the new
     * created node.
     * @return 
     */
    public Position<E> add(E element, Position<E> p);

    /**
     * Add a new node whose parent is pointed by a given position, and set the
     * child at the position n if possible.
     *
     * @param element
     * @param p The position of the parent, e the element stored in the new
     * created node.
     * @param n
     * @return
     */
    public Position<E> add(E element, Position<E> p, final int n);

    /**
     * Swap the elements at two nodes
     *
     * @param p1
     * @param p2
     */
    public void swapElements(Position<E> p1, Position<E> p2);

    /**
     * Replaces the element at a node.
     *
     * @param p
     * @param e
     * @return
     */
    public E replace(Position<E> p, E e);

    /**
     * Remove a node and its corresponding subtree rooted at node.
     *
     * @param p The position of the node to be removed.
     */
    public void remove(Position<E> p);    
    
    /**
     * Create un new tree from node v of the same type that invoqued class.
     *
     * @param v new root node
     * @return  The new tree.
     */
    public NAryTree<E> subTree(Position<E> v);
    
    
   /**
     * Attach tree t as children of node p if t and "this" are of the same class.
     * @param p - Node in which t will be attached or null if t is attached in the root.
     * @param t - Tree to be attached.
     */    
    public void attach(Position<E> p, NAryTree<E> t);
    
}
