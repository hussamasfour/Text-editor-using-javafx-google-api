package com.hussam.NoteTaker;
public class CharacterStyle{
    private String fontType;
    private String fontWeight;

    public String getColor(String name){

        if(name.equalsIgnoreCase("black")){
            return "black";
        }else if(name.equalsIgnoreCase("red")){
            return "red";
        }
        else if(name.equalsIgnoreCase("green")){
            return "green";
        }
        else {
            return "yellow";
        }
    }
    public int getSize(int size1)
    {
        int size[] = {11,12,14,16,18,24};

        int index;

        if(size1==11)
            index = 0;
        else if(size1==12)
            index = 1;
        else if(size1==14)
            index = 2;
        else if(size1 == 16)
            index = 3;
        else if(size1 == 18)
            index = 4;
        else
            index = 5;

        return size[index];

    }

    public String getFont(String fontFamily) {

        String font;

        if (fontFamily.equalsIgnoreCase("Times New Roman")) {

            font = "Times New Roman";

        } else if(fontFamily.equalsIgnoreCase("Arial")) {

            font = "Arial";
        }
        else
            font="Calibri";

        return font;
    }

    public String getStyle(String style){
        if(style== "italic"){

            return "Italic";

        }else{

           return "Normal";

        }
    }

    public String getWeight(String weight){
        if(weight == "bold"){

            return "bold";
        }
        else{

            return "Normal";
        }
    }

}