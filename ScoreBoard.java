import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)
import java.awt.Color;
import java.awt.Font;
import java.util.Calendar;

/**
 * The ScoreBoard is used to display results on the screen. It can display some
 * text and several numbers.
 * 
 * @author M Kolling
 * @version 1.0
 */
public class ScoreBoard extends Actor
{
    public static final float FONT_SIZE = 48.0f;
    public static final int WIDTH = 400;
    public static final int HEIGHT = 300;
    
   
    public ScoreBoard(int score, int lives)
    {
       makeImage("Game Over", "Score: ", "Lives: ", score, lives);
    }

    /**
     * Make the score board image.
     */
    private void makeImage(String title, String prefix1, String prefix2, int score, int lives)
    {
        GreenfootImage image = new GreenfootImage(WIDTH, HEIGHT);

        image.setColor(new Color(0, 0, 0, 160));
        image.fillRect(0, 0, WIDTH, HEIGHT);
        image.setColor(new Color(255, 255, 255, 100));
        image.fillRect(5, 5, WIDTH-10, HEIGHT-10);
        Font font = image.getFont();
        font = font.deriveFont(FONT_SIZE);
        image.setFont(font);
        image.setColor(Color.WHITE);
        image.drawString(title, 60, 100);
        image.drawString(prefix1 + score, 60, 200);
        image.drawString(prefix2 + lives, 60, 250);
        setImage(image);
    }
}
