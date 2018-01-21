package pl.put.poznan.transformer.logic;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CountStepsTest {
    @Test
    public void emptyScenarioCountStepsRequestClass(){
        String[] emptyScenario = {};
        String response, expected;

        response = IRequest.getRequest("policzkroki",new Scenario(emptyScenario)).getName();
        expected = new CountStepsRequest().getName();
        Assert.assertEquals(expected,response);

        String strResponse = new CountStepsRequest().run(new Scenario(emptyScenario));
        String strExpected = "\"" + "Ilosc krokow jest rowna " + Integer.toString(0) + "\"";
        Assert.assertEquals(strExpected, strResponse);
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
            Assert.assertEquals(expected, countStepsRequest.run(new Scenario(scenario)));

        }
    }

}
