//Importing greenfoot package 
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Ball here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
//Inheritting from the greenfoot class Actor
public class Ball extends Actor
{
    private Config config;
    private int[][] data;
    private int numberOfTI;
    private int i=0;
    public Ball(Config config){
        //Assigning values to instance variables
        this.config = config;
        this.data = config.getConvertedData();
        this.numberOfTI = config.getNumberOfTI();
    }
    //The method that changes the location of the object
    public void timeAdapt(){
        setLocation((int)data[this.i][0], (int)data[this.i][1]);
    }
    public void act() 
    {
        //Delaying the program
        if(i==0){
            Greenfoot.delay(35);
        }
        //Changing the location of the object
        if(i<numberOfTI){
            timeAdapt();
            i++;
        }
        //Making the object transperant when its location is outside the range of the screen 
        if(this.isAtEdge()){
            transperant(true);
        }
        else{
            transperant(false);
        }
    }
    //The function needed to make the object transperant
    public void transperant(boolean is){
        if(is == true){
            getImage().setTransparency(0);
        }
        else{
            getImage().setTransparency(255);
        }
    }
    //Getters and setters
    public Config getConfig(){
        return this.config;
    }
    public int getNumberOfTI(){
        return this.numberOfTI;
    }
    public int[][] getData(){
        return this.data;
    }
    public int getCounter(){
        return this.i;
    }
    public void setConfig(Config config){
        this.config = config;
        this.data = config.getConvertedData();
        this.numberOfTI = config.getNumberOfTI();
        this.i = 0;
    }
}
