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
    public Laser(int speed, boolean isRotated){
        super(speed);
        getImage().scale(2000, 50);
        if(isRotated)turn(90);
    }
    
    @Override
    public void work() 
    {
        getImage().setTransparency(tp);
        tp -= 25;
    }    
    
    @Override
    public void destroy(){
        if(tp <= 0)getWorld().removeObject(this);
    }
}
