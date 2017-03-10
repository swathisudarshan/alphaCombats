import greenfoot.*;

/**
 * Write a description of class StartScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartScreen extends Actor
{
    
    public StartScreen(){
        GreenfootImage image=getImage();
        image.scale(800,600);  
    }
    /**
     * Act - do whatever the StartScreen wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.mouseClicked(null))
       {
         
          getWorld().removeObject(this);
          
       }
    }
    
}
