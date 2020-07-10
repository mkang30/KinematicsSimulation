import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button extends FilledText
{
    /**
     * Act - do whatever the Button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private String to;
    private int type;
    private Map<String, Double> dictionary;
    //Overloading the constructor
    public Button(String to, String text, int size, Color color1, Color color2, int type,GreenfootImage img){
        super(text,size,color1,color2, img);
        this.to = to;
        this.type = type;
    }
    public Button(String to, String text, GreenfootImage img){
        super(text, img);
        this.to = to;
    }
    public Button(String to, String text, int type, GreenfootImage img){
        super(text, img);
        this.to = to;
        this.type = type;
    }
    public Button(String to, String text, Map<String, Double> dict, int type, GreenfootImage img){
        super(text, img);
        this.to = to;
        this.dictionary = dict;
        this.type = type;
    }
    public Button(String to, String text, Map<String, Double> dict, GreenfootImage img){
        super(text, img);
        this.to = to;
        this.dictionary = dict;
    }
    public void act() 
    {
        onclick();
    }
    public void onclick(){
        if(Greenfoot.mouseClicked(this)){
            //Indicating which transition should be conducted
            if(to.equals("configuration")){
                Greenfoot.setWorld(new Configuration(type));
            }
            else if(to.equals("start")){
                Greenfoot.setWorld(new Start());
            }
            else if(to.equals("simulation")){
                Greenfoot.setWorld(new Simulation(this.dictionary));
            }
            else if(to.equals("postsimulation")){
                Greenfoot.setWorld(new Postsimulation(this.dictionary, type));
            }
        }
       
    }
    //Mutators and setters
    public String getTo(){
        return to;
    }
    public Map<String, Double> getDict(){
        return this.dictionary;
    }
    public void setDict(Map<String, Double> dict){
        this.dictionary = dict;
    }
    public void setTo(String to){
        this.to = to;
    }
    
}
