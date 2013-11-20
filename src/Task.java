
import java.util.TimerTask;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author angga
 */
public class Task extends TimerTask {

    private simulasi s;

    public Task(simulasi s) {
        this.s = s;
    }

        public void run() {



        int result;
        double x1w1, x2w2;

        this.s.setTxt_x1_or(String.valueOf(this.s.input[this.s.i][0]));
        this.s.setTxt_x2_or(String.valueOf(this.s.input[this.s.i][1]));
        x1w1 = this.s.w1_final * this.s.input[this.s.i][0];
        x2w2 = this.s.w2_final * this.s.input[this.s.i][1];
        result = (int) (x1w1 + x2w2);
        String process = "Hasil =" + this.s.w1_final + "*" + this.s.input[this.s.i][0] + "+" + this.s.w2_final + "*" + this.s.input[this.s.i][1] + "=" + result + "\n";
        this.s.setTxt_w1_or(String.valueOf(this.s.w1_final));
        this.s.setTxt_w2_or(String.valueOf(this.s.w2_final));

        this.s.setTxt_x1w1_or(String.valueOf(x1w1));
        this.s.setTxt_x2w2_or(String.valueOf(x2w2));
        this.s.setTxt_f_or(String.valueOf(result));
        //aktivasi
        if (result >= this.s.threshold) {
            result = 1;
        } else {
            result = 0;
        }
        this.s.setTxt_y_or(String.valueOf(result));
        //error
        this.s.error = this.s.target[this.s.i] - result;
        process += "Selisih dengan Target = " + this.s.target[this.s.i] + "-" + result + "=" + this.s.error + "\n";
        this.s.setTxt_error_or(String.valueOf(this.s.error));
        //menghitung error untuk perulangan
        if (this.s.error == 0) {
            this.s.errorcount--;
        }
        
        //update weight
        process += "w1=" + this.s.w1_final + "+(" + this.s.alpha + "*" + this.s.error + "*" + this.s.input[this.s.i][0] + ")=";
        this.s.w1_final = this.s.w1_final + (this.s.alpha * this.s.error * this.s.input[this.s.i][0]);
        process += this.s.w1_final + "\n";

        process += "w2=" + this.s.w2_final + "+(" + this.s.alpha + "*" + this.s.error + "*" + this.s.input[this.s.i][1] + ")=";
        this.s.w2_final = this.s.w2_final + (this.s.alpha * this.s.error * this.s.input[this.s.i][1]);
        process += this.s.w2_final + "\n\n";

        this.s.i++;

        this.s.lbl_epoch.setText("Epoch ke- " + String.valueOf(this.s.epoch));

        if (this.s.i > 3) {
            this.s.maxLoop++;
            this.s.i = 0;
            if (this.s.errorcount <= 0) {
                this.s.getTraining_or().setEnabled(true);
                this.s.error = 0;
                this.s.errorcount = 4;
                this.s.maxLoop = 0;
                this.s.epoch = 1;
                this.s.i = 0;
                this.s.lbl_epoch.setText("Training Selesai");
                this.cancel();
            }

            this.s.errorcount = 4;
            this.s.epoch++;
        }

        if (this.s.maxLoop > 20) {

            this.s.getTraining_or().setEnabled(true);
            this.s.error = 0;
            this.s.errorcount = 0;
            this.s.maxLoop = 0;
            this.s.epoch = 1;
            this.s.i = 0;
            this.s.lbl_epoch.setText("Training Selesai");
            this.cancel();

        }
        System.out.println(process);

    }
}
