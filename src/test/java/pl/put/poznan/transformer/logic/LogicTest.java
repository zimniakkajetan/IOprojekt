package pl.put.poznan.transformer.logic;

import org.junit.Assert;
import org.junit.Test;
import pl.put.poznan.transformer.logic.CountStepsRequest;
import pl.put.poznan.transformer.logic.IRequest;

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
    public void emptyScenarioCountStepsRequestClass(){
        String[] emptyScenario = {};
        String response, expected;

        response = IRequest.getRequest("policzkroki",emptyScenario).getName();
        expected = new CountStepsRequest().getName();
        Assert.assertEquals(expected,response);
    }

    

    @Test
    public void validCountCountStepsRequestClass(){
        CountStepsRequest countStepsRequest = new CountStepsRequest();
        String expected;
        List<String> scenarioList = new ArrayList<String>();

        for(int i = 1; i < 25; i++) {
            scenarioList.add("1");
            String[] scenario = new String[scenarioList.size()];
            scenario = scenarioList.toArray(scenario);

            expected = "\"" + "Ilosc krokow jest rowna " + Integer.toString(i) + "\"";
            Assert.assertEquals(expected, countStepsRequest.run(scenario));

        }
    }
}
