package model;

public class TargetNode extends Node{

    public TargetNode(double nilai) {
        super(nilai);
    }
    
    @Override
    public double getBias() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public double getError() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
