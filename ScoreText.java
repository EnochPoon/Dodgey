import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.util.*;
/**
 * The Score and high score are posted here
 * 
 * @author Enoch Poon
 * 
 */
public class ScoreText extends Actor
{
    int score = 0;
    static int highscore = 0;
    public ScoreText(){
        setImage(new GreenfootImage("Score: " + score + "\nHigh Score: " + highscore, 20, Color.BLACK, null));
    }
    public void act() 
    {
        score = (int)TheWorld.score;
        highscore = Math.max(score, highscore);
        setImage(new GreenfootImage("Score: " + score + "\nHigh Score: " + highscore, 20, Color.BLACK, null));
        
    }    
}
