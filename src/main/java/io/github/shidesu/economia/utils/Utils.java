package io.github.shidesu.economia.utils;

/**
 * Created by Alexandre on 04/03/2017.
 */
public class Utils {

    public static boolean isInt(String s){
        try{
            Integer.parseInt(s);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }

    public static int getParseInt(String s){
        try{
            int parseInt = Integer.parseInt(s);
            return parseInt;
        }catch(NumberFormatException e){

        }
    }

}
