
import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;
import model.Bobot;
import model.HiddenNode;
import model.InputNode;
import model.OutputNode;
import model.TargetNode;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author angga
 */
public class Task2 extends TimerTask {
    
    private simulasi s;
    
    public Task2(simulasi s){
        this.s=s;
    }

    @Override
    public void run() {
        if(this.s.status){
            this.cancel();
        }
        
        this.s.status = true;
        
       //inisialisasi pasangan input
                for (int i = 0; i < this.s.inputArray[this.s.in].length; i++) {
                    this.s.inputnode.get(i).setNilai(this.s.inputArray[this.s.in][i]);
                }
                //inisialisasi pasangan target
                for (int i = 0; i < this.s.targetArray[this.s.in].length; i++) {
                    this.s.targetnode.get(i).setNilai(this.s.targetArray[this.s.in][i]);
                }

                //menghitung sinyal output dari layer input ke hidden layer
                for (int i = 0; i < this.s.hidden.size(); i++) {
                    this.s.hidden.get(i).aktivasi();
                }
                //menghitung sinyal output dari hidden layer ke output layer
                for (int i = 0; i < this.s.output.size(); i++) {
                    this.s.output.get(i).aktivasi();
                }
               int a = 0;
                //====================================================================
                //pasang status kondisi
                while (this.s.status && a < this.s.output.size()) {
//                    status=output.get(a++).tesNilaiAmbang();
                    if (!this.s.output.get(a++).tesNilaiAmbang(this.s.in)) {
                        this.s.status = false;
                    }
                }

                //hitung error di lapisan output
                for (int i = 0; i < this.s.output.size(); i++) {
                    this.s.output.get(i).hitungError();
                    //System.err.println("error output :"+output.get(i).getError());
                }
                //update bobot Wk
                for (int i = 0; i < this.s.output.size(); i++) {
                    this.s.output.get(i).updateBobotIn();
                }
                //hitung error di lapisan hidden
                for (int i = 0; i < this.s.hidden.size(); i++) {
                    this.s.hidden.get(i).hitungError();
                    //System.err.println("error input :"+hidden.get(i).getError());
                }
                //update bobot Vk
                for (int i = 0; i < this.s.hidden.size(); i++) {
                    this.s.hidden.get(i).updateBobotIn();
                }
                
                this.s.txt_x1_xor.setText(String.valueOf(this.s.inputArray[this.s.in][0]));
                this.s.txt_x2_xor.setText(String.valueOf(this.s.inputArray[this.s.in][0]));
                this.s.txt_w11_xor.setText(String.valueOf(this.s.bobotHide.get(0).getBobot()));
                this.s.txt_w12_xor.setText(String.valueOf(this.s.bobotHide.get(1).getBobot()));
                this.s.txt_w21_xor.setText(String.valueOf(this.s.bobotHide.get(2).getBobot()));
                this.s.txt_w22_xor.setText(String.valueOf(this.s.bobotHide.get(3).getBobot()));
                this.s.txt_h1_xor.setText(String.valueOf(this.s.hidden.get(0).getNilai()));
                this.s.txt_h2_xor.setText(String.valueOf(this.s.hidden.get(1).getNilai()));
                this.s.txt_w31_xor.setText(String.valueOf(this.s.bobotOut.get(0).getBobot()));
                this.s.txt_w32_xor.setText(String.valueOf(this.s.bobotOut.get(1).getBobot()));
                this.s.txt_out_xor.setText(String.valueOf(this.s.output.get(0).getNilai()));
                this.s.txt_error_xor.setText(String.valueOf(this.s.output.get(0).getError()));
                this.s.txt_target_xor.setText(String.valueOf(this.s.targetArray[this.s.in][0]));
               
                
                this.s.in++;
                
                if(this.s.in>this.s.targetArray.length-1){
                    this.s.in=0;
                }
        
        
    }
    
}
