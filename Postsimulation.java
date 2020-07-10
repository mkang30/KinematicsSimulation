//Importing greenfoot package 
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Postsimulation here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
//Inheritting from the greenfoot class World
public class Postsimulation extends World
{
    //Constant variables are declared and instantiated    
    public static final Color NOCOLOR = new Color(0,0,0,0);
    public static final int AXISLENGTH = 300;
    public static final int AXISWIDTH = 2;
    public static final int MARKERLENGTH = 30;
    //Instance variables are defined   
    public static final int MARKERWIDTH = 2;
    private ArrayList instances;
    private Config config;
    private Graph distances;
    private Map<String, Double> dictionary;
    private Button goMenu;
    private Button goSim;
    private Line yaxis;
    private Line xaxis;
    private Line[] ymarkers = new Line[2];
    private Line[] xmarkers = new Line[2];
    private PlainText ymarkerText;
    private PlainText xmarkerText;
    private FilledText[] graphSelection = new FilledText[4];
    private PlainText[] namesAxis = new PlainText[2];
    private PlainText[] dataLabel = new PlainText[3];
    private PlainText nameGraph;
    private int y = 0;
    private PlainImage board1;
    private PlainImage board2;
    private PlainText maxText;
    private PlainText minText;
    //The constructor takes a dictionary object to build diagrams and a type integer to distinguish the transition to the previous scene
    public Postsimulation(Map<String, Double> dictionary, int type)
    {
        super(900, 500, 1);
        setBackground("blackboard.jpg");
        this.dictionary = dictionary;
        //Instantiating and adding to the world board bojects
        board2 = new PlainImage(new GreenfootImage("box.png"), 180, 150);
        board1 = new PlainImage(new GreenfootImage("box.png"), 180, 150);
        addObject(board1, 120, 250);
        addObject(board2, 780, 250);
        //Instantiating and adding to the world the name of the graph
        nameGraph = new PlainText("Dependency of Horizontal Displacement on Time",20,Color.WHITE, NOCOLOR);
        addObject(nameGraph, 450, 70);
        //Instantiating and adding to the world the names of the axis
        namesAxis[0] = new PlainText("10 t(seconds)",15,Color.WHITE, NOCOLOR);
        namesAxis[1] = new PlainText("Sx(meters) 1000",15,Color.WHITE,NOCOLOR);
        addObject(namesAxis[0], 640,428);
        addObject(namesAxis[1], 230, 100);
        //Instantiating and adding to the world the text of divisers
        ymarkerText = new PlainText("500", 15,Color.WHITE, NOCOLOR);
        xmarkerText = new PlainText("5", 15,Color.WHITE, NOCOLOR);
        addObject(ymarkerText, 270, 250);
        addObject(xmarkerText, 450, 428);
        //Instantiating and adding to the world the lines of divisers
        for(int i = 0;i<2;i++){
            ymarkers[i] = new Line(MARKERLENGTH, MARKERWIDTH);
            xmarkers[i] = new Line(MARKERWIDTH, MARKERLENGTH);
            addObject(ymarkers[i], 300, 250-i*150);
            addObject(xmarkers[i], 450+i*150, 400);
        }
        //Instantiating and adding to the world the initial data/user input
        for(Map.Entry<String, Double> entry : dictionary.entrySet()){
            dataLabel[y] = new PlainText(entry.getKey()+" : "+entry.getValue(), 20, Color.WHITE, NOCOLOR);
            addObject(dataLabel[y], 120, 220+25*y);
            y++;
        }
        //Instantiating and adding lines of axes
        yaxis = new Line(AXISWIDTH, AXISLENGTH);
        xaxis = new Line(AXISLENGTH, AXISWIDTH);
        addObject(yaxis, 300, 250);
        addObject(xaxis, 450, 400);        
        //Instantiating and adding buttons
        goMenu = new Button("configuration", "Setttings", type, new GreenfootImage("button.png"));
        goSim = new Button("simulation", "Simulate", dictionary, new GreenfootImage("button.png"));
        addObject(goMenu, 100, 50);
        addObject(goSim, 800, 50);
        //Instantiating and adding graphs
        config = new Config(dictionary);        
        distances = new Graph(config.graphSX());
        addObject(distances, 450, 250);
        //Instantiating and adding graph selection buttons
        graphSelection[0] = new FilledText("Sx vs t", new GreenfootImage("button.png"));
        graphSelection[1] = new FilledText("Sy vs t", new GreenfootImage("button.png"));
        graphSelection[2] = new FilledText("Vx vs t", new GreenfootImage("button.png"));
        graphSelection[3] = new FilledText("Vy vs t", new GreenfootImage("button.png"));
        for(int i=0; i<4; i++){
            addObject(graphSelection[i], 230+i*150, 470);
        }
        ////Instantiating and adding minimum and maximum values text
        minText = new PlainText("min = "+String.format("%.1f",config.min(0,0)));
        maxText = new PlainText("max = "+String.format("%.1f",config.max(0,0)));
        addObject(minText, 780, 220);
        addObject(maxText, 780, 255);
    }
    public void act(){
        //Indicates user's selection of the graph and changes text elements and graph
        if(Greenfoot.mouseClicked(graphSelection[0])==true){
            namesAxis[1].changeText(("Sx(meters) 1000"));
            xaxis.setLocation(450,400);
            ymarkerText.changeText("500");
            changeGraph(this.config.graphSX());
            minText.changeText("min = "+String.format("%.1f",config.min(0,0)));
            maxText.changeText("max = "+String.format("%.1f",config.max(0,0)));
            nameGraph.changeText("Dependency of Horizontal Displacement on Time");
        }
        else if(Greenfoot.mouseClicked(graphSelection[1])==true){
            namesAxis[1].changeText(("Sy(meters) 1000"));
            xaxis.setLocation(450,400);
            ymarkerText.changeText("500");
            changeGraph(this.config.graphSY());
            minText.changeText("min = "+String.format("%.1f",config.min(0,1)));
            maxText.changeText("max = "+String.format("%.1f",config.max(0,1)));
            nameGraph.changeText("Dependency of Vertical Displacement on Time");
        }
        else if(Greenfoot.mouseClicked(graphSelection[2])==true){
            namesAxis[1].changeText(("Vx(m/s)   500"));
            xaxis.setLocation(450,400);
            ymarkerText.changeText("250");
            changeGraph(this.config.graphVX());
            minText.changeText("min = "+String.format("%.1f",config.min(1,0)));
            maxText.changeText("max = "+String.format("%.1f",config.max(1,0)));
            nameGraph.changeText("Dependency of Horizontal Velocity on Time");
        }
        else if(Greenfoot.mouseClicked(graphSelection[3])==true){
            namesAxis[1].changeText(("Vy(m/s)   500"));
            ymarkerText.changeText("75");
            changeGraph(this.config.graphVY());
            minText.changeText("min = "+String.format("%.1f",-config.max(1,1)));
            maxText.changeText("max = "+String.format("%.1f",config.max(1,1)));
            nameGraph.changeText("Dependency of Vertical Velocity on Time");
        }
    }
    //The function needed to change the graph
    public void changeGraph(double[][] graph){
        removeObject(distances);
        distances = new Graph(graph);
        addObject(distances, 450, 250);
    }
    
}
