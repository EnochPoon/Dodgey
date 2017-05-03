import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Warning here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Warning extends Actor
{
    int side;
    int tp = 255;
    TheWorld world;
    Random r = new Random();
    public Warning(int side, TheWorld world){
        this.side = side;
        this.world = world;
        if(side < 2){
            world.addObject(this, r.nextInt(world.getWidth() - 50) + 50, world.getHeight() / 2);
            turn(90);
        }else{
            world.addObject(this, world.getWidth() / 2, r.nextInt(world.getHeight() - 50) + 50);
        }
        getImage().scale(2000, 10);
    }

    public void act() 
    {
        if(tp <= 0){
            getWorld().addObject(new Laser(side), getX(), getY());
            getWorld().removeObject(this);
            return;
        }else{
            getImage().setTransparency(tp);
        }

        if(!TheWorld.stop)tp -= TheWorld.obSpeed;

        //if(Greenfoot.mousePressed(this))world.movePlayer();

    }    
}
