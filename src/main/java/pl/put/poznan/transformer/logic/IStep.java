package pl.put.poznan.transformer.logic;


import java.util.LinkedList;
import java.util.List;

public abstract class IStep {
    public abstract int amount();
    public abstract String display();
    public abstract List<IStep> getSubsteps();
    public abstract String getName();
    public abstract void  addSubstep(IStep step);
    public abstract int depth();
    public abstract void accept(Visitor<IStep> v);

    public static char tab(){return '>';}

    void generate(List<String> scenario){
        List<String> sublist = null;
        String overstepName = null;
        for(String stepName : scenario){
            if(stepName.charAt(0)!=IStep.tab()){
                if(sublist != null){
                    getSubsteps().add(new Step(sublist, overstepName, this.depth() + 1));
                }
                overstepName = stepName;
                sublist = new LinkedList<>();
            }
            else{
                if(sublist == null){
                    sublist = new LinkedList<>();
                    //overstepName == null jeżeli krok przeskoczony
                }
                sublist.add(stepName.substring(1));
            }
        }
        getSubsteps().add(new Step(sublist, overstepName, this.depth() + 1));
    }
}
