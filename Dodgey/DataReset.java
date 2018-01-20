import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

import java.io.*;
/**
 * Resets all data
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
            try{
                PrintWriter fw = new PrintWriter("data.txt");
                fw.println("0 0");
                fw.close();
            }catch(Exception e){
                e.printStackTrace();
            }
            getWorld().addObject(new Fader(new Menu()), getWorld().getWidth() / 2, getWorld().getHeight() / 2);
        }
    }    
}
