import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
import java.awt.Color;
/**
 * Most common obstacle. Can move in line, parabola, or sinusoidal function
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Spikeball extends Obstacle
{
    int side;
    int slant;
    int path;//0 = linear, 1 = parabola, 2 = sinusoidal
    int amplitude;
    double time = 0.0;
    Random r = new Random();
    int initRotate;
    int speed;
    double getX;
    double getY;
    public Spikeball(int side, World world, int path){
		//speed = TheWorld.obSpeed;
        switch(side){
            case 0:
            world.addObject(this, r.nextInt(world.getWidth()), -5);
            setRotation(90);

            break;

            case 1:
            world.addObject(this, r.nextInt(world.getWidth()), world.getHeight() + 5);
            setRotation(-90);

            break;

            case 2:
            world.addObject(this, -5, r.nextInt(world.getHeight()));

            break;

            case 3:
            world.addObject(this, world.getWidth() + 5, r.nextInt(world.getHeight()));
            setRotation(180);

            break;
        }
        this.side = side;
        this.path = path;
        slant = r.nextInt(90) - 45;
        turn(slant);
        initRotate = getRotation();
        amplitude = (30 + r.nextInt(10)) * ((r.nextInt(2) == 1)? 1 : -1);
        switch(path){
            case 0://linear
            speed = TheWorld.obSpeed;
            break;

            case 1://parabola
            speed = TheWorld.obSpeed * 3/4;
            setImage(new GreenfootImage("GreenCircle.png"));
            break;

            case 2://sinusoidal
            speed = TheWorld.obSpeed;
            setImage(new GreenfootImage("blue-draught.png"));
            break;

        }
        getX = (double)getX();
        getY = (double)getY();
    }

    public void act() 
    {
        if(!TheWorld.stop)move();
        time++;
        //LAST PART
        super.act();
    }    

    public void move(){
        switch(path){
            case 1:
            turn(1);
            break;

            case 2:
            setRotation(initRotate + (int)(amplitude * Math.sin(time / 10)));
            break;
        }
        getX += (double)speed * Math.cos(Math.toRadians((double)getRotation()));
        getY += (double)speed * Math.sin(Math.toRadians((double)getRotation()));
        setLocation((int)getX, (int)getY);
    }

}
