import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * After a while, Follower spawns here
 * 
 * @author Enoch Poon
 * 
 */
public class FollowerWarning extends Actor
{
    int tp = 0;
    int speed;
    public FollowerWarning(int speed){
        getImage().setTransparency(0);
        getImage().scale(30, 30);
        this.speed = speed;
    }
    
    public void act() 
    {
        if(tp <= 255)getImage().setTransparency(tp);
        else{
            getWorld().addObject(new Follower(speed / 2), getX(), getY());
            getWorld().removeObject(this);
        }
        if(!TheWorld.stop)tp += speed;
    }    
}
