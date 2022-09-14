package jdaclient;

import jdaclient.Listener.ActionHandler;
import jdaclient.layouts.Theme;
<<<<<<< Updated upstream
import net.dv8tion.jda.api.entities.Guild;
=======
>>>>>>> Stashed changes

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import jdaclient.Listener.ActionHandler.*;

public class Main {

    public static String botToken = "1";
    public static List<String> server = new ArrayList<>();
    public static int theme = 0;

    //frames
    public static JFrame mainFrame;

    //menus
    public static JMenuBar menuBar;
    public static JMenu settings;
    public static JMenu bot;
    public static JMenuItem token;

<<<<<<< Updated upstream
    public static JMenu them;
    public static JMenuItem darkmode;
    public static JMenuItem whitemode;

    public  static  JMenuItem token;

    //panel
    public static JPanel  listPanel;
=======
    //panels
>>>>>>> Stashed changes
    public static JPanel mainPanel;
    public static JPanel chatPanel;
    public static JPanel sideBar;
    public static JPanel infoPanel;
    public static JPanel listPanel;
    public static JPanel tokenPanel;

    //components
    public static JButton startButton;
    public static JTextField textField;
    public static JComboBox serverList;
<<<<<<< Updated upstream
    public static  JComboBox chatList;

    public static void main(String[] args) {

        JDAMehodes.botToken = "MTAxNDkzNzg4MTE2NjQ5NTc5NQ.GMBfha.tpNahRd0oRTKymNEkkIAPfTPVrRkmn9icZKpKs";
=======

    public static JLabel tokenLabel;
    public static JTextField tokenField;

    public static JLabel info;

    public static void main(String[] args) {
        JDAMehodes.botToken = "MTAxNDkzNzg4MTE2NjQ5NTc5NQ.G01Fk-.yQK8N2jtpI2e_wR4UCXFFWCjkvfFu9r7apUpBE";
>>>>>>> Stashed changes

        frame();
        new Theme();
    }

<<<<<<< Updated upstream
    public static void frame()
    {
        //create Frame
        mainframe = new JFrame();
        mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainframe.setVisible(true);
        //panel
=======

    public static void frame(){
        mainFrame = new JFrame();
        mainFrame.setTitle("Jda Client");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
        mainFrame.setSize(new Dimension(750, 500));
        mainFrame.setMinimumSize(new Dimension(750, 500));

>>>>>>> Stashed changes
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

<<<<<<< Updated upstream
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
=======
        tokenPanel = new JPanel();
        tokenPanel.setSize(500, 500);

        tokenLabel = new JLabel("Bot Token");

        tokenField = new JTextField();
        tokenField.setBorder(null);
        tokenField.addActionListener(new ActionHandler());

        info = new JLabel();
        info.setBounds(50,0,100,50);

        info.setFocusable(false);
>>>>>>> Stashed changes

        //menu
        menuBar = new JMenuBar();
        menuBar.setBorder(null);
        menuBar.setOpaque(true);
        menuBar.setBorderPainted(false);
        menuBar.setFocusable(false);

        settings = new JMenu("Settings");
<<<<<<< Updated upstream
        bot = new JMenu("Bot");
=======
        settings.setBorder(null);
        settings.setOpaque(true);
        settings.setBorderPainted(false);
        settings.setFocusable(false);
>>>>>>> Stashed changes

        bot = new JMenu("Bot");
        bot.setBorder(null);
        bot.setOpaque(true);
        bot.setBorderPainted(false);
        bot.setFocusable(false);

        token = new JMenuItem("Token");
        token.setBorder(null);
        token.setOpaque(true);
        token.setBorderPainted(false);
        token.addActionListener(new ActionHandler());
        token.setFocusable(false);

        menuBar.add(settings);
        menuBar.add(bot);
<<<<<<< Updated upstream
        settings.add(them);
        bot.add(token);
        them.add(darkmode);
        them.add(whitemode);


        //settings


        //settings
        mainframe.setTitle("Jda Client");

        mainframe.setSize(new Dimension(750, 500));
        mainframe.setMinimumSize(new Dimension(750, 500));
=======
        bot.add(token);
>>>>>>> Stashed changes

        //add
        listPanel.add(serverList);
        listPanel.add(chatList);
        sideBar.add(listPanel, BorderLayout.NORTH);
        sideBar.add(infoPanel, BorderLayout.SOUTH);
        infoPanel.add(startButton);
        chatPanel.add(textField , BorderLayout.SOUTH);
        mainPanel.add(chatPanel , BorderLayout.CENTER);
        mainPanel.add(sideBar , BorderLayout.EAST);

<<<<<<< Updated upstream
        mainframe.setJMenuBar(menuBar);
        mainframe.setContentPane(mainPanel);
        mainframe.pack();

=======
        mainFrame.setJMenuBar(menuBar);
        mainFrame.setContentPane(mainPanel);
        mainFrame.pack();
>>>>>>> Stashed changes
    }

    public static void updateComponents(){
        //tokenPane
        UIManager.put("OptionPane.background", Theme.components);
        UIManager.put("Panel.background", Theme.components);
        UIManager.put("Button.background", Theme.background);
        UIManager.put("Button.foreground", Theme.schrift);
        UIManager.put("Button.border", (BorderFactory.createLineBorder(Theme.background, 5)));
        UIManager.put("Button.select", Theme.hover);
        UIManager.put("Button.focus", new ColorUIResource(new Color(0, 0, 0, 0)));

        //menus
        UIManager.put("PopupMenu.border", new LineBorder(Theme.background));
        UIManager.put("MenuBar.opaque", true);
        UIManager.put("MenuBar.selectionBackground", Theme.hover);
        UIManager.put("Menu.opaque", true);
        UIManager.put("Menu.selectionBackground", Theme.hover);
        UIManager.put("MenuItem.opaque", true);
        UIManager.put("MenuItem.selectionBackground", Theme.hover);

        menuBar.setBackground(Theme.background);
        menuBar.setForeground(Theme.schrift);

        settings.setBackground(Theme.background);
        settings.setForeground(Theme.schrift);

        bot.setBackground(Theme.background);
        bot.setForeground(Theme.schrift);
        bot.getPopupMenu().setBorder(BorderFactory.createLineBorder(Theme.background, 3));

        token.setBackground(Theme.background);
        token.setForeground(Theme.schrift);

        //panels
        mainPanel.setBackground(Theme.components);
        mainPanel.setForeground(Theme.schrift);

        infoPanel.setBackground(null);

        sideBar.setBackground(Theme.components1);
        sideBar.setForeground(Theme.schrift);

        listPanel.setBackground(null);

        tokenPanel.setBackground(Theme.components);
        tokenPanel.setForeground(Theme.schrift);

        //components
        textField.setBackground(Theme.background);
        textField.setForeground(Theme.schrift);

        startButton.setBackground(Theme.components);
        startButton.setForeground(Theme.schrift);

        serverList.setBackground(null);

<<<<<<< Updated upstream
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
=======
        serverList.setBackground(Theme.background);
        serverList.setForeground(Theme.schrift);

        tokenLabel.setBackground(Theme.schrift);
        tokenLabel.setForeground(Theme.schrift);

        tokenField.setBackground(Theme.background);
        tokenField.setForeground(Theme.schrift);

        chatPanel.setBackground(null);
>>>>>>> Stashed changes
    }
}
