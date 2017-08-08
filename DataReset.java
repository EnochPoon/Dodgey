import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

import java.io.*;
/**
 * Write a description of class DataReset here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DataReset extends Actor
{
    public DataReset(){
        setImage(new GreenfootImage("Click here to reset all your data.\nWarning: resetting data cannot be undone", 20, Color.BLUE, Color.RED));
    }
    /**
     * Act - do whatever the DataReset wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.mouseClicked(this)){
            File f = new File("data.txt");
            if(f.exists())f.delete();
            getWorld().addObject(new Fader(new Menu()), getWorld().getWidth() / 2, getWorld().getHeight() / 2);
        }
    }    
}
