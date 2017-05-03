import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class Flash here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Flash extends Actor
{
    int tp = 255;
    public Flash(){
        getImage().setColor(Color.WHITE);
        getImage().fill();
        getImage().setTransparency(0);
    }

    /**
     * Act - do whatever the Flash wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        getImage().scale(getWorld().getWidth() + 10, getWorld().getHeight() + 10);
        getImage().setTransparency(tp);
        tp -= 5;
        if(tp == 0){
            getWorld().addObject(new RestartButton(), 400, 50);
            getWorld().removeObject(this);
        }

    }    
}
