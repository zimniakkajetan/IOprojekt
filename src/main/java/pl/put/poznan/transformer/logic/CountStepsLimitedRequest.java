package pl.put.poznan.transformer.logic;

import java.util.InputMismatchException;

public class CountStepsLimitedRequest implements IRequest{
    int depth;
    boolean init(String command) {
        String[] parts = command.split("_");
        if(parts.length!=2)return false;
        try {
            depth = Integer.parseInt(parts[1]);
        }catch (NumberFormatException e){
            return false;
        }
        return true;
    }
    public String getName() {
        return "policzkrokido_{int}";
    }
    /**
     * Returns answer of server when client wants to get amount of steps sent.
     * @param input Is the list of steps sent by the client
     * @return JSON formated response
     */
    @Override
    public String run(IStep input) {
        CountingLimitedVisitor cv = new CountingLimitedVisitor(depth);
        input.accept(cv);
        return "\"" + "Ilosc krokow o zaglebieniu do " + depth + " jest rowna "
                + Integer.toString(cv.getNumber()) + "\"";
    }
}
