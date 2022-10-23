package Exercises.Ex11LinearProbing;

import Exercises.Ex9Maps.Map;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Random;

public class OpenAddressingEfficiencyTests {

    int initialValues = 5000;
    int updates = 100000;

    @Test
    void timeConsumptionOfUnsortedArrayMap(){
        Map<Integer, Integer> implementation = new UnsortedArrayMap<>();
        testTime(implementation);
    }

    @Test
    void timeConsumptionOfChainHashMap(){
        Map<Integer, Integer> implementation = new ChainHashMap<>();
        testTime(implementation);
    }

    @Test
    void timeConsumptionOfLinearProbeHashMap(){
        Map<Integer, Integer> implementation = new LinearProbeHashMap<>();
        testTime(implementation);
    }

    @Test
    void timeConsumptionOfHashMap(){
        java.util.Map<Integer, Integer> implementation = new HashMap<>();
        Instant start = Instant.now();

        Random random = new Random();
        for (int i = 0; i < initialValues; i++) {
            implementation.put(random.nextInt(), random.nextInt());
        }

        for (int i = 0; i < updates; i++) {
            int key = random.nextInt();
            if (!implementation.containsKey(key)){
                implementation.put(key, random.nextInt());
                implementation.remove(key);
            }
            else{
                implementation.put(key, random.nextInt());
            }
        }

        Duration duration = Duration.between(start, Instant.now());
        System.out.printf("With " + implementation.getClass().getSimpleName() + ", the test took %d.%d seconds%n", duration.toSecondsPart(), duration.toMillisPart());
    }

    void testTime(Map<Integer, Integer> implementation){
        Instant start = Instant.now();

        Random random = new Random();
        for (int i = 0; i < initialValues; i++) {
            implementation.put(random.nextInt(), random.nextInt());
        }

        for (int i = 0; i < updates; i++) {
            int key = random.nextInt();
            if (!implementation.containsKey(key)){
                implementation.put(key, random.nextInt());
                implementation.remove(key);
            }
            else{
                implementation.put(key, random.nextInt());
            }
        }

        Duration duration = Duration.between(start, Instant.now());
        System.out.printf("With " + implementation.getClass().getSimpleName() + ", the test took %d.%d seconds%n", duration.toSecondsPart(), duration.toMillisPart());
    }
}
