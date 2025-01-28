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
    private Player player;
    private static double score = 0.0;
    private static boolean stopped = true;
    private int timer = 0;
    private int maxTimer;
    private boolean start = true; // first thing to do
    public TheWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1, false);
        prepare();
        score = 0.0;
        timer = 0;
        maxTimer = 0;
    }

    public void prepare(){
        player = new Player();
        addObject(player, getWidth()/2, getHeight()/2);
        addObject(new ScoreText(), 100, 50);
        addObject(new BlackFader(), getWidth()/2, getHeight()/2);
        setPaintOrder(BlackFader.class, FrontMessage.class, Flash.class, Scope.class, Obstacle.class, Player.class);
    }

    public void act(){
        if(start && getObjects(BlackFader.class).size() == 0){
            start = false;
            stopped = false;
        }

        if(!stopped){

            score += 0.1;
            maxTimer = Math.max((int)(-0.5 * score + 100), 5);
            //move player
            movePlayer();
            if(timer++ >= maxTimer)summonObstacle();
        }
    }
    
    /**
     * Moves the player to the mouse on click
     */
    public void movePlayer(){
        try{
            MouseInfo mi = Greenfoot.getMouseInfo();
            if (mi != null) {
                int button = Greenfoot.getMouseInfo().getButton();
                int getX = Greenfoot.getMouseInfo().getX();
                int getY = Greenfoot.getMouseInfo().getY();
                if(button == 1 && getX > 0 && getX < getWidth() && getY > 0 && getY < getHeight()){
                    removeObjects(getObjects(Marker.class));
                    addObject(new Marker(), Greenfoot.getMouseInfo().getX(), Greenfoot.getMouseInfo().getY());
                }
            }

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public static int getScore(){
        return (int)score;
    }

    private void summonObstacle(){
        int obChoice = Greenfoot.getRandomNumber((int)score);
        int side = Greenfoot.getRandomNumber(4);
        Obstacle obs;
        int obSpeed = Math.max(3, Math.min((int)(score * 0.02), 15));
        if(obChoice < score * 3/4 || score < 100){
            obChoice = Greenfoot.getRandomNumber(6);

            if (obChoice < 3 || score < 30)obs = new LineBall(obSpeed);
            else if (obChoice < 5 || score < 75)obs = new CurveBall(obSpeed);
            else obs = new WaveBall(obSpeed);

            // determine spawning location
            switch (side){
                case 0:
                    addObject(obs, Greenfoot.getRandomNumber(getWidth()), -5);
                    obs.setRotation(90);
                    break;

                case 1:
                    addObject(obs, Greenfoot.getRandomNumber(getWidth()), getHeight() + 5);
                    obs.setRotation(-90);
                    break;

                case 2:
                    addObject(obs, -5, Greenfoot.getRandomNumber(getHeight()));
                    break;

                case 3:
                    addObject(obs, getWidth() + 5, Greenfoot.getRandomNumber(getHeight()));
                    obs.setRotation(180);
                    break;
            }
            obs.turn(Greenfoot.getRandomNumber(90) - 45);
            if(Greenfoot.getRandomNumber(2) == 0 && !obs.getClass().equals(CurveBall.class)){
                try{
                    obs.turnTowards(player.getX(), player.getY());
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
            timer = 0;
            return;
        }else if(obChoice < score * 4/5 || score < 150){
            obs = new LaserWarning((int)(1 / 0.0005 / score) + 50, side > 2);
        }else if(obChoice < score * 5/6 || score < 200){
            obs = new FollowerWarning((int)(1 / 0.0005 / score), (int)score);
        }else{
            obs = new Scope((int)(-0.02 * score + 22));
            timer = 0;
            addObject(obs, player.getX(), player.getY());
            return;
        }
        timer = 0;
        addObject(obs, Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
    }

    public void cheat(int score){
        this.score = score;
    }

    public static boolean isStopped(){
        return stopped;
    }

    public static void stop(){
        stopped = true;
    }
}
