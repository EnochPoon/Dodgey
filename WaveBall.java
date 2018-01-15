import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Sinusoidal path
 * 
 * @author Enoch Poon
 * 
 */
public class WaveBall extends Obstacle
{
    private final int amplitude;
    private int midX; // the centre line of the wave
    private int midY; // the centre line of the wave
    private int time = 0;
    public WaveBall(int speed){
        super(speed);
        amplitude = Greenfoot.getRandomNumber(50) + 50;
    }

    protected void addedToWorld(World world){
        midX = getX();
        midY = getY();
    }

    @Override
    public void work() 
    {
        setLocation(midX, midY);
        move(speed);
        midX = getX();
        midY = getY();
        turn(90);
        move((int)(Math.sin(Math.toRadians(4 * time)) * amplitude));
        turn(-90);
        time++;
    }    
}
