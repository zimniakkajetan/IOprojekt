package pl.put.poznan.transformer.logic;

import java.util.Arrays;

/**
 * Contains wrapper that transforms Array of String into
 * JSON formatted String
 */
public class ArrToStringJson extends Object {
    /**
     * Wrapper that transforms Array of String into
     * JSON formatted String
     */
    public static String wrapper(String[] input){
        for (int i = 0; i < input.length; i++) {
            input[i] = "\"" + input[i] + "\"";
        }
        return Arrays.toString(input);
    }
}
