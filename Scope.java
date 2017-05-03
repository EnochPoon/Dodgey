import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Scope here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Scope extends Actor
{
    private int length = 80;
    private boolean f = false;
    int time = 5;//switch transparency
    private boolean flash = true;
    private int fire = 5;
    int ftime = 5;
    boolean shotfired = false;
    public void act() 
    {
        if(!TheWorld.stop){
            getImage().scale(length, length);
            if(length!=75){
                length--;
            }else{
                f=true;
            }
            if(f){
                time--;
            }
            if(time == 0){
                if(flash==true){
                    getImage().setTransparency(0);
                    flash = false;
                }else{
                    getImage().setTransparency(255);
                    flash = true;
                }
                time = 5;
                fire--;
            }

            if(fire == 0 && !shotfired){
                f = false;
                time = 1;
                setImage("explode.png");
                //getImage().scale(10,10);
                length = 25;
                Player p = (Player)getOneObjectAtOffset(0,0, Player.class);
                if(p != null){
                    p.death();
                }
                shotfired = true;
            }
            if(shotfired){
                ftime--;
                if(ftime == 0){
                    getWorld().removeObject(this);
                }
            }
        }
    }
}
