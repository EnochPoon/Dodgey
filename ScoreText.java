import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.util.*;
/**
 * The Score is posted here
 * 
 * @author Enoch Poon
 * 
 */
public class ScoreText extends Actor
{
    int score = 0;
    public ScoreText(){
        setImage(new GreenfootImage("Score:\n" + score, 20, Color.BLACK, null));
    }
    public void act() 
    {
        score = (int)TheWorld.score;
        setImage(new GreenfootImage("Score:\n" + score, 20, Color.BLACK, null));
        //if(Greenfoot.mousePressed(this)){
        //    TheWorld theworld = (TheWorld)getWorld();
        //    theworld.movePlayer();
        //}
    }    
}
