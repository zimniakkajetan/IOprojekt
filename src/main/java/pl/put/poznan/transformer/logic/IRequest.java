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
        boolean not_get = true;
            if(data.length==1){
                not_get = !data[0].equals("_GET_");
        }
        if(requestName.equals("policzkroki") && not_get)
            return new CountStepsRequest();
        return new NoRequest(requestName);
    }
    public String getName();
    public String run(String[] input);
}
