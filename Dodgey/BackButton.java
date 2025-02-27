import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Click to go back to the Main Menu
 * 
 * @author Enoch Poon
 *
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
            getWorld().addObject(new BlackFader(new Menu()), getWorld().getWidth()/2, getWorld().getHeight()/2);
        }
    }    
}
