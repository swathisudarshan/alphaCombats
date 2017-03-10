import greenfoot.*;
import java.util.*;

/**
 * Write a description of class Coin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Coin extends Component
{
    
   private boolean moveFasterFlag = false;
    /**
     * Act - do whatever the Coin wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
   public void act() 
    {
        
       this.removeTouching(Blockers.class);
       this.removeTouching(SpeedBooster.class);
       this.removeTouching(Coin.class);
         
       if(moveFasterFlag)
            moveFaster();
        else
            moveDown();
            
        check();
    }
   
    public void moveDown()
    {
        if(((MyWorld) getWorld()).getPause() == false)
       {
         
             setLocation(getX(), getY()+ 4);
 
       }
    } 
    
      public void moveFaster()
    {
       if(((MyWorld) getWorld()).getPause() == false)
       {
          setLocation(getX(), getY()+ 8);
       }
    }
    
    public void check()
    {
           if (getY()>=(getWorld().getHeight()-1))
            {
               getWorld().removeObject(this);
    
            }
            
    }
    
    public void setFasterFlag(){
        moveFasterFlag = true;
    }
    
    public void addChild(Component c) {}
    public void removeChild(Component c) {}
    public Component getChild(int i) {
        return null;
    }
    public List<Component> getAllChild(){
        return null;
    }
    
}
