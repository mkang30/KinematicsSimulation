import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Graph here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Graph extends Actor
{
    public static final int GRAPHNUMBER = 0;
    public static final int SIMNUMBER = 1;
    private double[] x;
    private double[] y;
    public Graph(double[][] list){
        x = new double[list.length];
        y = new double [list.length];
        for(int i = 0;i< list.length; i++){
            x[i] = (int)list[i][0];
            y[i] = (int)list[i][1];
        }
        makeImage();
    }
    public void makeImage()
    {
        
        GreenfootImage img = new GreenfootImage(300, 300);
        //Iterating over the data to create a graph using it/ drawing the line by connecting each point
        for(int i = 1; i < x.length; i++)
        {
            img.setColor(Color.YELLOW);
            img.drawLine(
                (int)((x[i-1])), (int)(y[i-1]),
                (int)((x[i])), (int)(y[i]));
        }
        setImage(img);
    }
}
