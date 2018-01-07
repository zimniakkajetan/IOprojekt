package pl.put.poznan.transformer.logic;

import org.junit.Assert;
import org.junit.Test;
import pl.put.poznan.transformer.logic.CountStepsRequest;
import pl.put.poznan.transformer.logic.IRequest;

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
    public void emptyScenarioCountStepsRequestClass(){
        String[] emptyScenario = {};
        String response, expected;

        response = IRequest.getRequest("policzkroki",emptyScenario).getName();
        expected = new CountStepsRequest().getName();
        Assert.assertEquals(expected,response);
    }

    /*@Test
    public void validCountCountStepsRequestClass(){
        CountStepsRequest countStepsRequest = new CountStepsRequest();

        Assert.assertEquals();
    }*/
}
