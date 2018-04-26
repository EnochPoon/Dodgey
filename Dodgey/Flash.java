import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Flash effect when player is hit
 * 
 * @author Enoch Poon
 * 
 */
public class Flash extends Actor
{
    int tp = 255;
    public Flash(){
        getImage().setColor(Color.WHITE);
        getImage().fill();
        getImage().setTransparency(0);
    }

    /**
     * Act - do whatever the Flash wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        getImage().scale(getWorld().getWidth() + 10, getWorld().getHeight() + 10);
        getImage().setTransparency(tp);
        tp -= 5;
        if(tp == 0){
            getWorld().addObject(new RestartButton(), 400, 50);
            getWorld().addObject(new BackButton(), 400, 390);
            //getWorld().addObject(new CoinMessage(TheWorld.getScore()/10), 100, 390);
            Data.update(TheWorld.getScore(), 0);
            getWorld().removeObject(this);
        }

    }    
}
