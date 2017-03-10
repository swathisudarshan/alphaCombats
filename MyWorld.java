import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CarWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    private int counter;
    static int lives;
    static int score;
    private int speed;
    private boolean pause;
    private boolean fastFlag = false;
    private Component component;
    private ConcreteSubject subject;
    private State st = new State();
    private int laser;
     /**
     * Constructor for objects of class CarWorld.
     * 
     */
    public MyWorld()
    {
        super(800, 600, 1);
        setPaintOrder(StartScreen.class, Information.class, ScoreBoard.class, Dot.class, Path.class, Skater.class, Blockers.class,EndLine.class, Lives.class, Background.class);
        Greenfoot.playSound("Subway.mp3");
        lives = 3;
        laser = 2;
        speed = 48;
        pause = false;
        component = new Composite();
        subject = new ConcreteSubject();
        addObject(subject, 400, 400);
        
        addObject(new StartScreen(), 400,300);
        
        addObject(new Skater(),400,400);
        
        Score score = new Score("Score: ");
        subject.attach(score);
        addObject(score,85,580);
        
        Speed speed = new Speed("Speed: ");
        subject.attach(speed);
        addObject(speed,750,580);
        
        addObject(new Lives(),50,50);
        addObject(new Lives(),100,50);
        addObject(new Lives(),150,50);
        
        addObject(new Path(), 20, 242);
        addObject(new Dot(), 20, 390);
     
        Component vehicle=new Blockers();
        Component background1 = new Background();
        Component background2 = new Background();
        Component background3 = new Background();
        Component background4 = new Background();
        Component background5 = new Background();
        Component background6 = new Background();
        Component background7 = new Background();
        Component background8 = new Background();
        Component background9 = new Background();
        Component background10 = new Background();
       
        addObject(background1, 50,100);
        component.addChild(background1);
        
        addObject(background2, 50,100);
        component.addChild(background2);
        
        addObject(background3, 50,100);
        component.addChild(background3);
        
        addObject(background4, 50,100);
        component.addChild(background4);
        
        addObject(background5, 50,100);
        component.addChild(background5);
        
        addObject(background6, 750,100);
        component.addChild(background6);
        
        addObject(background7, 750,100);
        component.addChild(background7);
        
        addObject(background8, 750,100);
        component.addChild(background8);
        
        addObject(background9, 750,100);
        component.addChild(background9);
        
        addObject(background10, 750,100);
        component.addChild(background10);
        
      //  addObject(new Information(),300,300);  
        // adding actors to component
    }
    public void act()
    {
       if(pause == false)
       {
          chanceToVehicle();
          chanceToBackground();
          chanceToBonus();
    
       }
    }
    public void chanceToBackground()
    {
       Component backGround = new Background();
       
       if(fastFlag) {
             backGround.setFasterFlag();
         }
        
       if(Greenfoot.getRandomNumber(50)==0)
       {
          addObject(backGround, 50,0);
          component.addChild(backGround);
       }
       if(Greenfoot.getRandomNumber(50)==1)
       {
          addObject(backGround, 750, 0);
          component.addChild(backGround);
       }
    }
    public void chanceToVehicle()
    {
       Component vehicle = new Blockers();
       
       if(fastFlag) {
             vehicle.setFasterFlag();
       }
       
       if(Greenfoot.getRandomNumber(50)<1)
       {
          addObject(vehicle,175+Greenfoot.getRandomNumber(500), 0);
          component.addChild(vehicle);
       }
    
    }
    public void chanceToBonus()
    {
       Component coin = new Coin();
       Component lifeSaver = new LifeSaver();
      
       if(fastFlag) {
             coin.setFasterFlag();
             lifeSaver.setFasterFlag();
       }
       
        if(Greenfoot.getRandomNumber(350)<1)
       {
          addObject(coin,170+Greenfoot.getRandomNumber(500), 0);
          component.addChild(coin);
       }
        if((Greenfoot.getRandomNumber(350)<1) && (!fastFlag))
       {
          addObject(new SpeedBooster(), 170+Greenfoot.getRandomNumber(500), 0);
       }
       if((Greenfoot.getRandomNumber(350)==3) && (!fastFlag))
       {
          addObject(lifeSaver, 170+Greenfoot.getRandomNumber(500), 0);
          component.addChild(lifeSaver);
       }
   
    }
    
    public int getScore()
    {
       return score;
    }
    public void addScore(int scoreToAdd)
    {
       score += scoreToAdd;
    }
    
    public int getSpeed()
    {
       return speed;
    }
    public void addSpeed(int newSpeed)
    {
        speed += newSpeed;
    }
    public void setSpeed(int finalSpeed){
        speed=finalSpeed;
    }
    public void setLives()
    {
        lives--;
    }
    public int getLives()
    {
       return lives;
    }
    public void incLives()
    {
      if(lives<3){
        lives++;
  
    }     
    }
    
     public void collided()
    {
       lives--;
    }
   
       public boolean getPause()
    {
       //state st = new state();
       if(st.getValue() == 0)
       return true;
       else if(st.getValue() == 1)
       return false;
       
       else
       return false;
       //return pause;
    }
    public void setPause()
    {
       st.setValue(); //value = 0
       if(st.getValue() == 0)
       pause = true;
       //else if(st.getValue() == 1)
       //pause = false;
       
       //else
       //pause = false;
    }
    public void unsetPause()
    {
         st.unsetValue(); //value = 1
         if(st.getValue() == 1)
         pause = false;

    }
  
    
    public void setMoveFastFlag(){
        fastFlag = true;
        counter = 0;
    }
    
    public Component getComponent(){
        System.out.println("World component is of size "+ component.getAllChild().size());
        return component;
    }
    
    public ConcreteSubject getSubject(){
        return subject;
    }
    
    public void setLaser(){
        laser--;
    }
    
    public int getLaser(){
        return laser;   
       
    }
}
