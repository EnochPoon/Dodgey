import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Main Player
 * 
 * @author Enoch Poon 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(getObjectsInRange(getImage().getWidth() - 5, Obstacle.class).size() > 0)death();
        if(isTouching(Laser.class))death();

        if(getWorld().getObjects(Marker.class).size() > 0){
            move();
        }
    }    

    void death(){
        if(!TheWorld.stop)getWorld().addObject(new Flash(), getWorld().getWidth() / 2, getWorld().getHeight() / 2);
        TheWorld.stop = true;
        getWorld().removeObjects(getWorld().getObjects(Marker.class));

    }

    void move(){
        Marker marker = (Marker)getWorld().getObjects(Marker.class).get(0);
        double speed = (Math.abs((double)(getX() - marker.getX())) + Math.abs((double)(getY() - marker.getY())))/10.0;
        turnTowards(marker.getX(), marker.getY());
        super.move((int)Math.ceil(speed));
        if(getX() == marker.getX() && getY() == marker.getY())getWorld().removeObject(marker);
    }
}
