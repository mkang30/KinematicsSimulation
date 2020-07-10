//Importing packages needed in the class
import greenfoot.*;  
import java.util.*;
//Inheritting from the greenfoot class World
public class Simulation extends World
{
    //Defining and instantiating constant variables
    public static final int BOXX = 450;
    public static final int BOXY = 250;
    //Defining instance variables
    private PlainImage rectangle;
    private Button goBack;
    private Button goNext;
    private PlainText velGraph;
    private PlainText angGraph;
    private Arrow arrow;
    private Ball ball;
    private Config config;
    private Map<String, Double> dictionary;//Usage of a disctionary
    private int[][] sizes;
    //The constructor takes an object of the dictionary data type as an argument to hold the values inputted by the user
    public Simulation(Map<String, Double> dictionary)
    {    
        //Using the constrcutor of the superclass to form a display of a scene
        super(900, 500, 1);
        setBackground("background.jpg");
        //Initialization of the object of Class Config that containts data of the flight
        config = new Config(dictionary);
        //Initializing and adding to the world the buttons and design objects
        rectangle = new PlainImage(new GreenfootImage("rectangle.jpg"),200,200);
        goBack = new Button("configuration", "Back", Start.SIM, new GreenfootImage("button.png"));
        goNext = new Button("postsimulation", "Graph", dictionary, Start.SIM, new GreenfootImage("button.png"));
        addObject(goBack,100,50);
        addObject(goNext,800,50);
        addObject(rectangle, BOXX, BOXY);
        //Calling the function that sets up the ball and arrow objects
        setBall();
        setArrow();
        //Setting up the display of the velGraph and angGraph texts using the values of the object arrow
        this.sizes = arrow.getSizes();
        velGraph = new PlainText("velocity = "+sizes[0][2], 20, Color.BLACK, Postsimulation.NOCOLOR);
        angGraph = new PlainText("angle = "+(-sizes[0][1]), 20, Color.BLACK, Postsimulation.NOCOLOR);
        addObject(velGraph, BOXX, BOXY-80);
        addObject(angGraph, BOXX, BOXY+80);
    }
    //method used to set the object ball for the flight
    public void setBall(){
        ball = new Ball(this.config);
        addObject(ball, Config.XORIGIN, Config.YORIGIN);
    }
    public void setArrow(){
        arrow = new Arrow(this.config);
        addObject(arrow, BOXX, BOXY);
    }
    //Method inherited from the Greenfoot.Actor class that is constantly called by program
    public void act(){
        //Changing the text of velGraph and angGraph objects according to the current state of the flight
        if(ball.getCounter()<ball.getNumberOfTI()){
            velGraph.changeText("velocity = "+sizes[ball.getCounter()][2]);
            angGraph.changeText("angle = "+-sizes[ball.getCounter()][1]);
        }
    }
    
    
}
