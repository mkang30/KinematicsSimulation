 /**
 * Write a description of class Instance here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import greenfoot.*;
import java.util.*;
public class Config  
{
    public static final double TIME = 0.1;
    public static final int XORIGIN = 30;
    public static final int YORIGIN = 480;
    private double[][][] realData;
    private int[][] convertedData;
    private int numberOfTI;
    private double totalTime;
    private Map<String, Double> dictionary;
    public Config(Map<String, Double> dictionary)
    {
        this.dictionary = dictionary;
        this.realData = genRealData(dictionary.get("angle"), dictionary.get("velocity"), dictionary.get("gravity"));
        this.convertedData = genConvertedData();
    }
    public Map<String, Double> getDict(){
        return this.dictionary;
    }
    public double getTotalTime(){
        return totalTime;
    }
    public int getNumberOfTI(){
        return numberOfTI;
    }
    public double[][][] getRealData(){
        return this.realData;
    }
    public int[][] getConvertedData(){
        return this.convertedData;
    }
    public double[][][] genRealData(double angle, double v, double gravity){
        
        angle = Math.toRadians(angle);
        double vy = Math.sin(angle)*v;
        double vx = Math.cos(angle)*v;
        double sy = 0;
        double sx = 0;
        totalTime = (2*vy/gravity);
        numberOfTI = (int)(totalTime/TIME+1);
        double[][][] resultant = new double[numberOfTI][2][2];
        resultant[0][0][0] = sx;
        resultant[0][0][1] = sy;
        resultant[0][1][0] = vx;
        resultant[0][1][1] = vy;
        for(int i=1; i<numberOfTI; i++){
            sx += vx*TIME;
            sy += vy*TIME-0.5*gravity*Math.pow(TIME,2);
            vy = vy-gravity*TIME;
            resultant[i][0][0] = sx;
            resultant[i][0][1] = sy;
            resultant[i][1][0] = vx;
            resultant[i][1][1] = vy;
        }
        resultant[numberOfTI-1][0][1] = 0;
        
        return resultant;
    }
    public int[][] genConvertedData(){
        int[][] convertedData = new int[numberOfTI][2];
        for(int i = 0; i<numberOfTI; i++){
            for(int j = 0; j<2; j++){
                if(j==0){
                    convertedData[i][j] = (int)(realData[i][0][j]+XORIGIN);
                }
                else{
                    convertedData[i][j] = (int)(YORIGIN-realData[i][0][j]);
                }
            }
        }
        return convertedData;
    }
   
    public double[][] graphSX(){
        double[][] result = new double[this.numberOfTI][2];
        for(int i = 0; i < this.numberOfTI; i++){
            result[i][0] = 0.6*i;
            result[i][1] = 300-(realData[i][0][0])/1000*300;
        }
        return result;
    }
    public double[][] graphSY(){
        double[][] result = new double[this.numberOfTI][2];
        for(int i = 0; i < this.numberOfTI; i++){
            result[i][0] = 0.6*i;
            result[i][1] = 300-(realData[i][0][1])/1000*300;
        }
        return result;
    }
    public double[][] graphVX(){
        double[][] result = new double[this.numberOfTI][2];
        for(int i = 0; i < this.numberOfTI; i++){
            result[i][0] = 0.6*i;
            result[i][1] = 300-(realData[i][1][0])/500*300;
        }
        return result;
    }
    public double[][] graphVY(){
        double[][] result = new double[this.numberOfTI][2];
        for(int i = 0; i < this.numberOfTI; i++){
            result[i][0] = 0.6*i;
            result[i][1] = 300-(realData[i][1][1])/500*300;
        }
        return result;
    }
    public double max(int index1, int index2){
        int index = 0;
        double max = realData[0][index1][index2];
        for(int c = 1; c<numberOfTI; c++){
            if(realData[c][index1][index2]>max){
                index = c;
                max = realData[c][index1][index2];
            }
        }
        return max;
    }
    public double min(int index1, int index2){
        int index = 0;
        double min = realData[0][index1][index2];
        for(int c = 1; c<numberOfTI; c++){
            if(realData[c][index1][index2]<min){
                index = c;
                min = realData[c][index1][index2];
            }
        }
        return min;
    }

}
