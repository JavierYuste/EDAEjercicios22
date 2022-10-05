package Exercises.Ex7LCRSTree;

import Exercises.Ex4PositionInterface.Position;
import Exercises.Ex6NAryTreeDepthFirstIterator.NAryTree;

import java.util.Iterator;

public class LCRSTree<E> implements NAryTree<E> {

    // TODO: implementar esta clase

    @Override
    public Position<E> addRoot(E e) {
        return null;
    }

    @Override
    public Position<E> add(E element, Position<E> p) {
        return null;
    }

    @Override
    public Position<E> add(E element, Position<E> p, int n) {
        return null;
    }

    @Override
    public void swapElements(Position<E> p1, Position<E> p2) {

    }

    @Override
    public E replace(Position<E> p, E e) {
        return null;
    }

    @Override
    public void remove(Position<E> p) {

    }

    @Override
    public NAryTree<E> subTree(Position<E> v) {
        return null;
    }

    @Override
    public void attach(Position<E> p, NAryTree<E> t) {

    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Position<E> root() {
        return null;
    }

    @Override
    public Position<E> parent(Position<E> v) {
        return null;
    }

    @Override
    public Iterable<? extends Position<E>> children(Position<E> v) {
        return null;
    }

    @Override
    public boolean isInternal(Position<E> v) {
        return false;
    }

    @Override
    public boolean isLeaf(Position<E> v) {
        return false;
    }

    @Override
    public boolean isRoot(Position<E> v) {
        return false;
    }

    @Override
    public Iterator<Position<E>> iterator() {
        return new DFSPostOrderTreeIterator<>(this);
    }

}
