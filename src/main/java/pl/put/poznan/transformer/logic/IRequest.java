package pl.put.poznan.transformer.logic;

public interface IRequest {
    /**
     * Method that returns class capable of fulfilling user's request
     * if such a class is implemented
     * @param requestName String: The name of user's request
     * @param data String[]: Data sent by the user
     * @return IRequest: class that answers user's request
     */
    public static IRequest getRequest(String requestName, IStep data){
        boolean not_get = true;
        if(data.getSubsteps().size()==1){
            not_get = !data.getSubsteps().get(0).getName().equals("__GET__");
        }
        if(requestName.equals("policzkroki") && not_get)
            return new CountStepsRequest();
        if(requestName.equals(new HolefindingRequest().getName()) && not_get)
            return new HolefindingRequest();
        CountStepsLimitedRequest req = new CountStepsLimitedRequest();
        if(req.init(requestName) && not_get){
            return req;
        }

        return new NoRequest(requestName);
    }
    public String getName();
    public String run(IStep input);
}
