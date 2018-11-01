package Fine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyWindow extends JFrame {
    JPanel P0 = new JPanel();
    JTextArea jta = new JTextArea();

    public MyWindow() {
        //Окно
        setBounds(500, 500, 500, 500);
        setTitle("Chat interface");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
    }

    //создание панели сборки
    public void MyWindows() {
        BorderLayout BL0 = new BorderLayout();
        P0.setLayout(BL0);
        add(P0);
        JP1();
        JP2();
    }

    //экран чата
    public void JP1() {
        JPanel P1 = new JPanel();
        BorderLayout BL1 = new BorderLayout();
        P1.setLayout(BL1);
        jta.setEditable(false);
        jta.setBackground(new Color(200, 200, 200));
        JScrollPane jsp = new JScrollPane(jta);
        P1.add(jsp);
        P0.add(P1, BorderLayout.CENTER);
        P1.setVisible(true);
    }

    //поле ввода и кнопка ввода
    public void JP2() {
        JPanel P2 = new JPanel();
        GridLayout Cage2 = new GridLayout(1, 2, 3, 0);
        JButton Send = new JButton("Send");
        JTextField Spam = new JTextField();
        P2.setLayout(Cage2);
        P2.add(Spam);
        P2.add(Send);
        P0.add(P2, BorderLayout.PAGE_END);
        P2.setVisible(true);

        //Слушатели энтера и кнопки
        Spam.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = Spam.getText();
                jta.append(text + "\n");
                Spam.setText("");
            }
        });
        Send.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = Spam.getText();
                jta.append(text + "\n");
                Spam.setText("");
            }
        });
    }
}
