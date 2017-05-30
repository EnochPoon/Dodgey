import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.*;
/**
 * Front page
 * 
 * @author Enoch Poon
 * 
 */
public class Menu extends World
{
    static Data d;
    /**
     * Constructor for objects of class Menu.
     * 
     */
    public Menu(){    
        super(600, 400, 1);
        d = new Data();
        prepare();
    }
    
    void prepare(){
        addObject(new Title(), getWidth()/2, 50);
        addObject(new StartButton(), getWidth()/2, 200);
        addObject(new ShopButton(), 150, getHeight() - 50);
        addObject(new DataReset(), 450, getHeight() - 50);
        addObject(new Fader(), getWidth()/2, getHeight()/2);
    }
}
