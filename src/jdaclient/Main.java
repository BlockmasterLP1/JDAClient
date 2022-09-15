package jdaclient;

import jdaclient.Listener.ActionHandler;
import jdaclient.layouts.Theme;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static List<String> server = new ArrayList<>();
    public static int theme = 2;

    //frames
    public static JFrame mainframe;

    //menus
    public static JMenuBar menuBar;
    public static JMenu settings;
    public static JMenu themeSelection;
    public static JMenuItem darkmode;
    public static JMenuItem whitemode;
    public static JMenuItem purplemode;
    public static JMenu bot;
    public static JMenuItem token;

    //panel
    public static JPanel mainPanel;
    public static JPanel chatPanel;
    public static JPanel sideBar;
    public static JPanel infoPanel;
    public static JPanel listPanel;

    //components
    public static JButton startButton;
    public static JTextField textField;
    public static JComboBox serverList;
    public static JComboBox chatList;
    public static JLabel botTokenLabel;
    public static JTextField botToken;

    //chat
    public static JTextArea chatField;


    /*public static  void bufferreader(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String test = null;
        try {
            test = reader.readLine();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        chatField.append(test + "\n");
    }*/

    public static void main(String[] args) {
        JDAMethodes.botToken = "MTAxNDkzNzg4MTE2NjQ5NTc5NQ.GMaRCH.Y9mGVDBsXBmBZwN70PwTaqiKYSud4reloCDhKk";

        frame();
        new Theme();

        /*while (true)
        {
            bufferreader();
        }*/
    }

    public static void frame() {
        mainframe = new JFrame();
        mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainframe.setVisible(true);
        mainframe.setTitle("Jda Client");
        mainframe.setSize(new Dimension(750, 500));
        mainframe.setMinimumSize(new Dimension(750, 500));

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

        infoPanel = new JPanel();
        infoPanel.setLayout(null);
        infoPanel.setPreferredSize(new Dimension(sideBar.getWidth(), 50));

        listPanel = new JPanel();
        listPanel.setLayout(null);
        listPanel.setPreferredSize(new Dimension(sideBar.getWidth(), 50));
        listPanel.setBorder(null);

        startButton = new JButton("ON");
        startButton.setBounds(0,0,50,50);
        startButton.setBorder(null);
        startButton.setBorderPainted(false);
        startButton.setFocusable(false);
        startButton.addActionListener(new ActionHandler());

        textField = new JTextField();
        textField.setSize(chatPanel.getWidth(), 100);
        textField.setBorder(new EmptyBorder(5, 5, 5, 5));
        textField.addActionListener(new ActionHandler());

        serverList = new JComboBox();
        serverList.setBounds(0,0,190,50);
        serverList.setBorder(null);
        serverList.setFocusable(false);
        serverList.addActionListener(new ActionHandler());

        chatList = new JComboBox();
        chatList.setBounds(0,150,190,50);
        chatList.setBorder(null);
        chatList.setFocusable(false);

        botTokenLabel = new JLabel();

        botToken = new JTextField();
        botToken.setBorder(new EmptyBorder(2, 2, 2, 2));
        botToken.setText(JDAMethodes.botToken);

        chatField = new JTextArea();
        chatField.setSize(chatPanel.getWidth(), 100);
        chatField.setBorder(new EmptyBorder(5, 5, 5, 5));
        chatField.setEditable(false);

        //menus
        menuBar = new JMenuBar();
        //menuBar.setBorderPainted(false);

        settings = new JMenu("Settings");

        themeSelection = new JMenu("Theme");

        darkmode = new JMenuItem("Darkmode");
        darkmode.addActionListener(new ActionHandler());

        whitemode = new JMenuItem("Whitemode");
        whitemode.addActionListener(new ActionHandler());

        purplemode = new JMenuItem("Purplemode");
        purplemode.addActionListener(new ActionHandler());

        bot = new JMenu("Bot");

        token = new JMenuItem("Token");
        token.addActionListener(new ActionHandler());

        //add
        listPanel.add(serverList);
        listPanel.add(chatList);
        sideBar.add(listPanel, BorderLayout.NORTH);
        sideBar.add(infoPanel, BorderLayout.SOUTH);
        infoPanel.add(startButton);
        chatPanel.add(textField , BorderLayout.SOUTH);
        mainPanel.add(chatPanel , BorderLayout.CENTER);
        mainPanel.add(sideBar , BorderLayout.EAST);
        chatPanel.add(chatField);

        menuBar.add(settings);
        settings.add(themeSelection);
        themeSelection.add(darkmode);
        themeSelection.add(whitemode);
        themeSelection.add(purplemode);
        menuBar.add(bot);
        bot.add(token);



        mainframe.setJMenuBar(menuBar);
        mainframe.setContentPane(mainPanel);
        mainframe.pack();
    }

    public static void updateComponents() {
        //tokenPane
        UIManager.put("OptionPane.background", Theme.backgroundColor);
        UIManager.put("Panel.background", Theme.backgroundColor);
        UIManager.put("Button.background", Theme.componentsColor);
        UIManager.put("Button.foreground", Theme.schriftColor);
        UIManager.put("Button.border", (BorderFactory.createLineBorder(Theme.componentsColor, 5)));
        UIManager.put("Button.select", Theme.hoverColor);
        UIManager.put("Button.focus", new ColorUIResource(new Color(0, 0, 0, 0)));

        //menus
        /*UIManager.put("PopupMenu.border", null);
        UIManager.put("MenuBar.opaque", true);
        UIManager.put("MenuBar.selectionBackground", Theme.hoverColor);
        UIManager.put("Menu.opaque", true);
        UIManager.put("Menu.selectionBackground", Theme.hoverColor);
        UIManager.put("MenuItem.opaque", true);
        UIManager.put("MenuItem.selectionBackground", Theme.hoverColor);*/

        menuBar.setBackground(Theme.menuColor);
        menuBar.setForeground(Theme.schriftColor);
        menuBar.setBorder(new LineBorder(Theme.menuColor));

        settings.setBackground(Theme.menuColor);
        settings.setForeground(Theme.schriftColor);
        settings.setBorder(new LineBorder(Theme.menuColor));
        settings.getPopupMenu().setBackground(Theme.menuColor);
        settings.getPopupMenu().setBorder(new LineBorder(Theme.menuColor, 2));

        themeSelection.setBackground(Theme.menuColor);
        themeSelection.setForeground(Theme.schriftColor);
        themeSelection.setBorder(new LineBorder(Theme.menuColor));
        themeSelection.getPopupMenu().setBackground(Theme.menuColor);
        themeSelection.getPopupMenu().setBorder(new LineBorder(Theme.menuColor, 2));

        whitemode.setBackground(Theme.menuColor);
        whitemode.setForeground(Theme.schriftColor);
        whitemode.setBorder(new LineBorder(Theme.menuColor));

        darkmode.setBackground(Theme.menuColor);
        darkmode.setForeground(Theme.schriftColor);
        darkmode.setBorder(new LineBorder(Theme.menuColor));

        purplemode.setBackground(Theme.menuColor);
        purplemode.setForeground(Theme.schriftColor);
        purplemode.setBorder(new LineBorder(Theme.menuColor));

        bot.setBackground(Theme.menuColor);
        bot.setForeground(Theme.schriftColor);
        bot.setBorder(new LineBorder(Theme.menuColor));
        bot.getPopupMenu().setBackground(Theme.menuColor);
        bot.getPopupMenu().setBorder(new LineBorder(Theme.menuColor, 2));

        token.setBackground(Theme.menuColor);
        token.setForeground(Theme.schriftColor);
        token.setBorder(new LineBorder(Theme.menuColor));

        chatField.setBackground(Theme.componentsColor);
        chatField.setForeground(Theme.schriftColor);

        //panels
        mainPanel.setBackground(Theme.backgroundColor);
        mainPanel.setForeground(Theme.schriftColor);
        chatPanel.setBackground(null);
        sideBar.setBackground(Theme.panelColor);
        sideBar.setForeground(Theme.schriftColor);
        infoPanel.setBackground(null);
        listPanel.setBackground(null);

        //components
        startButton.setBackground(Theme.componentsColor);
        startButton.setForeground(Theme.schriftColor);
        textField.setBackground(Theme.componentsColor);
        textField.setForeground(Theme.schriftColor);
        textField.setCaretColor(Theme.schriftColor);
        serverList.setBackground(null);
        chatList.setBackground(null);
        botTokenLabel.setForeground(Theme.schriftColor);
        botToken.setBackground(Theme.componentsColor);
        botToken.setForeground(Theme.schriftColor);
        botToken.setCaretColor(Theme.schriftColor);
    }



}
