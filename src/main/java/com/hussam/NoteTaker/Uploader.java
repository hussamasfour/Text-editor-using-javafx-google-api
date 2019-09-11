package com.hussam.NoteTaker;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.FileContent;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.File;
import java.io.IOException;
import java.security.GeneralSecurityException;

public class Uploader {
    private static final String APPLICATION_NAME = "Google Drive API Java Quickstart";
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();


    public static void upload(Document doc) throws IOException, GeneralSecurityException{

        // Build a new authorized API client service.
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        final Credential creds=Credentials.getCredentials(HTTP_TRANSPORT);

        Drive service = new Drive.Builder(HTTP_TRANSPORT, JSON_FACTORY, creds)
                .setApplicationName(APPLICATION_NAME)
                .build();

        File fileMetadata = new File();
        String fileExtension;

        switch (doc.getFileType()) {
            case pdf:
                fileExtension=".pdf";
                break;
            default:
                throw new IllegalArgumentException("Unsupported file type.");
        }

        fileMetadata.setName(doc.getFileName()+fileExtension);
        java.io.File filePath = new java.io.File(doc.getFilePath()+doc.getFileName()+fileExtension);
        FileContent mediaContent = new FileContent("text/pdf", filePath);
        File file = service.files().create(fileMetadata, mediaContent)
                .setFields("id")
                .execute();
        System.out.println("File ID: " + file.getId());
    }
}
