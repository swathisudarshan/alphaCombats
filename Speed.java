import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

import java.awt.Font;
import java.util.*;


public class Speed extends Observer
{
    public static int value = 0;
    public static int target = 0;
    public static String text;
    public static int stringLength;
    private ConcreteSubject subject;
    
    public Speed()
    {
     
    }
    public Speed(String prefix)
    {
        value = 0;
        target = 0;
        text = prefix;
        stringLength = (text.length() + 2) * 16;

        setImage(new GreenfootImage(stringLength, 24));
        GreenfootImage image = getImage();
        Font font = image.getFont();
        image.setFont(font.deriveFont(24.0F));  // use larger font
        
        updateImage();
    }
    public void act()
    {
       
    }
    /*public void add(int score)
    {
        target += score;
    }*/
    public int getValue()
    {
        return value;
    }
    /**
     * Make the image
     */
    public void updateImage()
    {
        GreenfootImage image = getImage();
        image.clear();
        image.drawString(text + target, 1, 18);
    }
    
    public void update(){
        
        ArrayList<ConcreteSubject> listOfSubs = (ArrayList<ConcreteSubject>)(((MyWorld)getWorld()).getObjects(ConcreteSubject.class));
        if(listOfSubs.size()>0){
              subject = listOfSubs.get(0);
        }
        
        if(text.equalsIgnoreCase("Speed: ")){
            if(subject != null)
                target = subject.getSpeed();
            }
          
           if(value > target)
           {
              value = 0;
             // updateImage();
           }
           updateImage();
    } 
}
