//Importing greenfoot package 
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
//Inheritting from the greenfoot class World
public class Start extends World
{
    //Constant variables are declared and instantiated
    public final static int GRAPH = 1;
    public final static int SIM = 0;
    //Instance variables are defined
    private Button toSim;
    private Button toGraph;
    private PlainText title;
    //The constructor
    public Start()
    {
        //Using the constrcutor of the superclass to form a display of a scene
        super(900, 500, 1);
        //Setting the background image
        setBackground("menuBack.jpg");
        //Instantiating text and button objects
        title = new PlainText("Kinematics Simulation", 40, Color.WHITE, Postsimulation.NOCOLOR);
        toGraph = new Button("configuration", "Graph", GRAPH, new GreenfootImage("button.png"));
        toSim = new Button("configuration", "Simulation", SIM, new GreenfootImage("button.png"));
        //Adding object into the display
        addObject(toSim, 450, 250);
        addObject(title, 450, 80);
        addObject(toGraph, 450, 300);
        
    }
}
