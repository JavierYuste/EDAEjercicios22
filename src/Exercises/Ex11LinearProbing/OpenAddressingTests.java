package Exercises.Ex11LinearProbing;

import Exercises.Ex9Maps.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Random;

public class OpenAddressingTests {

    int initialValues = 5000;
    int updates = 100000;

    @Test
    public void testLinearProbeHashMap() {
        var ownImplementation = new LinearProbeHashMap<>(this.initialValues * 2);
        Assertions.assertTrue(ownImplementation.isEmpty());

        Random random = new Random();
        HashMap<Integer, Integer> hashMapImplementation = new HashMap<>(this.initialValues * 2);

        for (int i = 0; i < initialValues; i++) {
            int key = random.nextInt(initialValues);
            int value = random.nextInt();
            ownImplementation.put(key, value);
            hashMapImplementation.put(key, value);
        }

        for (int i = 0; i < updates; i++) {
            int key = random.nextInt(initialValues);
            int value = random.nextInt();
            int operation = random.nextInt(4);
            if (operation == 0){
                Assertions.assertEquals(hashMapImplementation.put(key, value), ownImplementation.put(key, value));
                Assertions.assertEquals(hashMapImplementation.size(), ownImplementation.size());
            }
            else if (operation == 1){
                Assertions.assertEquals(hashMapImplementation.get(key), ownImplementation.get(key));
                Assertions.assertEquals(hashMapImplementation.size(), ownImplementation.size());
            }
            else{
                Assertions.assertEquals(hashMapImplementation.remove(key), ownImplementation.remove(key));
                Assertions.assertEquals(hashMapImplementation.size(), ownImplementation.size());
            }
        }
    }

}
