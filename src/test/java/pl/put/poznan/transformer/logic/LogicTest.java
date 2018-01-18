package pl.put.poznan.transformer.logic;

import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LogicTest {

    @Test
    public void invalidRequestNameIRequestClass(){
        String[] scenario = {"abc","efg"};
        String expected = "unknownrequest";
        String response;

        response = IRequest.getRequest("",scenario).getName();
        Assert.assertEquals(expected,response);
        response = IRequest.getRequest("something",scenario).getName();
        Assert.assertEquals(expected,response);
    }


    @Test
    public void requestNameGETScenarioIRequest(){
        String[] scenario = {"__GET__"};
        String requestName = "policzkroki";
        String response, expected;

        expected = new NoRequest(requestName).getName();
        response = IRequest.getRequest(requestName,scenario).getName();
        Assert.assertEquals(expected,response);
    }


    @Test
    public void emptyInputArrToStringJson(){
        String[] input = {};
        ArrToStringJson arrToStringJson = new ArrToStringJson();
        Assert.assertNotNull(arrToStringJson.wrapper(input));
    }
}
