package Exercises.Ex10ChainHashMap;

import Exercises.Ex9Maps.Map;
import Exercises.Ex9Maps.UnsortedArrayMap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class ChainHashMapTests {

    int initialValues = 5000;
    int updates = 100000;

    @Test
    @Order(1)
    public void countWordsInText() throws FileNotFoundException {
        Map<String,Integer> freq = new ChainHashMap<>();
        Scanner doc = null;
        doc = new Scanner(new File("text.txt"));
        while (doc.hasNextLine()) {
            String[] data = doc.nextLine().split(" ");
            for (String word : data) {
                String key = word.toLowerCase();
                if (freq.containsKey(key)){
                    freq.put(key, freq.get(key) + 1);
                }
                else{
                    freq.put(key, 1);
                }
            }
        }
        Assertions.assertFalse(freq.isEmpty());
        int maxCount = 0;
        String maxWord = "No word?";
        for (java.util.Map.Entry<String,Integer> ent : freq.entrySet()) {
            if (ent.getValue() > maxCount) {
                maxWord = ent.getKey();
                maxCount = ent.getValue();
            }
        }
        System.out.print("The most frequent word is '" + maxWord);
        System.out.println("' with " + maxCount + " occurrences.");
        Assertions.assertEquals("de", maxWord);
        Assertions.assertEquals(21, maxCount);
    }

    @Test
    @Order(2)
    void timeConsumptionOfUnsortedArrayMap(){
        Random random = new Random();
        Map<Integer, Integer> freq = new UnsortedArrayMap<>();
        Instant start = Instant.now();
        for (int i = 0; i < initialValues; i++) {
            freq.put(random.nextInt(), random.nextInt());
        }

        for (int i = 0; i < updates; i++) {
            int key = random.nextInt();
            if (!freq.containsKey(key)){
                freq.put(key, random.nextInt());
                freq.remove(key);
            }
            else{
                freq.put(key, random.nextInt());
            }
        }
        Duration duration = Duration.between(start, Instant.now());
        System.out.printf("With UnsortedArrayMap, the test took %d.%d seconds%n", duration.toSecondsPart(), duration.toMillisPart());
    }

    @Test
    @Order(3)
    void timeConsumptionOfChainHashMap(){
        Random random = new Random();
        Map<Integer, Integer> freq = new ChainHashMap<>();
        Instant start = Instant.now();
        for (int i = 0; i < initialValues; i++) {
            freq.put(random.nextInt(), random.nextInt());
        }

        for (int i = 0; i < updates; i++) {
            int key = random.nextInt();
            if (!freq.containsKey(key)){
                freq.put(key, random.nextInt());
                freq.remove(key);
            }
            else{
                freq.put(key, random.nextInt());
            }
        }
        Duration duration = Duration.between(start, Instant.now());
        System.out.printf("With ChainHashMap, the test took %d.%d seconds%n", duration.toSecondsPart(), duration.toMillisPart());
    }

    @Test
    @Order(4)
    void timeConsumptionOfHashMap(){
        Random random = new Random();
        java.util.Map<Integer, Integer> freq = new HashMap<>();
        Instant start = Instant.now();
        for (int i = 0; i < initialValues; i++) {
            freq.put(random.nextInt(), random.nextInt());
        }

        for (int i = 0; i < updates; i++) {
            int key = random.nextInt();
            if (!freq.containsKey(key)){
                freq.put(key, random.nextInt());
                freq.remove(key);
            }
            else{
                freq.put(key, random.nextInt());
            }
        }
        Duration duration = Duration.between(start, Instant.now());
        System.out.printf("With HashMap, the test took %d.%d seconds%n", duration.toSecondsPart(), duration.toMillisPart());
    }
}
