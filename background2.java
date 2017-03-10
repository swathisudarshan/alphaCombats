import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class background2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class background2 extends Component
{
    /**
     * Act - do whatever the background2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private boolean moveFasterFlag = false;
    GifImage myGif = new GifImage("back.gif");
    /**
     * Act - do whatever the Background2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setImage(myGif.getCurrentImage());
    }  
    public void addChild(Component c) {}
    public void removeChild(Component c) {}
    public Component getChild(int i) {
        return null;
    }
    public List<Component> getAllChild(){
        return null;
    }
     public void setFasterFlag(){
        moveFasterFlag = true;
    }
}
