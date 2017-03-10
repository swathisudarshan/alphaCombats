import greenfoot.*;

/**
 * Write a description of class State here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class State extends Actor
{
    int value = 3;
    /**
     * Act - do whatever the state wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
                
    }    
    public int getValue()
    {
            
        return value;
    }
    public void setValue()
    {
        value = 0;
    }
    public void unsetValue()
    {
        value = 1;
    }  
}
