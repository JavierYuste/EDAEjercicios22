package Exercises.Ex8BinaryTree;

import Exercises.Ex4PositionInterface.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

public class TestsBinaryTree {

    BinaryTree<String> arithmeticExpression;

    @BeforeEach
    void setUp() {
        // ((3 * 2) / (1 + 2)) - ((3 - 2) * (5 - 3))
        arithmeticExpression = new LinkedBinaryTree<>();
        Position<String> root = arithmeticExpression.addRoot("-");
        Position<String> first = arithmeticExpression.insertLeft(root, "/");
        Position<String> second = arithmeticExpression.insertLeft(first, "*");
        arithmeticExpression.insertLeft(second, "3");
        arithmeticExpression.insertRight(second, "2");
        second = arithmeticExpression.insertRight(first, "+");
        arithmeticExpression.insertLeft(second, "1");
        arithmeticExpression.insertRight(second, "2");
        first = arithmeticExpression.insertRight(root, "*");
        second = arithmeticExpression.insertLeft(first, "-");
        arithmeticExpression.insertLeft(second, "3");
        arithmeticExpression.insertRight(second, "2");
        second = arithmeticExpression.insertRight(first, "-");
        arithmeticExpression.insertLeft(second, "5");
        arithmeticExpression.insertRight(second, "3");


    }

    @Test
    @DisplayName("Comprueba si el árbol binario es completo (todos los nodos internos tienen dos hijos)")
    void isBinaryTreeProper() {
        Assertions.assertTrue(checkIfBinaryTreeIsProper(arithmeticExpression));
        BinaryTree<Integer> emptyTree = new LinkedBinaryTree<>();
        Assertions.assertTrue(checkIfBinaryTreeIsProper(emptyTree));
        BinaryTree<Integer> notProperBinaryTree = new LinkedBinaryTree<>();
        Position<Integer> root = notProperBinaryTree.addRoot(1);
        Position<Integer> left = notProperBinaryTree.insertLeft(root, 2);
        notProperBinaryTree.insertLeft(left, 3);
        notProperBinaryTree.insertRight(left, 3);
        Position<Integer> right = notProperBinaryTree.insertRight(root, 2);
        notProperBinaryTree.insertLeft(right, 3);
        Assertions.assertFalse(checkIfBinaryTreeIsProper(notProperBinaryTree));
    }

    @Test
    void inorderIterator() {
        Iterator<Position<String>> iterator = arithmeticExpression.iterator();
        StringBuilder result = new StringBuilder();
        while (iterator.hasNext()){
            result.append(iterator.next().getElement());
        }
        System.out.println(result.toString());
        Assertions.assertEquals("3*2/1+2-3-2*5-3", result.toString());
    }

    <E> boolean checkIfBinaryTreeIsProper(BinaryTree<E> tree){
        // TODO
        throw new UnsupportedOperationException("Not implemented");
    }

}
