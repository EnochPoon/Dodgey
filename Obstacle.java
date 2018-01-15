import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Touch this and die
 * 
 * @author Enoch Poon
 * 
 */
public abstract class Obstacle extends Actor
{
    protected boolean entered;
    protected int speed;
    protected boolean isDeadly;
    private double x;
    private double y;
    private boolean start = true;
    public Obstacle(int speed){
        this.speed = speed;
        isDeadly = true;
    }

    public Obstacle(int speed, boolean isDeadly){
        this.speed = speed;
        this.isDeadly = isDeadly;
    }

    public void act() 
    {
        if(start){
            x = getX();
            y = getY();
            start = false;
        }

        if(!TheWorld.isStopped())work();
        if(!TheWorld.isStopped())destroy();
    }

    public abstract void work();

    @Override
    public void move(int speed){
        x += Math.cos(Math.toRadians(getRotation())) * speed;
        y += Math.sin(Math.toRadians(getRotation())) * speed;
        setLocation((int)Math.round(x), (int)Math.round(y));
    }
    
    @Override
    public void setLocation(int x, int y){
        this.x = x;
        this.y = y;
        super.setLocation(x, y);
    }
    
    public void destroy(){
        if(getX() < -20 || getY() < -20 || getX() > getWorld().getWidth() + 20 || getY() > getWorld().getHeight() + 20){
            getWorld().removeObject(this);
        }
    }
    
    public boolean isDeadly(){
        return isDeadly;
    }
}
