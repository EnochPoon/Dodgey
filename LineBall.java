import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Most common obstacle. Can move in line, parabola, or sinusoidal function
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LineBall extends Obstacle
{
    public LineBall(int speed){
        super(speed);
    }
    
    @Override 
    public void work(){
        move(speed);
    }

}
