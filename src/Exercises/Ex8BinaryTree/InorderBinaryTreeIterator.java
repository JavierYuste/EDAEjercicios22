package Exercises.Ex8BinaryTree;

import Exercises.Ex4PositionInterface.Position;
import java.util.Iterator;

public class InorderBinaryTreeIterator<T> implements Iterator<Position<T>> {

    public InorderBinaryTreeIterator(BinaryTree <T> tree) {
        this(tree, tree.root());
    }

    public InorderBinaryTreeIterator(BinaryTree <T> tree, Position<T> node) {
        // TODO
        throw new UnsupportedOperationException("Not implemented");
    }
        
    @Override
    public boolean hasNext() {
        // TODO
        throw new UnsupportedOperationException("Not implemented");
    }

    /**
     * This method visits the nodes of a tree by following a breath-first search
     */
    @Override
    public Position<T> next() {
        // TODO
        throw new UnsupportedOperationException("Not implemented");
    }

}
