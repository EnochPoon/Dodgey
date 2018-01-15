import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Temporarily appears to show how many coins are earned
 * 
 * @author Enoch Poon
 * 
 */
public class CoinMessage extends FrontMessage
{
    int timer = 255;
    public CoinMessage(int coins){
        setImage(new GreenfootImage("You gained " + coins + " coins!", 20, Color.YELLOW, new Color(0,0,0,0)));
        Data.update((int)TheWorld.getScore(), coins);
        if(coins == 0){
            timer = 0;
            getImage().setTransparency(0);
        }
        
    }
    
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
