package edu.depaul.cdm;

public class ConvertTemp {
    public static String toCelsiuis(String fahrenheit){
        fahrenheit=fahrenheit.trim();
        float input=Float.parseFloat(fahrenheit);
        float res=((input-32)*5)/9;
        return String.valueOf(res);
    }
    public static String toFahrenheit(String celsiuis)
    {
        celsiuis=celsiuis.trim();
        float input=Float.parseFloat(celsiuis);
        float res=((input*9)/5)+32;
        return String.valueOf(res);
    }
}
