package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class OutputNode extends Node{
    private Node nodeTarget;
    private double error;
    private double bias;
    private List<Bobot> bobotIn;
    private String namaNode;
    
    private static double getAlpha(){
        return 0.5;
    }
    
    private static double getAmbang(){
        return 0.15;
    }
    
    private static double getRandom(double min, double max) {
        return new Random().nextDouble() * (max - min) + min;
    }
    
    public OutputNode(double nilai) {
        super(nilai);
        bobotIn=new ArrayList<Bobot>();
        bias=BackPropagationUtil.getRandom(-1, 1);
    }
    public OutputNode(double nilai,String nama) {
        super(nilai);
        bobotIn=new ArrayList<Bobot>();
        bias=getRandom(-1, 1);
        namaNode=nama;
    }
    public List<Bobot> getBobotIn() {
        return bobotIn;
    }
    
    public void addBobotIn(Bobot in){
        bobotIn.add(in);
    }
    public String getNamaNode() {
        return namaNode;
    }

    public void setNamaNode(String namaNode) {
        this.namaNode = namaNode;
    }

    public Node getNodeTarget() {
        return nodeTarget;
    }

    public void setNodeTarget(Node nodeTarget) {
        this.nodeTarget = nodeTarget;
    }
    
    @Override
    public double getBias() {
       return bias;
    }

    @Override
    public double getError() {
        return error;
    }
    public boolean tesNilaiAmbang(int in){
        double e=Math.pow((nodeTarget.getNilai()-nilai), 2D);
        if(e<getAmbang()){
            return true;
        }else{ 
            System.err.println(in+" err "+e);
            return false;
        }
    }
    public void aktivasi(){
        if(bobotIn.size()>0){
            double y_in=bias;
            //menghitung sinyal output dari layer input
            for(int i=0;i<bobotIn.size();i++){
                y_in +=bobotIn.get(i).getBobot()*bobotIn.get(i).getNodeInput().getNilai();
            }
            //menggunakan fungsi aktivasi bipolar
            nilai=(1/(1+Math.exp(-1*y_in)));
        }else{
            System.err.println("Bobot belum di definisikan");
        }
    }
    
    public void hitungError(){
        error=(nodeTarget.getNilai()-nilai)*(nilai*(1-nilai));
    }
    //yang diupdate adalah bobotInput
    public void updateBobotIn(){
        double deltaWjk;
        for(int i=0;i<bobotIn.size();i++){
            deltaWjk=getAlpha()*error*this.bobotIn.get(i).getNodeInput().getNilai();
            //update bobot
            bobotIn.get(i).setBobot(bobotIn.get(i).getBobot()+deltaWjk);
        }
        bias=error*getAlpha();
    }
    
}
