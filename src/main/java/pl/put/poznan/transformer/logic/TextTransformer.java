package pl.put.poznan.transformer.logic;

import java.util.Arrays;

/**
 * This the class that manages server's answers
 */
public class TextTransformer {
    private final String[] scenariusz;

    /**
     * Prepares server to respond by storing user input in object.
     * @param scenariusz
     */
    public TextTransformer(String[] scenariusz){
        this.scenariusz = scenariusz;
    }

    /**
     * This class returns server's response
     * @param command String: User's request
     * @return JSON formatted String
     */
    public String transform(String command){
        IStep steps = new Scenario(Arrays.asList(scenariusz));
        String display = steps.display();
        System.out.println(display);
        String ans = IRequest.getRequest(command, steps).run(steps);
        return "{ \"scenario\" : " + ArrToStringJson.wrapper(scenariusz) + ", \"response\" : " + ans + "}";
    }
}
