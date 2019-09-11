package com.hussam.NoteTaker;

import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

import java.io.*;
import java.util.Map;
import com.itextpdf.io.font.FontConstants;

import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.font.PdfFontFactory;

import com.itextpdf.layout.element.Text;

public class CreatePDF {

    public void createPdf(String dest, String input, Map list) throws IOException {
        //Initalizes pdf writer
        FileOutputStream fos = new FileOutputStream(dest);
        PdfWriter writer = new PdfWriter(fos);

        //initalizes pdf Document
        PdfDocument pdf = new PdfDocument(writer);

        //Initalize document
        Document document = new Document(pdf);
        Paragraph p = new Paragraph();

        for(int i = 0 ; i < input.length(); i++) {
            Map<CharacterProperties, String> properties = (Map<CharacterProperties, String>) list.get(i);
            Color c = Color.BLACK;
            PdfFont f = (PdfFontFactory.createFont(FontConstants.HELVETICA));

            if(properties.get(CharacterProperties.Color)=="red"){
                c=Color.RED;
            }
            else if(properties.get(CharacterProperties.Color)=="green"){
                c=Color.GREEN;
            }
            else if(properties.get(CharacterProperties.Color)=="yellow"){
                c=Color.YELLOW;
            }

            if(properties.get(CharacterProperties.Family)=="Times New Roman"){
                f=(PdfFontFactory.createFont(FontConstants.TIMES_ROMAN));
            }

            else if(properties.get(CharacterProperties.Family)=="Calibri"){
                f=(PdfFontFactory.createFont(FontConstants.COURIER));
            }

            else if(properties.get(CharacterProperties.Family)=="Ariel"){
                f = (PdfFontFactory.createFont(FontConstants.HELVETICA));
            }

            //Sets the font styles
            String singleLetter = input.substring(i, i+1);
            Text letterWithProperties = new Text(singleLetter)
                    .setFontColor(c)
                    .setFont(f)
                    .setFontSize(Integer.parseInt(properties.get(CharacterProperties.Size)));

            //Changes the letter to bold if needed
            if(properties.get(CharacterProperties.Weight)=="bold"){
                letterWithProperties.setBold();
            }
            //Changes the letter to italic if needed
            if(properties.get(CharacterProperties.Style)=="italic"){
                letterWithProperties.setItalic();
            }

            p.add(letterWithProperties);
        }

        document.add(p);

        //Closes the document
        document.close();

    }
}