import greenfoot.*;

/**
 * Write a description of class AmmoFactory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AmmoFactory extends Actor
{
    /**
     * Act - do whatever the AmmoFactory wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }   
    
    public Ammunition getAmmunition(String ammoType){
      if(ammoType == null){
         return null;
      }		
      if(ammoType.equalsIgnoreCase("Bullet")){
         return new Bullet();
         
      } else if(ammoType.equalsIgnoreCase("Laser")){
         return new Laser();
        }
         
         return null;
   }   
}
