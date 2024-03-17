import javax.swing.*;
import java.awt.*;

public class Serwetka extends JFrame{

    private int n;

    public Serwetka(Integer n)
    {
        this.n = n;
    }


    public void Serwetka_wykonaj()
    {
        JFrame frame = new JFrame();
        frame.setSize(800,800); //rozmiar ramki
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        Container contantPane = frame.getContentPane();

        Turtle turtle = new Turtle(400,400); //początkowa pozycja
        contantPane.add(turtle);

        turtle.penDown();

        for(int i=0; i < this.n; i++)
        {
            for(int k =  0; k < 4; k++)
            {
                for(int m=0; m < 1; m++)
                {
                    turtle.right(90);
                    turtle.forward(50);
                    turtle.left(90);
                    turtle.forward(50);
                    turtle.left(90);
                    turtle.forward(50);

                    if (i > 0)
                    {
                        turtle.right(90);
                        for (int t = 0; t < 2 * i; t++)
                        {
                            turtle.forward(50);
                            turtle.left(90);
                            turtle.forward(50);
                            turtle.right(90);
                        }
                    }
                    if (i > 0)
                    {
                        turtle.left(90);
                    }
                }

            }
            turtle.penUp();
            turtle.goTo(400 + 50 * 2 + 50 * i * 2, 400);
            turtle.penDown();
        }

        frame.setVisible(true);
    }

}