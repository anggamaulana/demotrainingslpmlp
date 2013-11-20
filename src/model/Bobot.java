/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 *
 
 */
public class Bobot {
    private Node nodeInput;
    private Node nodeTarget;
    private double  bobot;
    private String namaBobot;
    
    public Bobot(){
        bobot=BackPropagationUtil.getRandom(-1, 1);
        System.out.println("random "+getNamaBobot()+" "+bobot);
    }
    
    public Bobot(String nama){
        namaBobot=nama;
        bobot=BackPropagationUtil.getRandom(-1, 1);
        System.out.println("random "+getNamaBobot()+" "+bobot);
    }
    
    public Bobot(double bobot,String namaBobot){
        namaBobot=namaBobot;
        this.bobot=bobot;
    }
    public String getNamaBobot() {
        return namaBobot;
    }

    public void setNamaBobot(String namaBobot) {
        this.namaBobot = namaBobot;
    }
    
    public double  getBobot() {
        return bobot;
    }

    public void setBobot(double  bobot) {
        this.bobot = bobot;
    }

    public Node getNodeInput() {
        return nodeInput;
    }

    public void setNodeInput(Node nodeInput) {
        this.nodeInput = nodeInput;
    }

    public Node getNodeTarget() {
        return nodeTarget;
    }

    public void setNodeTarget(Node nodeTarget) {
        this.nodeTarget = nodeTarget;
    }
    
}
