import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Follows player for a short amount of time. Appears when score >= 150
 * 
 * @author Enoch Poon
 * 
 */
public class Follower extends Obstacle
{
    final int fullsize = 20;
    final int time = 300;
    int size = 1;
    int timer = 0;
    int speed;
    public Follower(int speed){
        getImage().scale(1, 1);
        this.speed = speed;
    }
    /**
     * Act - do whatever the Follower wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(!TheWorld.stop){
            turnTowards(((TheWorld)getWorld()).player.getX(), ((TheWorld)getWorld()).player.getY());
            move(speed);
            if(size <= fullsize){
                setImage(new GreenfootImage("PinkCircle.png"));
                getImage().scale(size, size);
                size += 4;
            }
            timer++;
            if(timer == time){
                getWorld().removeObject(this);
                return;
            }
        }
        
        //LAST PART
        super.act();
    }    
}
