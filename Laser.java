import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Laser here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Laser extends Obstacle
{
    int tp = 255;
    public Laser(int side){
        getImage().scale(2000, 50);
        if(side < 2)turn(90);
    }
    
    /**
     * Act - do whatever the Laser wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        getImage().setTransparency(tp);
        if(!TheWorld.stop)tp -= 15;
        if(tp <= 0)getWorld().removeObject(this);
        
        if(Greenfoot.mousePressed(this)){
            TheWorld theworld = (TheWorld)getWorld();
            theworld.movePlayer();
        }
    }    
}
