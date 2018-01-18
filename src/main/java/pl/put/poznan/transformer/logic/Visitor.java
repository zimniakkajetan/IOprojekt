package pl.put.poznan.transformer.logic;


public interface Visitor<T> {
    public void visitGeneratorNode(T node);
    public void visitStepNode(T node);
    public void visitScenarioNode(T node);
}
