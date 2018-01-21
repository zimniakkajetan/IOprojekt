package pl.put.poznan.transformer.logic;

/**
 * This class is returned by IRequest.getRequest when
 * the the client requests amount of steps sent.
 */
public class HolefindingRequest implements IRequest{
    /**
     * Returns name of request that this class is fulfilling
     * @return String: "policzkroki"
     */
    public String getName() {
        return "poprawnosc";
    }
    /**
     * Returns answer of server when client wants to get amount of steps sent.
     * @param input Is the list of steps sent by the client
     * @return JSON formated response
     */
    @Override
    public String run(IStep input) {
        HolefindingVisitor v = new HolefindingVisitor();
        input.accept(v);
        if(v.getLegitness()){
            return "\"Poprawny scenariusz\"";
        }
        return "\"Niepoprawny scenariusz\"";
    }
}
