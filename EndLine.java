import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EndLine here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EndLine  extends Actor
{
    /**
     * Act - do whatever the EndLine wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public EndLine(){
        GreenfootImage image=getImage();
        image.scale(500,20);
    }
    public void act() 
    {
        moveDown();
        checkLocation();
    }    
    public void moveDown()
    {
       setLocation(getX(), getY()+4);
    }
    public void checkLocation()
    {
       if (getY()>=(getWorld().getHeight()-1))
       {
           MyWorld world=(MyWorld) getWorld();
          Greenfoot.stop();
          getWorld().addObject(new ScoreBoard(world.getScore(),world.getLives()),400,300);
          getWorld().removeObject(this);
       }
    }
}
