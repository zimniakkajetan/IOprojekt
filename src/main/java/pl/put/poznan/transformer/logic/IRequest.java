package pl.put.poznan.transformer.logic;

public interface IRequest {
    /**
     * Method that returns class capable of fulfilling user's request
     * if such a class is implemented
     * @param requestName String: The name of user's request
     * @param data String[]: Data sent by the user
     * @return IRequest: class that answers user's request
     */
    public static IRequest getRequest(String requestName, String[] data){
        if(requestName.equals("policzkroki") && !data[0].equals("__GET__"))
            return new CountStepsRequest();
        return new NoRequest(requestName);
    }
    public String run(String[] input);
}
