package jdaclient;

import jdaclient.Listener.ActionHandler;
import jdaclient.layouts.Theme;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static List<String> server = new ArrayList<>();

    public static int theme = 0;

    public static String bottoken = "1";



    //frames
    public static JFrame mainframe;

    //menus
    public static JMenuBar menuBar;
    public static JMenu settings;
    public static JMenu bot;

    public static JMenu token;

    public static JTextField tokenfield;




    //panel
    public static JPanel  listPanel;
    public static JPanel mainPanel;
    public static JPanel chatPanel;

    public static JPanel sideBar;

    public static JPanel infoPanel;

    //components
    public static JButton startButton;
    public static JTextField textField;
    public static JComboBox serverList;

    public static JLabel info;






    public static void main(String[] args) {

        JDAMehodes.botToken = "MTAxNDkzNzg4MTE2NjQ5NTc5NQ.G01Fk-.yQK8N2jtpI2e_wR4UCXFFWCjkvfFu9r7apUpBE";



        frame();
        new Theme();

    }


    public static void frame(){
        //create Frame
        mainframe = new JFrame();
        mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainframe.setVisible(true);
        //panel
        mainPanel = new JPanel();
        mainPanel.setBackground(Color.GREEN);
        mainPanel.setLayout(new BorderLayout(0, 0));

        chatPanel = new JPanel();
        chatPanel.setLayout(new BorderLayout(5 ,5));
        chatPanel.setBorder(new EmptyBorder(20, 15,20,15));
        chatPanel.setPreferredSize(new Dimension(mainPanel.getWidth(), mainPanel.getHeight()));

        sideBar = new JPanel();
        sideBar.setLayout(new BorderLayout(5 ,5));
        sideBar.setBorder(new EmptyBorder(15, 15,15,15));
        sideBar.setPreferredSize(new Dimension(200, mainPanel.getHeight()));

        textField = new JTextField();
        textField.setSize(chatPanel.getWidth(), 100);
        textField.setBorder(new EmptyBorder(5, 5, 5, 5));
        textField.addActionListener(new ActionHandler());

        infoPanel = new JPanel();
        infoPanel.setLayout(null);
        infoPanel.setPreferredSize(new Dimension(sideBar.getWidth(), 50));


        startButton = new JButton("ON");
        startButton.setBounds(0,0,50,50);
        startButton.setBorder(null);
        startButton.setBorderPainted(false);
        startButton.setFocusable(false);
        startButton.addActionListener(new ActionHandler());

        listPanel = new JPanel();
        listPanel.setLayout(null);
        listPanel.setPreferredSize(new Dimension(sideBar.getWidth(), 50));
        listPanel.setBorder(null);

        serverList = new JComboBox();
        serverList.setBounds(0,0,190,50);
        serverList.setBorder(null);
        serverList.setFocusable(false);
        serverList.addActionListener(new ActionHandler());

        tokenfield = new JTextField();
        tokenfield.setBorder(null);
        tokenfield.addActionListener(new ActionHandler());

        info = new JLabel();
        info.setBounds(50,0,100,50);

        info.setFocusable(false);














        //menu

        menuBar = new JMenuBar();
        menuBar.setBorder(null);
        menuBar.setOpaque(true);
        menuBar.setBorderPainted(false);
        settings = new JMenu("Settings");
        bot = new JMenu("Bot");
        token = new JMenu("Setup");


        menuBar.add(settings);
        menuBar.add(bot);

        //bot
        bot.add(token);
        token.add(tokenfield);
        //settings


        //settings
        mainframe.setTitle("Jda Client");

        mainframe.setSize(new Dimension(750, 500));
        mainframe.setMinimumSize(new Dimension(750, 500));


        //add
        listPanel.add(serverList);
        sideBar.add(listPanel, BorderLayout.NORTH);
        sideBar.add(infoPanel, BorderLayout.SOUTH);
        infoPanel.add(info);
        infoPanel.add(startButton);
        chatPanel.add(textField , BorderLayout.SOUTH);
        mainPanel.add(chatPanel , BorderLayout.CENTER);
        mainPanel.add(sideBar , BorderLayout.EAST);

        mainframe.setJMenuBar(menuBar);
        mainframe.setContentPane(mainPanel);
        mainframe.pack();








    }



    public static void updateComponents(){
        menuBar.setBackground(Theme.background);
        menuBar.setForeground(Theme.schrift);

        bot.setBackground(Theme.background);
        bot.setForeground(Theme.schrift);

        settings.setBackground(Theme.background);
        settings.setForeground(Theme.schrift);

        mainPanel.setBackground(Theme.components);
        mainPanel.setForeground(Theme.schrift);

        sideBar.setBackground(Theme.components1);
        sideBar.setForeground(Theme.schrift);

        textField.setBackground(Theme.background);
        textField.setForeground(Theme.schrift);

        infoPanel.setBackground(null);

        startButton.setBackground(Theme.components);
        startButton.setForeground(Theme.schrift);

        serverList.setBackground(null);

        listPanel.setBackground(null);

        serverList.setBackground(null);
        serverList.setForeground(Theme.schrift);

        token.setBackground(Theme.background);
        token.setForeground(Theme.schrift);

        tokenfield.setBackground(Theme.background);
        tokenfield.setForeground(Theme.schrift);



        chatPanel.setBackground(null);

    }

}
