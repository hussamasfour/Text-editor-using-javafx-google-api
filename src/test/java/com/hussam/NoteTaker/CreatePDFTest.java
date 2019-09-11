package com.hussam.NoteTaker;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class CreatePDFTest {
    @DisplayName("This is an example of a passing test")
    @Test
    void passingTest() {
        assertTrue(true);
    } // This will always be true

    @DisplayName("This is an example of a failing test")
    @Test
    @Disabled
    void failingTest() {
        fail("This is a failure on purpose");
    } // This will always fail

    @DisplayName("This should always succeed")
    @Test
    void shouldCreatePDF(){
        // Create our text area and input some text in it
        String text = "This is a unit test";

        // Create our properties for each character
        Map<Integer,Map<CharacterProperties,String>> list = new HashMap<>(); // The hashmap that save all the letter indexes

        for (int i = 0; i <text.length(); i++) {
            Map<CharacterProperties, String> properties = new HashMap<>();
            properties.put(CharacterProperties.Color, "black");
            properties.put(CharacterProperties.Family, "Ariel");
            properties.put(CharacterProperties.Size, "12");
            properties.put(CharacterProperties.Style,"normal");
            properties.put(CharacterProperties.Weight,"normal");

            list.put(i, properties);
        }

        String dest="tests/unitTest.pdf";

        File file = new File(dest);
        file.getParentFile().mkdirs();

        assertDoesNotThrow(() -> {
            new CreatePDF().createPdf(dest,text,list);
        });
    }

    @DisplayName("This should throw an IOexception because the file name is incorrect")
    @Test
    void shouldCreatePDFThrowsException() {
        // Create our text area and input some text in it
        String text = "This is a failing unit test";

        // Create our properties for each character
        Map<Integer,Map<CharacterProperties,String>> list = new HashMap<>(); // The hashmap that save all the letter indexes

        for (int i = 0; i <text.length(); i++) {
            Map<CharacterProperties, String> properties = new HashMap<>();
            properties.put(CharacterProperties.Color, "black");
            properties.put(CharacterProperties.Family, "Ariel");
            properties.put(CharacterProperties.Size, "12");
            properties.put(CharacterProperties.Style,"normal");
            properties.put(CharacterProperties.Weight,"normal");

            list.put(i, properties);
        }

        String dest="tests/unit>Test.pdf";

        File file = new File(dest);
        file.getParentFile().mkdirs();

        assertThrows(IOException.class, () -> {
            new CreatePDF().createPdf(dest,text,list);
        });
    }
}
