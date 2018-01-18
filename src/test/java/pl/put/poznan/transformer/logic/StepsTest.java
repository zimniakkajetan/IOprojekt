package pl.put.poznan.transformer.logic;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class StepsTest {
    @Test
    public void stepInitializationTest(){
        String stepName = "abc";
        int depth = 5;

        Step step = new Step(stepName,depth);
        Assert.assertEquals(stepName,step.getName());
        Assert.assertEquals(depth, step.depth());

        Scenario scenario = new Scenario();
        Assert.assertEquals(null,scenario.getName());
        Assert.assertEquals(null,scenario.getSubsteps());
        Assert.assertEquals(0,scenario.depth());
    }

    @Test
    public void substepsStepsTest(){
        Step mainStep = new Step("ajjj",10);

        Step substep1 = new Step("abc",5);
        Step substep2 = new Step("ijk",2);
        Scenario scenario = new Scenario();

        List<IStep> expectedSubsteps = new ArrayList<>();

        mainStep.addSubstep(substep1);
        expectedSubsteps.add(substep1);
        Assert.assertEquals(expectedSubsteps,mainStep.getSubsteps());

        mainStep.addSubstep(substep2);
        expectedSubsteps.add(substep2);
        Assert.assertEquals(expectedSubsteps,mainStep.getSubsteps());

        mainStep.addSubstep(null);
        expectedSubsteps.add(null);
        Assert.assertEquals(expectedSubsteps,mainStep.getSubsteps());

        mainStep.addSubstep(scenario);
        expectedSubsteps.add(scenario);
        Assert.assertEquals(expectedSubsteps,mainStep.getSubsteps());
    }
}
