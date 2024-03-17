import javax.swing.*;
import java.awt.*;
public class Menu extends JFrame {
    GridBagConstraints gridCoords = new GridBagConstraints();
    public Menu(){
        setTitle("Serwetka v.Java");
        setSize(400,400);
        setVisible(true);
        getContentPane().setBackground(Color.darkGray);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JLabel title = new JLabel("Projekt Serwetka");
        title.setForeground(Color.WHITE);
        title.setBounds(60,50, 300,30);
        title.setFont(new Font("sans-serif",Font.PLAIN,20));
        JButton button = new JButton();
        button.setText("Wykonaj");
        button.setBounds(140,100, 100,50);
        button.setActionCommand("runScript");
        JButton button3 = new JButton();
        button3.setText("Wyjdz");
        button3.setBounds(140,200, 100,50);
        button3.setActionCommand("quit");
        getContentPane().setLayout(null);
        getContentPane().setVisible(true);
        button.setFont(new Font("serif",Font.PLAIN,15));
        button3.setFont(new Font("serif",Font.PLAIN,15));
        button.addActionListener(new ButtonActionListener());
        button3.addActionListener(new ButtonActionListener());
        add(title);  add(button);add(button3);
        setResizable(false);
        System.out.println("Stuff should appear");
    }
    public JFrame getFrame(){
        return this;
    }

}
