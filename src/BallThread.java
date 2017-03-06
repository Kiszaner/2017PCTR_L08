/**
 * Thread that handles a ball moving through a board.
 */
public class BallThread implements Runnable
{

    private Ball ball;
    private Board board;

    /**
     * Constructor.
     *
     * @param ball  the ball to handle
     * @param board the board to handle
     */
    public BallThread(Ball ball, Board board)
    {
        this.ball = ball;
        this.board = board;
    }

    /**
     * Run method.
     */
    @Override
    public void run()
    {
        try
        {
            while (true)
            {
                ball.move();
                ball.reflect();
                board.repaint();
                Thread.sleep(100);
            }
        } catch (InterruptedException e)
        {
            System.out.println("Interrupted.");
        }
    }

}
