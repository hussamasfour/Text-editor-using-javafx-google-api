package com.hussam.NoteTaker;

public class Document {
    private String fileName;
    private String filePath;
    private FileType fileType;

    public Document(String fileName, String filePath ,FileType fileType){
        this.fileName=fileName;
        this.fileType=fileType;
        this.filePath=filePath;
    }

    public String getFileName() {
        return fileName;
    }

    public FileType getFileType() {
        return fileType;
    }

    public String getFilePath() {
        return filePath;
    }
}
