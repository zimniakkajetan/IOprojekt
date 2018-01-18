package pl.put.poznan.transformer.logic;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class VisitorsTest {

    @Test
    public void legitnessHolefindingVisitorTest(){
        HolefindingVisitor holefindingVisitor = new HolefindingVisitor();
        Step step = new Step("abc",5);

        holefindingVisitor.visitStepNode(step);
        boolean actual = holefindingVisitor.getLegitness();
        boolean expected = true;

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void nullNameLegitnessHolefindingVisitorTest(){
        HolefindingVisitor holefindingVisitor = new HolefindingVisitor();
        boolean expected = false;
        boolean actual;

        Step step = new Step(null,5);
        holefindingVisitor.visitStepNode(step);
        actual = holefindingVisitor.getLegitness();
        Assert.assertEquals(expected,actual);

        Scenario scenario = new Scenario();
        holefindingVisitor.visitStepNode(scenario);
        actual = holefindingVisitor.getLegitness();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void visitStepNodeCountingLimitedVisitorTest(){
        Step step1 = new Step("abc",5);
        Step step2 = new Step(null, 0);
        Step step3 = new Step("abc", 100);
        Scenario scenario = new Scenario();
        CountingLimitedVisitor countingLimitedVisitor = new CountingLimitedVisitor(5);
        Assert.assertEquals(5, countingLimitedVisitor.getLimit());

        int actual;
        int expected = 1;

        actual = countingLimitedVisitor.getNumber();
        Assert.assertEquals(0,actual);

        countingLimitedVisitor.visitStepNode(step1);
        actual = countingLimitedVisitor.getNumber();
        Assert.assertEquals(expected,actual);

        countingLimitedVisitor.visitStepNode(step2);
        actual = countingLimitedVisitor.getNumber();
        Assert.assertEquals(expected,actual);

        countingLimitedVisitor.visitStepNode(step3);
        actual = countingLimitedVisitor.getNumber();
        Assert.assertEquals(expected,actual);

        countingLimitedVisitor.visitStepNode(scenario);
        actual = countingLimitedVisitor.getNumber();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void visitStepNodeCountingVisitorTest(){
        Step step1 = new Step("abc",5);
        Step step2 = new Step(null, 0);
        Step step3 = new Step("abc", 100);
        Scenario scenario = new Scenario();
        CountingVisitor countingVisitor = new CountingVisitor();

        int actual;
        int expected = 1;

        actual = countingVisitor.getNumber();
        Assert.assertEquals(0,actual);

        countingVisitor.visitStepNode(step1);
        actual = countingVisitor.getNumber();
        Assert.assertEquals(expected,actual);

        countingVisitor.visitStepNode(step2);
        actual = countingVisitor.getNumber();
        Assert.assertEquals(expected,actual);

        countingVisitor.visitStepNode(step3);
        actual = countingVisitor.getNumber();
        expected += 1;
        Assert.assertEquals(expected,actual);

        countingVisitor.visitStepNode(scenario);
        actual = countingVisitor.getNumber();
        Assert.assertEquals(expected,actual);

    }

}
