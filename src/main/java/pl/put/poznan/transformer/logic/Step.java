package pl.put.poznan.transformer.logic;

import java.util.LinkedList;
import java.util.List;

public class Step extends IStep {
    Step(List<String> scenario, String name, int depth){
        substeps = new LinkedList<>();
        this.name = name;
        this.depth = depth;
        generate(scenario);
    }
    Step(String name, int depth){
        substeps = new LinkedList<>();
        this.name = name;
        this.depth=depth;
    }
    List<IStep> substeps;
    String name;
    int depth;
    @Override
    public int amount() {
        int ret = 1;
        for(IStep step : substeps){
            ret += step.amount();
        }
        return ret;
    }

    @Override
    public String display() {
        String ret = this.getName();
        if(name==null)ret="{null}";
        ret+= "\n";
        for(IStep step : substeps){
            ret +=  step.display() + "\n";
        }
        return ret;
    }

    @Override
    public List<IStep> getSubsteps() {
        return substeps;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void addSubstep(IStep step) {
        substeps.add(step);
    }

    @Override
    public int depth() {
        return this.depth;
    }

    @Override
    public void accept(Visitor<IStep> v) {
        v.visitGeneratorNode(this);
        for(IStep s :substeps){
            s.accept(v);
        }
        v.visitStepNode(this);
    }
    public static class TabError extends Error{}
}
