package com.hussam.NoteTaker;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CredentialsTest {
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

    @DisplayName("This should fail to find client_secret - This test is disabled by default. Rename/Delete client_secret.json from resources in order for this succeed")
    @Test
    @Disabled
    void getCredentialsThrowsNullException() {
        assertThrows(NullPointerException.class, () -> {
            final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
            final Credential creds=Credentials.getCredentials(HTTP_TRANSPORT);
        });
    }

    @DisplayName("This should fail when client_secret has wrong input inside it. This test is disabled by default. Delete client_secret.json content for this to succesed")
    @Test
    @Disabled
    void getCredentialsThrowsIllegalArgument() {
        assertThrows(IllegalArgumentException.class, () -> {
            final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
            final Credential creds=Credentials.getCredentials(HTTP_TRANSPORT);
        });
    }

    @DisplayName("This should always succeed if client_secret.json exist in resources and has correct content")
    @Test
    void getCredentialsSuccess() {
        assertDoesNotThrow(() -> {
            final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
            final Credential creds=Credentials.getCredentials(HTTP_TRANSPORT);
        });
    }
}
