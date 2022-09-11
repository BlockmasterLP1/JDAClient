package jdaclient;

import jdaclient.Listener.ActionHandler;
import jdaclient.layouts.Theme;
import net.dv8tion.jda.api.entities.Guild;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import jdaclient.Listener.ActionHandler.*;

public class Main {

    public static List<String> server = new ArrayList<>();

    public static int theme = 0;

    //frames
    public static JFrame mainframe;

    //menus
    public static JMenuBar menuBar;
    public static JMenu settings;
    public static JMenu bot;

    public static JMenu them;
    public static JMenuItem darkmode;
    public static JMenuItem whitemode;

    public  static  JMenuItem token;

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
    public static  JComboBox chatList;

    public static void main(String[] args) {

        JDAMehodes.botToken = "MTAxNDkzNzg4MTE2NjQ5NTc5NQ.GMBfha.tpNahRd0oRTKymNEkkIAPfTPVrRkmn9icZKpKs";

        frame();
        new Theme();

    }

    public static void frame()
    {
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

        chatList = new JComboBox();
        chatList.setBounds(0,150,190,50);
        chatList.setBorder(null);
        chatList.setFocusable(false);

        them = new JMenu("Theme");

        darkmode = new JMenuItem("Darkmode");
        darkmode.addActionListener(new ActionHandler());

        whitemode = new JMenuItem("Whitemode");
        whitemode.addActionListener(new ActionHandler());

        token = new JMenuItem("Token");
        token.addActionListener(new ActionHandler());

        //menu
        menuBar = new JMenuBar();
        menuBar.setBorder(null);
        menuBar.setOpaque(true);
        menuBar.setBorderPainted(false);
        settings = new JMenu("Settings");
        bot = new JMenu("Bot");


        menuBar.add(settings);
        menuBar.add(bot);
        settings.add(them);
        bot.add(token);
        them.add(darkmode);
        them.add(whitemode);


        //settings


        //settings
        mainframe.setTitle("Jda Client");

        mainframe.setSize(new Dimension(750, 500));
        mainframe.setMinimumSize(new Dimension(750, 500));

        //add
        listPanel.add(serverList);
        listPanel.add(chatList);
        sideBar.add(listPanel, BorderLayout.NORTH);
        sideBar.add(infoPanel, BorderLayout.SOUTH);
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

        chatList.setBackground(null);

        listPanel.setBackground(null);

        chatPanel.setBackground(null);

        them.setBackground(Theme.background);
        them.setForeground(Theme.schrift);

        whitemode.setBackground(Theme.background);
        whitemode.setForeground(Theme.schrift);

        darkmode.setBackground(Theme.background);
        darkmode.setForeground(Theme.schrift);

        token.setBackground(Theme.background);
        token.setForeground(Theme.schrift);

        ActionHandler.tokenfl.setBackground(Theme.background);
    }
}
