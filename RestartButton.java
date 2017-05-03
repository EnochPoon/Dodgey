import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class RestartButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RestartButton extends Actor
{
    public RestartButton(){
        setImage(new GreenfootImage("Click here to restart.", 40, Color.BLACK, Color.WHITE));
    }
    /**
     * Act - do whatever the RestartButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(isTouching(Player.class)){
            setLocation(getX(), getWorld().getHeight() - 50);
        }
        if(Greenfoot.mouseClicked(this)){
            Greenfoot.setWorld(new TheWorld());
        }
    }    
}
