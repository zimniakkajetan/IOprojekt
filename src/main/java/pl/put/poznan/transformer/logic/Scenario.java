package pl.put.poznan.transformer.logic;


import java.util.LinkedList;
import java.util.List;

public class Scenario extends IStep {
    List<IStep> substeps;
    @Override
    public int amount() {
        int ret = 0;
        for(IStep step : substeps){
            ret += step.amount();
        }
        return ret;
    }

    @Override
    public String display() {
        String ret = "";
        for(IStep step : substeps){
            ret += IStep.tab() + step.amount() + "\n";
        }
        return ret;
    }

    @Override
    public List<IStep> getSubsteps() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void addSubstep(IStep step) {
        substeps.add(step);
    }

    @Override
    public int depth() {
        return 0;
    }

    @Override
    public void accept(Visitor<IStep> v) {
        v.visitGeneratorNode(this);
        for(IStep s :substeps){
            s.accept(v);
        }
        v.visitScenarioNode(this);
    }
    Scenario(){
        substeps = new LinkedList<>();
    }
    Scenario(List<String> scenario){
        generate(scenario);
    }
}
