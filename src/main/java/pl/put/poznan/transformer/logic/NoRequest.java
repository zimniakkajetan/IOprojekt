package pl.put.poznan.transformer.logic;

/**
 * This class is returned by IRequest.getRequest when the given command is not implemented
 */

public class NoRequest implements IRequest {
    public NoRequest(String requestname){
        this.requestname=requestname;
    }
    /**
     * Returns name of request that this class is fulfilling
     * @return String: "unknownrequest"
     */
    public String getName(){return "unknownrequest";}

    /**
     * Returns answer of server when there is no method matching sent request
     * @param input Is the list of steps sent by the client
     * @return JSON formatted response
     */
    @Override
    public String run(String[] input) {
        return "\"Method not found for request " + requestname + "\"";
    }
    private String requestname;
}
