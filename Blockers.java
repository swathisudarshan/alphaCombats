import greenfoot.*;  
import java.util.*;

/**
 * Write a description of class Vehicle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Blockers  extends Component
{
    private GreenfootImage image1;
    private GreenfootImage image2;
    private boolean moveFasterFlag = false;
    GifImage mygif = new GifImage( "alien06.gif" );
    // GifImage mygif1 = new GifImage( "animated-alien-and-extraterrestrial-image-0067.gif" );
    public Blockers()
    {
       
      // image1 = new GreenfootImage("alien-face-dark.png");
       //image2 = new GreenfootImage("monster-alien-3-w.png");
      //image1.scale(100,100);  
      // image2.scale(100,100);  
      // randomImage();
       //setRotation(90);
    }
    /**
     * Act - do whatever the Vehicle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setImage( mygif.getCurrentImage() );
        //setImage( mygif1.getCurrentImage() );
        this.removeTouching(SpeedBooster.class);
        this.removeTouching(Blockers.class);
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
         
             setLocation(getX(), getY()+4);
 
       }
    }
    
     public void moveFaster()
    {
       if(((MyWorld) getWorld()).getPause() == false)
       {
          setLocation(getX(), getY()+8);
       }
    }
    
    public void randomImage()
    {
       //if (Greenfoot.getRandomNumber(5)>2)
       //{
          //setImage(image2);
       // }
       // else
        //{
        //  setImage(image1);
        //}
       
       
    }
    public void check()
    {
        
    // collided = getOneIntersectingObject(Vehicle.class);
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
