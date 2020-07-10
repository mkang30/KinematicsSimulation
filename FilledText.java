import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FilledText here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
//Inheritting from the class PlainText
public class FilledText extends PlainText
{
    /**
     * Act - do whatever the FilledText wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage backImg;
    //Overloading the constructor
    public FilledText(String text, int size, Color textColor, Color backColor, GreenfootImage img){
        super(text,size,textColor,backColor);
        backImg = img;
        drawBack();
    }
    public FilledText(String text, GreenfootImage img){
        super(text);
        backImg = img;
        drawBack();
    }
    //Drawing the image on image
    public void drawBack(){
        backImg.drawImage(getBackImg(),
        (int)backImg.getWidth()/2-10*getText().length()/2, 
        (int)(0.3*backImg.getHeight()));
        setImage(backImg);
    }
    public void changeContain(String text){
        changeText(text);
        drawBack();
    }
}
