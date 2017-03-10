import greenfoot.*;
import java.util.*;

/**
 * Write a description of class Component here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Component extends Actor
{    
    public abstract void addChild(Component c);
    public abstract void removeChild(Component c);
    public abstract Component getChild(int i);
    public abstract List<Component> getAllChild();
    public abstract void setFasterFlag();
   
}
