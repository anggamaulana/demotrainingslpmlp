/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 *
 */
public class InputNode extends Node{

    public InputNode(double nilai) {
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
