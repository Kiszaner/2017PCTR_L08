import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import javax.swing.JPanel;

/**
 * Class that handles the board.
 */
@SuppressWarnings("serial")
public class Board extends JPanel
{

    private Ball aBalls[];

    public static final int LEFTBOARD = 10;
    public static final int RIGHTBOARD = Billiards.Width - 20;
    public static final int TOPBOARD = 10;
    public static final int BOTTOMBOARD = Billiards.Height - 80;

    /**
     * Constructor.
     */
    public Board()
    {
        setFocusable(true);
        setBackground(Color.BLACK);
        setDoubleBuffered(true);
    }

    /**
     * Method that paints the board.
     *
     * @param g graphics library.
     */
    public void paint(Graphics g)
    {
        super.paint(g);

        Graphics2D g2d = (Graphics2D) g;
        if (aBalls != null)
        {
            for (int i = 0; i < aBalls.length; i++)
            {
                g2d.drawImage(aBalls[i].getImage(), aBalls[i].getX(),
                        aBalls[i].getY(), this);
            }
        }
        g2d.setColor(Color.white);
        g2d.drawLine(RIGHTBOARD, 0, RIGHTBOARD, Billiards.Height);
        g2d.drawLine(LEFTBOARD, 0, LEFTBOARD, Billiards.Height);
        g2d.drawLine(0, TOPBOARD, Billiards.Width, TOPBOARD);
        g2d.drawLine(0, BOTTOMBOARD, Billiards.Width, BOTTOMBOARD);
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }

    /**
     * Method that places the balls on the board.
     *
     * @param balls balls to place.
     */
    public void setBalls(Ball[] balls)
    {
        aBalls = balls;
    }

}