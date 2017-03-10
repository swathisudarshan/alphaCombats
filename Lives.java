import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

import java.awt.Font;

/**
 * Counter that displays a number.
 * 
 * @author Michael Kolling
 * @version 1.0.1
 */
public class Lives extends Actor
{
    public static int valueLives;
  
    public void act()
    {
       valueLives = ((MyWorld) getWorld()).getLives();
       decLives();
     //  addLives();
    }
    public void decLives()
    {
       if(getX() == 150)
       {
          if(valueLives == 2)
          {
             getWorld().removeObject(this);
          }
       }
       else if(getX() == 100)
       {
          if(valueLives == 1)
          {
             getWorld().removeObject(this);
          }
        //else if(valueLives==3 && getX()!=150)
           // getWorld().addObject(new Lives(),150,50);
       }
       else if(getX() == 50)
       {
          if(valueLives == 0)
          {
              MyWorld world=(MyWorld) getWorld();
          Greenfoot.stop();
          getWorld().addObject(new ScoreBoard(world.getScore(),world.getLives()),400,300);
          getWorld().removeObject(this);
          }
          else if(valueLives==2)
          getWorld().addObject(new Lives(),100,50);
       }     
    }
   /* public void addLives(){
         if(getX() == 100 && valueLives == 3)
          {
             getWorld().addObject(new Lives(),150,50);
          }
       
       else if(getX() == 50)
       {
          if(valueLives == 2)
          {
             getWorld().addObject(new Lives(),100,50);
          }
       }
       else if(getX() == 0)
       {
          if(valueLives == 0)
          {
              getWorld().addObject(new Lives(),50,50);
                //  getWorld().addObject(new ScoreBoard(),300,300);
             Greenfoot.stop();  
          }
       }
       }
        */
}
