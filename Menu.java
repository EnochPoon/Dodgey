import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Menu extends World
{

    /**
     * Constructor for objects of class Menu.
     * 
     */
    public Menu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        prepare();
    }
    
    void prepare(){
        addObject(new Title(), getWidth()/2, 50);
        addObject(new StartButton(), getWidth()/2, 200);
        addObject(new ShopButton(), 200, getHeight() - 50);
        addObject(new Fader(), getWidth()/2, getHeight()/2);
    }
}
