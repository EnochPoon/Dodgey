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
    private static Data d;
    
    public Menu(){    
        super(800, 600, 1);
        d = new Data();
        prepare();
    }
    
    void prepare(){
        addObject(new Title(), getWidth()/2, 50);
        addObject(new StartButton(), getWidth()/2, 200);
        //addObject(new ShopButton(), 150, getHeight() - 50);
        addObject(new DataReset(), 450, getHeight() - 50);
        addObject(new BlackFader(), getWidth()/2, getHeight()/2);
    }
}
