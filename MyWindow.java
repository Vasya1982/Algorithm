package client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class MyWindow extends JFrame {
    private JTextField jtf;
    private JTextArea jta;
    private JTextField loginField;
    private JTextField passField;
   // private final String SERVER_ADDR = "localhost";
   // private final int SERVER_PORT = 8189;
   private Socket socket;
    private DataOutputStream out;
    private DataInputStream in;
    String myNick;
    public void Start() {

        try {
            socket = new Socket("localhost", 8189);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            setAuthorized(false);

            Thread t = new Thread(() -> {
                try {

                    while (true) {
                        String str = in.readUTF();
                        if(str.startsWith("authok")) {
                            setAuthorized(true);
                            myNick = str.split("\\s")[1];
                            break;
                        }
                        jta.append(str + "\n");
                    }

                    while (true) {
                        String str = in.readUTF();
                        if (str.equals("/end")) {
                            break;
                        }
                        jta.append(str + "\n");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        setAuthorized(false);
                        socket.close();
                        myNick="";
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            });
            t.setDaemon(true);
            t.start();
        } catch (IOException e) {

            e.printStackTrace();
        }


        /**
        try {
            sock = new Socket(SERVER_ADDR, SERVER_PORT);
            in = new Scanner(sock.getInputStream());
            out = new PrintWriter(sock.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        */
        setBounds(600, 300, 500, 500);
        setTitle("Client");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jta = new JTextArea();
        jta.setEditable(false);
        jta.setLineWrap(true);
        JScrollPane jsp = new JScrollPane(jta);
        add(jsp, BorderLayout.CENTER);
        JPanel bottomPanel = new JPanel(new BorderLayout());
        add(bottomPanel, BorderLayout.SOUTH);
        JButton jbSend = new JButton("SEND");
        JButton jbSend2 = new JButton("PASS");
        bottomPanel.add(jbSend, BorderLayout.EAST);
        bottomPanel.add(jbSend2, BorderLayout.WEST);
        jtf = new JTextField();
        loginField = new JTextField();
        loginField.setText("login1");
        passField = new JTextField();
        passField.setText("pass1");
        bottomPanel.add(jtf, BorderLayout.CENTER);
        bottomPanel.add(loginField, BorderLayout.NORTH);
        bottomPanel.add(passField, BorderLayout.SOUTH);
        jbSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!jtf.getText().trim().isEmpty()) {
                    sendMsg();
                    jtf.grabFocus();
                }
            }
        });
        jbSend2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onAuthClick();
            }
        });






        jtf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMsg();
            }
        });
        /**
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        if (in.hasNext()) {
                            String w = in.nextLine();
                            if (w.equalsIgnoreCase("end session")) break;
                            jta.append(w);
                            jta.append("\n");
                        }
                    }
                } catch (Exception e) {
                }
            }
        }).start();
         */
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                try {
                   // out.println("end");
                    out.flush();
                    socket.close();
                    out.close();
                    in.close();
                } catch (IOException exc) {
                }
            }
        });
        setVisible(true);
    }

    private void setAuthorized(boolean a) {

    }

    /**
    public void sendMsg() {
        out.println(jtf.getText());
        out.flush();
        jtf.setText("");
    }
     */
    public void onAuthClick() {
      //  try {
      //      out.writeUTF(loginField.getText() + "-" + passField.getText());
          //  loginField.setText(" ");
          //  passField.setText(" ");
       // } catch (Exception e) {
       //     e.printStackTrace();
        //}
        if (socket == null || socket.isClosed())
            Start();
        try {
            out.writeUTF("/auth " + loginField.getText() + " " + passField.getText());
            loginField.setText("");
            passField.setText("");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void sendMsg() {
        try {
            out.writeUTF(jtf.getText());
            jtf.setText("");
        } catch (IOException e) {
            System.out.println("Ошибка отправки сообщения");
        }
    }

}


