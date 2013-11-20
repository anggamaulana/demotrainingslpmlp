/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.Random;

/**
 *
 * @author fendi
 */
public class BackPropagationUtil {
    public static double getAmbang(){
        return 0.01;
    }
    public static double getRandom(double min, double max) {
        return new Random().nextDouble() * (max - min) + min;
    }

    public static double getAlpha(){
        return 0.5;
    }
    public static double getSigmoidBinnerFunction(double y_in){
        return (1/(1+Math.exp(-1*y_in)));
    }
    public static double getSigmoidBinerFunctionAbsen(double nilai){
        return (nilai*(1-nilai));
    }
    
    public static void writeBobot(Bobot b){
        //System.out.println(b.getNamaBobot()+" nilai: "+b.getBobot());
    }
}
