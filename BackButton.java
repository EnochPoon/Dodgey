import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BackButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BackButton extends FrontMessage
{
    public BackButton(){
        setImage(new GreenfootImage("Click here to go back", 20, Color.BLACK, Color.WHITE));
        getImage().setTransparency(100);
    }
    /**
     * Act - do whatever the BackButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.mouseClicked(this)){
            getWorld().addObject(new Fader(new Menu()), getWorld().getWidth()/2, getWorld().getHeight()/2);
        }
    }    
}
