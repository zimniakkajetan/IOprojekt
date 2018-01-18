package pl.put.poznan.transformer.logic;

public class HolefindingVisitor implements Visitor<IStep> {
    private boolean legit = true;

    @Override
    public void visitGeneratorNode(IStep node) {
        return;
    }

    @Override
    public void visitStepNode(IStep node) {
        if(node.getName() == null){
            this.legit =false;
        }
    }

    @Override
    public void visitScenarioNode(IStep node) {
        return;
    }
    public boolean getLegitness(){return this.legit;}
}
