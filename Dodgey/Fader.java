import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Fader here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fader extends Actor
{
    private boolean fadeIn;
    private World next;
    public Fader(){
        getImage().setColor(Color.BLACK);
        getImage().fill();
        getImage().scale(1000, 1000);
        fadeIn = false;
        getImage().setTransparency(250);
    }
    public Fader(World next){
        getImage().scale(1000, 1000);
        fadeIn = true;
        getImage().setTransparency(0);
        this.next = next;
    }
    /**
     * Act - do whatever the Fader wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        getImage().setColor(Color.BLACK);
        getImage().fill();
        if(fadeIn){//darken screen
            if(getImage().getTransparency() >= 250)Greenfoot.setWorld(next);
            else getImage().setTransparency(getImage().getTransparency() + 25);
        }else{
            if(getImage().getTransparency() == 0){
                //TheWorld.stop = false;
                getWorld().removeObject(this);
            }
            else getImage().setTransparency(getImage().getTransparency() - 25);
        }
    }    
}
