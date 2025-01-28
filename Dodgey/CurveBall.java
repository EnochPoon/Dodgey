import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * An obstacle that turns
 * 
 * @author Enoch Poon 
 * 
 */
public class CurveBall extends Obstacle
{
    private final int maxTurnTime = 5;
    private int turnTime;
    private final boolean rightTurn;
    public CurveBall(int speed){
        super(speed);
        rightTurn = Greenfoot.getRandomNumber(2) == 1;
    }

    public void work() 
    {
        move(speed);
        turn(0.1 * speed * (rightTurn? 1: -1));

    }    
}
