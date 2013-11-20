package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HiddenNode extends Node{

    private static double getAlpha(){
        return 0.5;
    }
    
    private static double getRandom(double min, double max) {
        return new Random().nextDouble() * (max - min) + min;
    }
    
    private double bias;
    private double error;
    private List<Bobot> bobotIn;
    private List<Bobot> bobotOut;
    private String namaNode;
    
    
    public HiddenNode(double nilai) {
        super(nilai);
        bobotIn=new ArrayList<Bobot>();
        bobotOut=new ArrayList<Bobot>();
       bias=getRandom(-1, 1);
    }
    public HiddenNode(double nilai,String namaNode) {
        super(nilai);
        this.namaNode=namaNode;
        bobotIn=new ArrayList<Bobot>();
        bobotOut=new ArrayList<Bobot>();
        bias=getRandom(-1, 1);
    }

    public void addBobotIn(Bobot in){
        bobotIn.add(in);
    }
    
    public List<Bobot> getBobotIn() {
        return bobotIn;
    }

    public void addBobotOut(Bobot out){
        bobotOut.add(out);
    }
    
    public List<Bobot> getBobotOut() {
        return bobotOut;
    }

    public String getNamaNode() {
        return namaNode;
    }

    public void setNamaNode(String namaNode) {
        this.namaNode = namaNode;
    }
    
    
    @Override
    public double getBias() {
        return bias;
    }

    @Override
    public double getError() {
        return error;
    }
    
    public void aktivasi(){
        if(bobotIn.size()>0){
            double y_in=bias;
            //menghitung sinyal output dari layer input
            for(int i=0;i<bobotIn.size();i++){
                y_in +=bobotIn.get(i).getBobot()*bobotIn.get(i).getNodeInput().getNilai();
            }
            nilai=(1/(1+Math.exp(-1*y_in)));
        }else{
            System.err.println("Bobot belum di definisikan");
        }
    }
    
    public void hitungError(){
        double sigma=0;
        for(int i=0;i<bobotOut.size();i++){
            sigma +=bobotOut.get(i).getNodeTarget().getError()*bobotOut.get(i).getBobot();
        }
        error=sigma*(nilai*(1-nilai));
    }
    
    public void updateBobotIn(){
        double deltaVij=0;
        for(int i=0;i<bobotIn.size();i++){
            deltaVij=getAlpha()*error*bobotIn.get(i).getNodeInput().getNilai();
            //update bobot
            bobotIn.get(i).setBobot(deltaVij+bobotIn.get(i).getBobot());
            
            BackPropagationUtil.writeBobot(bobotIn.get(i));
        }
        bias=error*getAlpha();
    }
    
}
