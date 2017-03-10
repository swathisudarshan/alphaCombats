import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Information here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Information  extends Actor
{
    /**
     * Act - do whatever the Information wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        gamePause();
    }    
    
    public void gamePause()
    {
       //state st = new state();
       if(Greenfoot.mouseClicked(null))
       {
          if(((MyWorld) getWorld()).getPause() == true)
          {
              ((MyWorld) getWorld()).unsetPause();
              //((CarWorld) getWorld()).pauseGame();
              getWorld().removeObject(this);
          }
       }
    }
}
