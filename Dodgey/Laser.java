import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Long laser that lasts for some time
 * 
 * @author Enoch Poon
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
