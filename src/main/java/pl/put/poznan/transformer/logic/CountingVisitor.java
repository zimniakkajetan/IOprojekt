package pl.put.poznan.transformer.logic;

public class CountingVisitor implements Visitor<IStep> {
    private int number = 0;

    @Override
    public void visitGeneratorNode(IStep node) {
        return;
    }

    @Override
    public void visitStepNode(IStep node) {
        if(node.getName() != null){
            this.number += 1;
        }
    }

    @Override
    public void visitScenarioNode(IStep node) {
        return;
    }
    public int getNumber(){return this.number;}
}
