package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.IndexRange;
import javafx.scene.input.KeyEvent;
import javafx.scene.control.TextArea;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import org.fxmisc.richtext.InlineCssTextArea;
import org.fxmisc.richtext.InlineCssTextArea;
import org.fxmisc.richtext.StyleClassedTextArea;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import java.util.HashMap;
import java.util.Map;


import static javafx.scene.AccessibleAttribute.OFFSET_AT_POINT;

public class Controller {

    @FXML InlineCssTextArea textArea ;
    @FXML private ComboBox ColorBoxColor;
    @FXML private ComboBox sizeComboBox;
    @FXML private ComboBox familyComboBox;
    @FXML private ComboBox StyleComboBox;
    @FXML private ComboBox WeightComboBox;
    //FontPosture fontPosture;
    //String fontType ;
    //int fontSize;
    //FontWeight fontWeight = FontWeight.NORMAL;

    CharacterStyle style = new CharacterStyle();
  //  Integer indexOfLetter = textArea.getCaretPosition();


    Map<Integer,Map<CharacterProperties,String>> list = new HashMap<>(); // The hashmap that save all the letter indexes

    @FXML
    public void handleTextAreaAction(KeyEvent key) {

        Map<CharacterProperties,String> defaultCharacter = new HashMap<>(); //The map where saves properties of the character

        //setting the default properties
        defaultCharacter.put(CharacterProperties.Color, "black");
        defaultCharacter.put(CharacterProperties.Family, "Ariel");
        defaultCharacter.put(CharacterProperties.Size, "12");
        defaultCharacter.put(CharacterProperties.Style,"normal");
        defaultCharacter.put(CharacterProperties.Weight,"normal");

        Integer indexOfLetter = textArea.getCaretPosition();

        //putting the index and default properties into the HashMap
        list.put(indexOfLetter-1,defaultCharacter);

    }

    //Changes the style
    @FXML
    public void styleOnAction(ActionEvent event){
        int start=textArea.getSelection().getStart();
        int last= textArea.getSelection().getEnd();

        try {

            String style;

            if (StyleComboBox.getValue().equals("Italic")) {
                style="italic";
            }
            else{
                style="normal";
            }
            ChangeCharacterStyle(start, last, CharacterProperties.Style,style);

        } catch (Exception ex) {

        }
    }

    public void weightOnAction(ActionEvent event) {
        int start=textArea.getSelection().getStart();
        int last= textArea.getSelection().getEnd();

        try {

            String weight;
            if (WeightComboBox.getValue().equals("Bold")) {
                weight="bold";
            }
            else{
                weight="normal";
            }
            ChangeCharacterStyle(start, last, CharacterProperties.Weight,weight);

        } catch (Exception ex) {

        }
    }

    @FXML
    public void colorOnAction(ActionEvent event) {
        int start=textArea.getSelection().getStart();
        int last= textArea.getSelection().getEnd();

        try {

            String color;

            if (ColorBoxColor.getValue().equals("Red")) {
                color="red";
            }
            else if (ColorBoxColor.getValue().equals("Black")){
                color="black";
            }
            else if (ColorBoxColor.getValue().equals("Green")) {
                color="green";
            }else{
                color="blue";
            }

            ChangeCharacterStyle(start, last, CharacterProperties.Color,color);

        }catch (Exception ex) {

        }
    }

    @FXML
    public void sizeOnAction(ActionEvent event) {
        int fontSize;

        try {

            int start=textArea.getSelection().getStart();
            int last= textArea.getSelection().getEnd();

            if (sizeComboBox.getValue().equals("11"))
                fontSize = style.getSize(11);
            else if (sizeComboBox.getValue().equals("12"))
                fontSize = style.getSize(12);
            else if (sizeComboBox.getValue().equals("14"))
                fontSize = style.getSize(14);
            else if (sizeComboBox.getValue().equals("16"))
                fontSize = style.getSize(16);
            else if (sizeComboBox.getValue().equals("18"))
                fontSize = style.getSize(18);
            else
                fontSize = style.getSize(24);

            ChangeCharacterStyle(start, last, CharacterProperties.Size,Integer.toString(fontSize));


        } catch (Exception ex) {

        }

    }

    public void familyOnAction(ActionEvent event) {
        try {

            int start=textArea.getSelection().getStart();
            int last= textArea.getSelection().getEnd();
            String familyName;

            if (familyComboBox.getValue().equals("Times New Roman")) {
                familyName="Times New Roman";
            } else if(familyComboBox.getValue().equals("Arial")) {
                familyName="Arial";
            }
            else
                familyName="Calibri";

            ChangeCharacterStyle(start, last, CharacterProperties.Family,familyName);

        } catch (Exception ex) {

        }
    }

    public void UploadButtonClicked(ActionEvent event) throws IOException {
        final String DEST = "C:\\Users\\hussa\\Desktop\\CreatePDF.pdf"; //Where it will be saved

        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new CreatePDF().createPdf(DEST,textArea);


    }

    private void ChangeCharacterStyle(int start,int last, CharacterProperties property,String value){

        for(int i=start;i<last;i++){
            Map<CharacterProperties,String> character = list.get(i);
            character.replace(property, value);
            list.replace(i,character);
            String c="-fx-fill: "+ style.getColor(character.get(CharacterProperties.Color));
            String s="-fx-font-size: " + style.getSize(Integer.parseInt(character.get(CharacterProperties.Size)));
            String f="-fx-font-family: " +style.getFont(character.get(CharacterProperties.Family));
            String st="-fx-font-style: " + style.getStyle(character.get(CharacterProperties.Style));
            String b="-fx-font-weight: " + style.getWeight(character.get(CharacterProperties.Weight));
            textArea.setStyle(i,i+1,c+";"+s+";"+f+";"+st+";"+b);
//            textArea.setStyle(start,last,c+";"+s+";"+f+";"+st+";"+b);
        }
    }

}
