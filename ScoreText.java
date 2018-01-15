import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * The Score and high score are posted here
 * 
 * @author Enoch Poon
 * 
 */
public class ScoreText extends FrontMessage
{
    int score = 0;
    static int highscore = 0;
    public ScoreText(){
        highscore = Data.highscore;
        setImage(new GreenfootImage("Score: " + score + "\nHigh Score: " + highscore, 20, Color.BLACK, new Color(0,0,0,0)));
    }
    public void act() 
    {
        score = TheWorld.getScore();
        highscore = Math.max(score, highscore);
        setImage(new GreenfootImage("Score: " + score + "\nHigh Score: " + highscore, 20, Color.BLACK, new Color(0,0,0,0)));
        
    }    
}
