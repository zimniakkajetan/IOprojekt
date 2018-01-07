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

    @Test
    public void requestNameGETScenarioIRequest(){
        String[] scenario = {"__GET__"};
        String requestName = "policzkroki";
        String response, expected;

        expected = new NoRequest(requestName).getName();
        response = IRequest.getRequest(requestName,scenario).getName();
        Assert.assertEquals(expected,response);
    }

    @Test // chyba nieprzydatne - powinno zwracac null, wazniejsza kwestia czy obiekt wyzej nie wysyla nulla - do pozniejszych testow
    public void nullInputArrToStringJson(){
        String[] input = null;
        ArrToStringJson arrToStringJson = new ArrToStringJson();
        Assert.assertNotNull(arrToStringJson.wrapper(input));
    }

    @Test
    public void emptyInputArrToStringJson(){
        String[] input = {};
        ArrToStringJson arrToStringJson = new ArrToStringJson();
        Assert.assertNotNull(arrToStringJson.wrapper(input));
    }

    @Test
    public void properConversionArrToStringJSonClass(){
        String[] input = {"abc", "efg"};
        String expected;
        String actual;

        Gson gson = new Gson();
        expected = gson.toJson(input);
        actual = ArrToStringJson.wrapper(input);
        //System.out.println(actual.charAt(9));
        //System.out.println(expected.charAt(9));
        Assert.assertEquals(expected,actual); // Stringi nie sa rowne - oba konwertery dzialaja prawidlowo czy nie?
    }
}
