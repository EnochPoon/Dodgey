import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Restart round
 * 
 * @author Enoch Poon 
 * 
 */
public class RestartButton extends FrontMessage
{
    public RestartButton(){
        setImage(new GreenfootImage("Click here to restart.", 40, Color.BLACK, Color.WHITE));
        getImage().setTransparency(100);
    }
    
    public void act() 
    {
        if(Greenfoot.mouseClicked(this)){
            getWorld().addObject(new BlackFader(new TheWorld()), getWorld().getWidth()/2, getWorld().getHeight()/2);
        }
    }    
}
