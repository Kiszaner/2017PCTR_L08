import java.awt.Image;
import javax.swing.ImageIcon;


/**
 * Class that handles the ball objects.
 */
public class Ball
{

    private String Ball = "./Ball.png";

    private double x, y, dx, dy;
    private double v, fi;
    private Image image;

    /**
     * Constructor.
     */
    public Ball()
    {
        ImageIcon ii = new ImageIcon(this.getClass().getResource(Ball));
        image = ii.getImage();
        x = Billiards.Width / 4 - 16;
        y = Billiards.Height / 2 - 16;
        v = 5;
        fi = Math.random() * Math.PI * 2;
    }

    /**
     * Method that moves the ball along the board.
     */
    public void move()
    {
        v = v * Math.exp(-v / 1000);
        dx = v * Math.cos(fi);
        dy = v * Math.sin(fi);
        if (Math.abs(dx) < 1 && Math.abs(dy) < 1)
        {
            dx = 0;
            dy = 0;
        }
        x += dx;
        y += dy;

        assert isInsideBoard(x, y) : "Out of the Board";
    }

    /**
     * Method that makes the ball reflect when crashing into the walls or another ball.
     */
    public void reflect()
    {
        if (Math.abs(x + 32 - Board.RIGHTBOARD) < Math.abs(dx))
        {
            fi = Math.PI - fi;
        }
        if (Math.abs(y + 32 - Board.BOTTOMBOARD) < Math.abs(dy))
        {
            fi = -fi;
        }
        if (Math.abs(x - Board.LEFTBOARD) < Math.abs(dx))
        {
            fi = Math.PI - fi;
        }
        if (Math.abs(y - Board.TOPBOARD) < Math.abs(dy))
        {
            fi = -fi;
        }

        assert isInsideBoard(x, y) : "Out of the Board";
    }


    public int getX()
    {
        return (int) x;
    }

    public int getY()
    {
        return (int) y;
    }

    public double getFi()
    {
        return fi;
    }

    public double getdr()
    {
        return Math.sqrt(dx * dx + dy * dy);
    }

    public void setX(double x)
    {
        this.x = x;
    }

    public void setY(double y)
    {
        this.y = y;
    }

    public Image getImage()
    {
        return image;
    }

    /**
     * Method that checks the postcondition of the ball being inside the board.
     *
     * @param x coordinate x
     * @param y coordinate y
     * @return true if it is in the board, false if not
     */
    private boolean isInsideBoard(double x, double y)
    {
        return x > Board.LEFTBOARD && x < Board.RIGHTBOARD && y > Board.TOPBOARD && y < Board.BOTTOMBOARD;
    }
}

