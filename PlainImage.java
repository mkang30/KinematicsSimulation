import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Board here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
//Class needed to enhance abstract modular structure
public class PlainImage extends Actor
{
    public PlainImage(GreenfootImage img, int x, int y){
        //Changes the size of the image and sets it to an object
        img.scale(x, y);
        setImage(img);
    }
}
