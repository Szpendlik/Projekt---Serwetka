import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class ButtonActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equals("runScript"))
        {
            System.out.println("Starting...");
            JFrame mainFrame = new JFrame("Triangles");

            mainFrame.setSize(1000,300);
            JLabel mes=new JLabel("Liczba calkowita > 0: ");
            mes.setFont(new Font("sans-serif,plain",Font.PLAIN,20));
            mes.setForeground(Color.WHITE);
            mes.setBounds(30,50,200,50);
            JTextArea textArea = new JTextArea();
            textArea.setBounds(230,50,700,60);
            mainFrame.getContentPane().add(mes);
            JButton submit = new JButton("Submit");
            submit.setBounds(50,150,90,30);
            JLabel resLabel=new JLabel();
            resLabel.setText("Script result: ");
            resLabel.setBounds(425,200,100,30);
            JLabel result =new JLabel();
            resLabel.setVisible(false);
            result.setVisible(false);
            result.setBounds(525,200,100,30);
            resLabel.setForeground(Color.WHITE);
            result.setForeground(Color.WHITE);

            submit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int num = Integer.parseInt(textArea.getText());
                    Serwetka serwetka = new Serwetka(num);
                    serwetka.Serwetka_wykonaj();
                    resLabel.setVisible(true);
                    result.setVisible(true);
                }
            });

            mainFrame.getContentPane().setLayout(null);
            mainFrame.getContentPane().setVisible(true);
            mainFrame.setResizable(false);
            textArea.setBackground(Color.lightGray);
            mainFrame.getContentPane().setBackground(Color.darkGray);
            mainFrame.getContentPane().add(textArea);
            mainFrame.getContentPane().add(submit);
            mainFrame.getContentPane().add(result);
            mainFrame.getContentPane().add(resLabel);
            mainFrame.setVisible(true);
        }

        if(command.equals("Do"))
        {
            Serwetka serwetka = new Serwetka(5);
            serwetka.Serwetka_wykonaj();
        }


        if(command.equals("quit"))
        {
            System.out.println("Exiting...");
            JFrame quitConfirm = new JFrame("Quit");
            quitConfirm.getContentPane().setBackground(Color.darkGray);
            quitConfirm.setSize(400,250);
            JLabel mes=new JLabel("Do you want to quit?");
            JButton yes=new JButton("Yes");
            JButton no=new JButton("No");
            yes.setActionCommand("exit");
            quitConfirm.setResizable(false);
            mes.setBounds(145,50,200,50);
            yes.setBounds(80,100,80,50);
            no.setBounds(240,100,80,50);
            quitConfirm.getContentPane().setLayout(null);
            quitConfirm.getContentPane().setVisible(true);
            no.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) { quitConfirm.dispose();
                }
            });
            yes.addActionListener(new ButtonActionListener());
            mes.setForeground(Color.WHITE);
            quitConfirm.add(mes);
            quitConfirm.add(yes);
            quitConfirm.add(no);
            quitConfirm.setVisible(true);
        }
        if(command.equals("exit"))
        {
            System.exit(0);
        }
    }
}
