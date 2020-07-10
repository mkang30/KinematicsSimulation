import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Axis here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Line extends Actor
{
    public Line(int width, int length){
        draw(width, length);
    }
    //The function draws the line
    public void draw(int width, int length){
        GreenfootImage line = new GreenfootImage(width, length);
        line.setColor(Color.WHITE);
        line.fill();
        setImage(line);
    }
    
}
