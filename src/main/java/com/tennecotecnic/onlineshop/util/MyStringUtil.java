package com.tennecotecnic.onlineshop.util;

public class MyStringUtil {

    public static String cutstring(String text, int index) {  //метод выделяет index символов в тексте начиная с нулевого,
                                                              // добавляя недостающие при необходимости
        String newString = "";
        char [] array = text.toCharArray();
        int charSize = array.length;
        for(int i = 0; i<=index; i++){
            if (charSize>0) {
                newString = newString + array[i];
                charSize--;
            } else {
                newString = newString + " ";
            }
        }
        return newString + " ";
    }
}
