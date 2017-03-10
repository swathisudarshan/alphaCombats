import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class Nature here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Background  extends Component
{
   
    private boolean moveFasterFlag = false;
     GifImage mygif = new GifImage( "jjlgmovi_e0.gif" );
    public Background()
    {
      
       //GreenfootImage image=getImage();
     //  image.scale(550,600);  
       //image.scale(200,50);  
       //setImage(image);
       setRotation(180);

     //  randomImage();
       //collided = getOneIntersectingObject(Background.class);
       //if (collided != null)
       //{
       //   collidedOn = 1;
       //}
    }
     /**
     * Act - do whatever the House4 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setImage( mygif.getCurrentImage() );
        if(moveFasterFlag){
            moveFaster();
        }
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
