import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Button to start the game.
 * Appears only in Menu world
 * 
 * @author E Poon
 */
public class StartButton extends Actor
{
    public StartButton(){
        setImage(new GreenfootImage("Click here to begin", 50, Color.RED, Color.BLACK));
    }
    /**
     * Act - do whatever the StartButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.mouseClicked(this)){
            getWorld().addObject(new BlackFader(new TheWorld()), getWorld().getWidth()/2, getWorld().getHeight()/2);
        }
    }    
}
