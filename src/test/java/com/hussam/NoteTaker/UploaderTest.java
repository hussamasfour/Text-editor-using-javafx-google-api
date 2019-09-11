package com.hussam.NoteTaker;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

public class UploaderTest {

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
    void shouldUploadWithoutException(){
        TextDocument textDocument = new TextDocument("testFile","tests/",FileType.pdf );

        assertDoesNotThrow(() -> {
            Uploader.upload(textDocument);
        });
    }

    @DisplayName("This should throw an exception when file is not found")
    @Test
    void shouldUploadThrowException() {
        TextDocument textDocument = new TextDocument("abc","abc",FileType.pdf);
        assertThrows(FileNotFoundException.class, ()-> {
            Uploader.upload(textDocument);
        });
    }
}
