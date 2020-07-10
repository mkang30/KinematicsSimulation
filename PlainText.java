import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class PlainText here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlainText extends Actor
{
    /**
     * Act - do whatever the PlainText wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private String text;
    private int size = 20;
    private Color textColor = Color.WHITE;
    private Color backColor = Postsimulation.NOCOLOR;
    private GreenfootImage img;
    //Using overloading of the constructor
    public PlainText(String text, int size, Color textColor, Color backColor){
        this.text = text;
        this.size = size;
        this.textColor = textColor;
        this.backColor = backColor;
        draw();
    }
    public PlainText(String text){
        this.text = text;
        draw();
    }
    //Mutators and setters
    public void changeBackground(Color color){
        backColor = color;
        draw();
    }
    public void changeTextColor(Color color){
        textColor = color;
        draw();
    }
    public void changeText(String text){
        this.text = text;
        draw();
    }
    public void changeSize(int size){
        this.size = size;
        draw();
    }
    public String getText(){
        return text;
    }
    public int getSize(){
        return size;
    }
    public GreenfootImage getBackImg(){
        return img;
    }
    public void draw(){
        img = new GreenfootImage(text, size, textColor, backColor);
        setImage(img);
    }
}
