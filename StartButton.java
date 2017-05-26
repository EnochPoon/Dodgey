import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class StartButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartButton extends Actor
{
    public StartButton(){
        setImage(new GreenfootImage("Click here to begin", 50, Color.RED, Color.BLACK));
    }
    /**
     * Act - do whatever the StartButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.mouseClicked(this)){
            getWorld().addObject(new Fader(new TheWorld()), getWorld().getWidth()/2, getWorld().getHeight()/2);
        }
    }    
}
