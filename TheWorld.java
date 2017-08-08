import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Main Map
 * 
 * @author Enoch Poon
 * 
 */
public class TheWorld extends World
{
    Player player;
    static double score = 0.0;
    static boolean stop = false;
    int timer = 0;
    int maxTimer;
    static int obSpeed;
    boolean pressing = false;
    Random r = new Random();
    boolean start = true; // first thing to do
    public TheWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false);
        prepare();
        score = 0.0;
        obSpeed = 3;
        timer = 0;
        maxTimer = 0;
        stop = false;
        setActOrder(TheWorld.class);
       
    }

    public void prepare(){
        player = new Player();
        addObject(player, getWidth()/2, getHeight()/2);
        addObject(new ScoreText(), 100, 50);
        addObject(new Fader(), getWidth()/2, getHeight()/2);
        setPaintOrder(Fader.class, FrontMessage.class, Flash.class, Scope.class, Obstacle.class, Player.class);
    }

    public void act(){
        // if(start){
            // start = false;
            // prepare();
        // }
        
        if(!stop){
            
            score += 0.1;
            maxTimer = Math.max(1000 / ((int)score + 1), 10);
            obSpeed = Math.max(3, Math.min((int)score / 20, 30));
            //move player
            movePlayer();
            timer++;
            if(timer >= maxTimer)summonObstacle();
        }
    }

    void movePlayer(){
        try{
            int button = Greenfoot.getMouseInfo().getButton();
            int getX = Greenfoot.getMouseInfo().getX();
            int getY = Greenfoot.getMouseInfo().getY();
            if(button == 1 && getX > 0 && getX < getWidth() && getY > 0 && getY < getHeight()){
                removeObjects(getObjects(Marker.class));
                addObject(new Marker(), Greenfoot.getMouseInfo().getX(), Greenfoot.getMouseInfo().getY());
            }
        }
        catch(Exception e){
            
        }
    }

    void summonObstacle(){
        int obChoice = r.nextInt((int)score);
        int side = r.nextInt(4);
        if(obChoice < score * 3/4 || score < 100){
            int path = Math.min((int)score / 50, 2) + 1;
            Spikeball sb = new Spikeball(side, this, r.nextInt(path));

        }else if(obChoice < score * 4/5 || score < 150){
            Warning warning = new Warning(side, this);
        }else if(obChoice < score * 5/6 || score < 200){
            addObject(new FollowerWarning(obSpeed), r.nextInt(getWidth()), r.nextInt(getHeight()));
        }else if(obChoice < score * 6/7 || score < 250){
            addObject(new Scope(), player.getX(), player.getY());
        }
        timer = 0;
    }

    public void cheat(int score){
        this.score = score;
    }
    
    static int getCoins(){
        return (int)score / 10;
    }
}
