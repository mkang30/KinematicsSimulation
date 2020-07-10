import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Arrow here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
//Inheritting from the class Ball
public class Arrow extends Ball
{
    public final static int LENGTH = 100;
    public final static int WIDTH = 20;
    private double[][][] realData;
    private GreenfootImage img;
    private int[][] sizeData;
    public Arrow(Config config){
        super(config);
        this.realData = config.getRealData();
        img = new GreenfootImage("arrow.png");
        sizeData = genSizes(config.getDict().get("velocity"), config.getDict().get("angle"));
        setImage(img);
        setRotation(-(int)Math.toDegrees(Math.atan(realData[0][1][1]/realData[0][1][0])));
    }
    //Using overriding to make this method change the rotation of the object and size
    public void timeAdapt(){
        img = new GreenfootImage("arrow.png");
        img.scale(this.sizeData[getCounter()][0], WIDTH);
        setImage(img);
        setRotation(this.sizeData[getCounter()][1]);

    }
    //Calculating the sizes and angles of the object according to the velocity of the flight
    public int[][] genSizes(double initialVel, double initialAng){
        int[][] sizes = new int[getNumberOfTI()][3];
        sizes[0][0] = LENGTH;
        sizes[0][1] = -(int)initialAng;
        sizes[0][2] = (int)initialVel;
        //Iterating over the data and using the Math library to calculate the angles and sizes
        for(int k = 1; k<getNumberOfTI()-1; k++){
            sizes[k][2] = (int)Math.sqrt(Math.pow(realData[k][1][1], 2)+Math.pow(realData[k][1][0], 2));
            if((int)(sizes[k][2]*LENGTH/initialVel)==0){
                sizes[k][0] = 1;
            }
            else{
                sizes[k][0] = (int)(Math.sqrt(Math.pow(realData[k][1][1], 2)+Math.pow(realData[k][1][0], 2))*LENGTH/initialVel);
            }
            if(-(int)Math.toDegrees(Math.atan(realData[k][1][1]/realData[k][1][0]))==90){
                sizes[k][1] = 90;
            }
            else{
                sizes[k][1] = -(int)Math.toDegrees(Math.atan(realData[k][1][1]/realData[k][1][0]));
            }
            
        }
        //Manually modifying the last elements of the array to eliminate uncertainties of calculation
        if(getNumberOfTI()!=1){
            sizes[getNumberOfTI()-1][0] = LENGTH;
            sizes[getNumberOfTI()-1][1] = (int)initialAng;
            sizes[getNumberOfTI()-1][2] = (int)initialVel;
        }
        return sizes;
    }
    //Getter for sizes array variable
    public int[][] getSizes(){
        return this.sizeData;
    }
    
}
