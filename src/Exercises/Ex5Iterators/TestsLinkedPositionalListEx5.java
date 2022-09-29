package Exercises.Ex5Iterators;

import Exercises.Ex4PositionInterface.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.Random;

public class TestsLinkedPositionalListEx5 {

    LinkedPositionalListWithIterator<Integer> positionalList;

    void setUpRandom() {
        Random random = new Random();
        positionalList = new LinkedPositionalListWithIterator<>();
        for (int i = 0; i < 15; i++) {
            positionalList.addFirst(random.nextInt(0, 50));
        }
    }

    void setUp() {
        positionalList = new LinkedPositionalListWithIterator<>();
        for (int i = 0; i < 15; i++) {
            positionalList.addLast(i);
        }
    }

    @Test
    @Order(0)
    @DisplayName("Sort a LinkedPositionalList")
    void sortLinkedPositionalList() {
        this.setUpRandom();
        System.out.println("Original layout of the positional list: " + positionalList.toString());
        insertionSort(positionalList);
        System.out.println("Final layout of the positional list: " + positionalList.toString());
        Assertions.assertTrue(assertOrderOfPositionalList(positionalList));
    }

    @Test
    @Order(1)
    @DisplayName("Iterate through Position<E> in a LinkedPositionalList")
    void iteratePositions() {
        this.setUp();
        Iterator<Position<Integer>> iterator = positionalList.iterator();
        StringBuilder result = new StringBuilder();
        while (iterator.hasNext()){
            result.append(iterator.next().getElement());
            result.append(", ");
        }
        System.out.println(result.toString());
    }

    @Test
    @Order(2)
    @DisplayName("Iterate through Element<E> in a LinkedPositionalList")
    void iterateElements() {
        this.setUp();
        Iterator<Integer> iterator = positionalList.elementIterator();
        StringBuilder result = new StringBuilder();
        while (iterator.hasNext()){
            result.append(iterator.next());
            result.append(", ");
        }
        System.out.println(result.toString());
    }

    @Test
    @Order(3)
    @DisplayName("Print items in a LinkedPositionalList with an enhanced for")
    void enhancedFor() {
        this.setUp();
        StringBuilder result = new StringBuilder();
        for (Position<Integer> position : positionalList.positions()) {
            result.append(position.getElement());
            if (positionalList.after(position) != null) {
                result.append(", ");
            }
        }
        System.out.println(result.toString());
    }

    @Test
    @Order(4)
    @DisplayName("Sort a LinkedPositionalList and check it with a Positions Iterator")
    void assertSortedLinkedPositionalListWithIterator() {
        this.setUpRandom();
        System.out.println("Original layout of the positional list: " + positionalList.toString());
        insertionSort(positionalList);
        System.out.println("Final layout of the positional list: " + positionalList.toString());
        Assertions.assertTrue(assertOrderOfPositionalListWithIterator(positionalList));
    }

    public static boolean assertOrderOfPositionalListWithIterator(LinkedPositionalListWithIterator<Integer> list){
        // TODO: comprobar el orden de la lista utilizando un iterador por posiciones (Iterator)
        return false;
    }

    @Test
    @Order(5)
    @DisplayName("Sort a LinkedPositionalList and check it with an Elements iterator")
    void assertSortedLinkedPositionalListWithElementsIterator() {
        this.setUpRandom();
        System.out.println("Original layout of the positional list: " + positionalList.toString());
        insertionSort(positionalList);
        System.out.println("Final layout of the positional list: " + positionalList.toString());
        Assertions.assertTrue(assertOrderOfPositionalListWithElementsIterator(positionalList));
    }

    public static boolean assertOrderOfPositionalListWithElementsIterator(LinkedPositionalListWithIterator<Integer> list){
        // TODO: comprobar el orden de la lista utilizando un iterador por elementos (ElementIterator)
        return false;
    }

    public static void insertionSort(LinkedPositionalListWithIterator<Integer> list) {
        Position<Integer> currentPosition;
        boolean swapped = true;
        while (swapped) {
            swapped = false;
            currentPosition = list.first();
            while (currentPosition != list.last()) {
                if (currentPosition.getElement() > list.after(currentPosition).getElement()) {
                    int element = currentPosition.getElement();
                    list.set(currentPosition, list.after(currentPosition).getElement());
                    list.set(list.after(currentPosition), element);
                    swapped = true;
                }
                currentPosition = list.after(currentPosition);
            }
        }
    }

    public static boolean assertOrderOfPositionalList(LinkedPositionalListWithIterator<Integer> list){
        Position<Integer> currentPosition = list.first();
        while (currentPosition != list.last()) {
            if (currentPosition.getElement() > list.after(currentPosition).getElement()){
                return false;
            }
            currentPosition = list.after(currentPosition);
        }
        return true;
    }

}
