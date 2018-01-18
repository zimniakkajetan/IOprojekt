package pl.put.poznan.transformer.logic;

public class CountingLimitedVisitor implements Visitor<IStep> {
    private int number = 0;
    private int limit;
    public CountingLimitedVisitor(int limit){
        this.limit = limit;
    }

    @Override
    public void visitGeneratorNode(IStep node) {
        return;
    }

    @Override
    public void visitStepNode(IStep node) {
        if(node.getName() != null && node.depth() <= getLimit()){
            this.number += 1;
        }
    }

    @Override
    public void visitScenarioNode(IStep node) {
        return;
    }
    public int getNumber(){return this.number;}
    public int getLimit(){return this.limit;}
}
