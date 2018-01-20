import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * After a while, Follower spawns here
 * 
 * @author Enoch Poon
 * 
 */
public class FollowerWarning extends Obstacle
{
    private int tp;
    private int time;
    /**
     * time = lifetime for the Follower's life.
     * speed = time until spawn Follower
     */
    public FollowerWarning(int speed, int time){
        super(speed, false);
        this.time = time;
        getImage().setTransparency(0);
        getImage().scale(30, 30);
        
    }

    @Override
    public void work() 
    {
        if(tp <= 255)getImage().setTransparency(tp);
        tp += speed;
    }    

    public void destroy(){
        if(tp > 255){
            getWorld().addObject(new Follower(speed / 4, time), getX(), getY());
            getWorld().removeObject(this);
        }
    }
}