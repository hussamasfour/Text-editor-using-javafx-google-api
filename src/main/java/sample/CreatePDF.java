package sample;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.property.TextAlignment;
import org.fxmisc.richtext.InlineCssTextArea;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class CreatePDF {
    public static final String TEXT = "C:\\Users\\hussa\\Desktop\\txt2pdf.txt";

    public void createPdf(String dest, InlineCssTextArea textArea) throws IOException {
        String input = textArea.getText();
        PdfDocument pdf = new PdfDocument(new PdfWriter(dest));
        Document document = new Document(pdf).setTextAlignment(TextAlignment.JUSTIFIED);

        //BufferedReader br = new BufferedReader(new FileReader(input));
        //String line;
        //PdfFont normal = PdfFontFactory.createFont(FontConstants.TIMES_ROMAN);//to change the family
        //PdfFont bold = PdfFontFactory.    createFont(FontConstants.TIMES_BOLD); //to change the bold
        System.out.println(input);

       // String input = textArea.getText();
         //  for (int i = 0; i < input.length(); i++) {
               document.add(new Paragraph(input));
           //}
               //outputTopdf(input[i]);
//            Map<CharacterProperties, String> properties = list.get(i);
//            pdfLetter.bold = properties.get(CharacterProperties.Weight);
//            pdfLetter.color = properties.get(CharacterProperties.Color);
//        }

       // boolean title = true;
       // while ((input = br.readLine()) != null) {
         //   document.add(new Paragraph(input));

            //   document.add(new Paragraph(line).setFont(title ? bold : normal)); //to change font
            //    title = line.isEmpty();
        }

       // document.close();
    }
//}

