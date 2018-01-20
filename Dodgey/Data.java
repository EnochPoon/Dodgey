import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
import java.io.*;
/**
 * Stores data like high score and coins
 * 
 * @author Enoch Poon
 * 
 */
public class Data extends Actor
{
    static int highscore;
    static int coins;
    public Data(){
        File file = new File("data.txt");
        try{
            if(file.createNewFile()){
                PrintWriter pf = new PrintWriter(file);
                pf.println("0 0");
                pf.close();
            }
            Scanner scan = new Scanner(file);
            highscore = scan.nextInt();
            coins = scan.nextInt();
        }catch(Exception e){
            e.printStackTrace();
        }

    }
    static void update(int newhigh, int newcoins){
        highscore = Math.max(highscore, newhigh);
        coins += newcoins;
        try{
            PrintWriter pf = new PrintWriter("data.txt");
            pf.println(highscore + " " + coins);
            pf.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
