//importing packages needed for the class
import greenfoot.*; 
import java.util.*;
import java.lang.*;
import javax.swing.JOptionPane;
//Inheritting from the greenfoot class World
public class Configuration extends World
{  
    //Constant variables are declared and instantiated    
    public static final double START_VEL = 0;
    public static final double START_ANG = 1.0;
    public static final double START_GRA = 9.8;  
    //Instance variables are declared
    private Map<String, Double> dictionary = new HashMap<String, Double>();
    private Button launch;
    private Button toStart;
    private PlainText textVel;
    private PlainText textAng;
    private PlainText textGra;
    private PlainText title;
    private FilledText velocity;
    private FilledText angle;
    private FilledText gravity;
    private String written;
    //The constructor takes an integer value as an argument to determine the transition to the next scene
    public Configuration(int type)
    {
        //Using the constrcutor of the superclass to form a display of a scene        
        super(900, 500, 1);
        setBackground("background.jpg");
        //The default values are assigned to the entries of the dictionary
        dictionary.put("angle", START_ANG);
        dictionary.put("velocity", START_VEL);
        dictionary.put("gravity", START_GRA);
        //Determining whether the next transition is to Simulation scene or Postsimulation scene
        if(type == Start.SIM){
            launch = new Button("simulation", "Launch", this.dictionary, new GreenfootImage("button.png"));
        }
        else{
            launch = new Button("postsimulation", "Launch", this.dictionary, type, new GreenfootImage("button.png"));
        }
        //All the buttons and design objects are instantiated and added to the world
        toStart = new Button("start", "Back", new GreenfootImage("button.png"));
        textVel = new PlainText(Double.toString(START_VEL), 20, Color.BLACK, Color.WHITE);
        textAng = new PlainText(Double.toString(START_ANG), 20, Color.BLACK, Color.WHITE);
        textGra = new PlainText(Double.toString(START_GRA), 20, Color.BLACK, Color.WHITE);
        velocity = new FilledText("Velocity", 20, Color.BLACK, Postsimulation.NOCOLOR, new GreenfootImage("pinkBox.jpg"));
        angle = new FilledText("Angle", 20, Color.BLACK, Postsimulation.NOCOLOR, new GreenfootImage("pinkBox2.jpg"));
        gravity = new FilledText("Gravity", 20, Color.BLACK, Postsimulation.NOCOLOR, new GreenfootImage("pinkBox3.jpg"));
        title = new PlainText("Settings", 35, Color.BLACK, Postsimulation.NOCOLOR);
        addObject(title, 450, 130);
        addObject(toStart, 100, 50);
        addObject(launch, 800, 450);
        addObject(velocity, 450, 190);
        addObject(angle, 450, 260);
        addObject(gravity, 450, 330);
        addObject(textVel, 450, 220);
        addObject(textAng, 450, 290);
        addObject(textGra, 450, 360);

    }
    //The function is responsible for assigning new values into the dictionary whenver the user input changes
    public void putValue(double value, String key){
        this.dictionary.put(key, value);
        if(key.equals("velocity")){
            this.textVel.changeText(Double.toString(value));
        }
        else if(key.equals("angle")){
            this.textAng.changeText(Double.toString(value));
        }
        else if(key.equals("gravity")){
            this.textGra.changeText(Double.toString(value));
        }
    }
    //The act method constantly checks if the user clicked the input buttons or not
    public void act(){
        //When the user clicks one of input buttons the onClickInput() is called to display the input window
        if(Greenfoot.mouseClicked(velocity)||Greenfoot.mouseClicked(textVel)){
            onclickInput("Enter the value 0-500", "", "velocity", 0, 0, 500);
        }
        else if(Greenfoot.mouseClicked(angle)||Greenfoot.mouseClicked(textAng)){
            onclickInput("Enter the value 1-90", "", "angle", 1, 1, 90);
        }
        else if(Greenfoot.mouseClicked(gravity)||Greenfoot.mouseClicked(textGra)){
            onclickInput("Enter the value 1-50", "", "gravity", 9.8, 1, 50);
        }
    }
    //The method is responsible for the input windows and control of inputs made by the user
    public void onclickInput(String text, String error, String key, double value, double min, double max){
            double input = value;
            //Using the JOptionPane class from the external library to display the input window and take the input
            written = JOptionPane.showInputDialog(error+text);
            //Controlling extreme inputs / errors
            if(written==null){
                //This scenrio would be the base case where the recursion ends
                putValue(value, key);
            }
            else{
                try{
                    input = Double.parseDouble(written);
                    //Using the recursion to display the input window once more with warning in case the user makes an invalid input 
                    if(input<min||input>max){
                        onclickInput(text, " Unacceptable Value!", key, value, min, max);
                    }
                    else{
                        //This scenrio would be the base case where the recursion ends
                        putValue(input, key);
                    }
                }
                catch(NumberFormatException e){
                    onclickInput(text, "Unacceptable value! ", key, value, min, max);
                } 
            }          
    }
}
