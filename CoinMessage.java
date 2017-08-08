import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CoinMessage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CoinMessage extends FrontMessage
{
    int timer = 255;
    public CoinMessage(int coins){
        setImage(new GreenfootImage("You gained " + coins + " coins!", 20, Color.YELLOW, new Color(0,0,0,0)));
        Data.update((int)TheWorld.score, coins);
        if(coins == 0){
            timer = 0;
            getImage().setTransparency(0);
        }
        
    }
    /**
     * Act - do whatever the CoinMessage wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(timer == 0){
            getWorld().removeObject(this);
        }else{
            timer -= 5;
            setLocation(getX(), getY() - 1);
        }
    }    
}
