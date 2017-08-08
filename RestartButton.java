import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RestartButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RestartButton extends FrontMessage
{
    public RestartButton(){
        setImage(new GreenfootImage("Click here to restart.", 40, Color.BLACK, Color.WHITE));
        getImage().setTransparency(100);
    }
    /**
     * Act - do whatever the RestartButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.mouseClicked(this)){
            getWorld().addObject(new Fader(new TheWorld()), getWorld().getWidth()/2, getWorld().getHeight()/2);
        }
    }    
}
