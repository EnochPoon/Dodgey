import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Laser Warning line
 * 
 * @author Enoch Poon
 * 
 */
public class LaserWarning extends Obstacle
{
    private boolean isRotated;
    public LaserWarning(int speed, boolean isRotated){
        super(speed, false);
        this.isRotated = isRotated;
        if(isRotated)turn(90);
        getImage().scale(2000, 10);
    }

    @Override
    public void work() 
    {
        speed--;
    }    
    
    @Override
    public void destroy(){
        if(speed-- < 0){
            getWorld().addObject(new Laser(speed, isRotated), getX(), getY());
            getWorld().removeObject(this);
        }
    }
}
