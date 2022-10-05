package Exercises.Ex7LCRSTree;

import Exercises.Ex4PositionInterface.Position;
import Exercises.Ex6NAryTreeDepthFirstIterator.NAryTree;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

public class TestsLCRSTreeEx7 {

    NAryTree<String> systemDirectory;

    @BeforeEach
    void setUp() {
        systemDirectory = new LCRSTree<>();
        Position<String> root = systemDirectory.addRoot("C:/");
        systemDirectory.add("\tIntel/", root);
        Position<String> lastFolder = systemDirectory.add("\tProgram Files/", root);
        Position<String> zip = systemDirectory.add("\t\t7-zip/", lastFolder);
        systemDirectory.add("\t\t\t7-zip.exe", zip);
        systemDirectory.add("\t\t\t7-zip.dll", zip);
        systemDirectory.add("\t\t\t7-zip.chm", zip);
        Position<String> google = systemDirectory.add("\t\tGoogle/", lastFolder);
        google = systemDirectory.add("\t\t\tChrome/", google);
        systemDirectory.add("\t\t\t\tchrome.exe", google);
        systemDirectory.add("\t\t\t\tchrome_proxy.exe", google);
        systemDirectory.add("\t\t\t\tmaster_preferences", google);
        systemDirectory.add("\tProgramData/", root);
        Position<String> users = systemDirectory.add("\tUsers/", root);
        systemDirectory.add("\t\t" + System.getProperty("user.name"), users);
        systemDirectory.add("\tWindows/", root);
    }

    @Test
    @DisplayName("DFSPostOrderIterator")
    void DFSPostOrderIterator() {
        Iterator<Position<String>> iterator = systemDirectory.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next().getElement());
        }
    }

}
