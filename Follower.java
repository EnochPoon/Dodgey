import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Follows player for a short amount of time. Appears when score >= 150
 * 
 * @author Enoch Poon
 * 
 */
public class Follower extends Obstacle
{
    private final int fullsize = 20;
    private final int time;
    private int timer = 0;
    private boolean fadeIn = true;
    public Follower(int speed, int time){
        super(speed);
        this.time = time;
        getImage().setTransparency(25);
    }

    @Override
    public void work() 
    {

        try{
            Actor player = getWorld().getObjects(Player.class).get(0);
            turnTowards(player.getX(), player.getY());
        }catch(Exception e){
            e.printStackTrace();
        }

        move(speed);
        if(getImage().getTransparency() != 255 && fadeIn)getImage().setTransparency(Math.min(255, getImage().getTransparency() + 25));
        else if(getImage().getTransparency() == 255)fadeIn = false;
        timer++;
        if(timer >= time){
            isDeadly = false;
            getImage().setTransparency(getImage().getTransparency() - 25);
        }
            
        

    }    
    
    public void destroy(){
        if(timer >= time + 9){
            
            getWorld().removeObject(this);
        }
    }
}
