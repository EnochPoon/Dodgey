import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Main Player
 * 
 * @author Enoch Poon 
 * 
 */
public class Player extends Actor
{
    
    public void act() 
    {
        for(Actor a : getObjectsInRange(getImage().getWidth() - 5, Obstacle.class)){
            if(((Obstacle)a).isDeadly()){
                death();
                return;
            }
        }
        
        if(isTouching(Laser.class)){
            death();
            return;
        }
        
        if(getWorld().getObjects(Marker.class).size() > 0){
            move();
        }
    }    

    public void death(){
        if(!TheWorld.isStopped())getWorld().addObject(new Flash(), getWorld().getWidth() / 2, getWorld().getHeight() / 2);
        TheWorld.stop();
        getWorld().removeObjects(getWorld().getObjects(Marker.class));
        
    }

    public void move(){
        Marker marker = (Marker)getWorld().getObjects(Marker.class).get(0);
        double speed = (Math.abs((double)(getX() - marker.getX())) + Math.abs((double)(getY() - marker.getY())))/10.0;
        turnTowards(marker.getX(), marker.getY());
        super.move((int)Math.ceil(speed));
        if(getX() == marker.getX() && getY() == marker.getY())getWorld().removeObject(marker);
    }
}
