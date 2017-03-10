import greenfoot.*; 
import java.util.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Car here.
 */ 

public class Skater extends Actor
{
    private Actor collidedVehicle;
    private Actor collidedCoin;
    private Actor collidedPerson;
    private Actor collidedBackground;
    private Actor collidedBooster;
    private Actor collidedLifeSaver;
    private ConcreteSubject subject;
    
    private int counter = 0;
    private String img;
    private GifImage gif;
    GifImage mygif = new GifImage( "mp_aliencrafttr1.gif" );
     public Skater(){
       
     
      
   
        
    
    
        
    }
    /**
     * Act - do whatever the Car wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setImage( mygif.getCurrentImage() );
        checkKeyAndMove();
        createBomb();
        checkCollision();
        click();
    }
    public void checkKeyAndMove()
    {
        if(((MyWorld) getWorld()).getPause() == false)
       {
         
        if(Greenfoot.isKeyDown("left")&& this.getX()>=180){
            this.setLocation(getX()-8,getY());
           this.setRotation(-20);
        }
         else if(Greenfoot.isKeyDown("right") && this.getX()<=670){
            this.setLocation(getX()+8,getY());
             this.setRotation(20);
        }
         else if(Greenfoot.isKeyDown("up")){
             if(this.getY()>300)
            this.setLocation(getX(),getY()-8);
           
        }
        else if(Greenfoot.isKeyDown("down")){
            if(this.getY()<525){
            this.setLocation(getX(),getY()+8);
        }
        }
        else
        this.setRotation(0);
       }
    }
    public void createBomb()
    {
       if(((MyWorld) getWorld()).getPause() == false)
       {
       AmmoFactory ammoFactory= new AmmoFactory();       
          if(counter == 0)
          {
             if (Greenfoot.isKeyDown("space"))
             {
                Ammunition bullet = ammoFactory.getAmmunition("Bullet");
                getWorld().addObject(bullet,getX(),getY()-80);
                counter = 50;
             }
             if (Greenfoot.isKeyDown("A"))
             {
                 if(((MyWorld) getWorld()).getLaser()>0){
              Ammunition bullet = ammoFactory.getAmmunition("Laser");
                getWorld().addObject(bullet,getX(),getY()-80);
                ((MyWorld) getWorld()).setLaser();
                counter = 50;
            }
             }
          }
          else
          {
             counter--;  
          }
       }
   }
    public void click()
    {
       if(Greenfoot.mouseClicked(null))
       {
          if(((MyWorld) getWorld()).getPause() == false)
          {
             //((CarWorld) getWorld()).pauseGame(true);
             ((MyWorld) getWorld()).setPause();
             getWorld().addObject(new Information(),400,300);
          }
       }
    }
    
    public void checkCollision()
    {
        if(this.isTouching(Blockers.class)){
            ArrayList<Blockers> list = (ArrayList<Blockers>)getObjectsAtOffset(5, 5, Blockers.class);
            if(list.size()>0)
                collidedVehicle = list.get(0);
            else
                 collidedVehicle = null;
            
            if (collidedVehicle != null)
            {
               getWorld().removeObject(collidedVehicle);
               ((MyWorld) getWorld()).collided();
               Greenfoot.playSound("Explosion.wav");
            }
        }
        
        
       if(this.isTouching(Coin.class)){
            ArrayList<Coin> coins = (ArrayList<Coin>)getObjectsAtOffset(5, 5, Coin.class);
            if(coins.size()>0)
                collidedCoin = coins.get(0);
            else
                collidedCoin = null;
                
            if(collidedCoin != null)
            {
               getWorld().removeObject(collidedCoin);
               ArrayList<ConcreteSubject> listOfSubs = (ArrayList<ConcreteSubject>)(((MyWorld)getWorld()).getObjects(ConcreteSubject.class));
               if(listOfSubs.size()>0){
                   subject = listOfSubs.get(0);
                   subject.setScore(10);
                }
  
              // ((CarWorld) getWorld()).addScore(10);
               Greenfoot.playSound("Coin.mp3");
            }
        }
        
        if(this.isTouching(LifeSaver.class)){
            ArrayList<LifeSaver> allLife = (ArrayList<LifeSaver>)getObjectsAtOffset(5, 5, LifeSaver.class);
            if(allLife.size()>0)
                collidedLifeSaver = allLife.get(0);
            else
                collidedLifeSaver = null;
                
            if(collidedLifeSaver != null)
            {
               getWorld().removeObject(collidedLifeSaver);
               ((MyWorld) getWorld()).incLives();
               Greenfoot.playSound("Explosion.wav");
            }
        }
        
        if(this.isTouching(SpeedBooster.class)){
                ArrayList<SpeedBooster> boosters = (ArrayList<SpeedBooster>)getObjectsAtOffset(5, 5,SpeedBooster.class);
               
                if(boosters.size()>0)
                    collidedBooster = boosters.get(0);
                else
                    collidedBooster = null;
                    
               if (collidedBooster != null)
                {
            
                   ((MyWorld)getWorld()).removeObject(collidedBooster);
                   Component component;
                   
                   ArrayList<ConcreteSubject> listOfSubs = (ArrayList<ConcreteSubject>)(((MyWorld)getWorld()).getObjects(ConcreteSubject.class));
                   if(listOfSubs.size()>0){
                       subject = listOfSubs.get(0);
                       subject.setSpeed(40);
                    }
                
                   //((CarWorld)getWorld()).getSubject().setSpeed(40);
                  // ((CarWorld)getWorld()).addSpeed(40);
                   component = ((MyWorld)getWorld()).getComponent();
                  
                   
                   try{
                      //  long start = System.currentTimeMillis( );
                        ((MyWorld)getWorld()).setMoveFastFlag();
                        component.setFasterFlag();
                        
                      /*  if((System.currentTimeMillis( ) - start) == 5000){
                            ((CarWorld)getWorld()).unsetMoveFastFlag();
                            component.unsetFasterFlag();
                        } */
                    }catch (Exception e) {
                            System.out.println("Got an exception!");
                        }
            
                }
             
            }
        }
}
