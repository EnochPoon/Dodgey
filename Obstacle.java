import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Touch this and die
 * 
 * @author Enoch Poon
 * 
 */
public class Obstacle extends Actor
{
    // 0 = top, 1 = bot, 2 = left, 3 = right
    boolean entered = false;

    public void act() 
    {

        //if(Greenfoot.mousePressed(this)){
        //    TheWorld theworld = (TheWorld)getWorld();
        //    theworld.movePlayer();
        //}
        destroy();
    }

    public void destroy(){
        if(getX() < -10 || getY() < -10 || getX() > getWorld().getWidth() + 10 || getY() > getWorld().getHeight() + 10){
            getWorld().removeObject(this);
        }
    }
}
