package jdaclient.Listener;

import jdaclient.JDAMehodes;
import jdaclient.Main;
import jdaclient.layouts.Theme;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;

import javax.security.auth.login.LoginException;
import javax.swing.*;
<<<<<<< Updated upstream
import java.awt.*;
=======
>>>>>>> Stashed changes
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static jdaclient.Main.*;
import static jdaclient.JDAMehodes.*;
import static jdaclient.layouts.Theme.*;

public class ActionHandler implements ActionListener {

    public static JFrame tokenframe;
    public static  JTextField tokenfl;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Main.startButton) {
            if (Main.startButton.getText() == "ON") {
                if (JDAMehodes.shardMan != null) {
                    JDAMehodes.stop();
                    Main.server.clear();
                    Main.serverList.removeAllItems();
                }
                if (JDAMehodes.botToken != null) {
                    try {
                        JDAMehodes.build(JDAMehodes.botToken);
                    } catch (LoginException | InterruptedException ex) {
                        throw new RuntimeException(ex);
                    }
                    try {
                        JDAMehodes.shardMan.awaitReady();
                    } catch (InterruptedException ex) {
                        throw new RuntimeException(ex);
                    }
                    JDAMehodes.serverList();
                    Main.startButton.setText("OFF");
                }
<<<<<<< Updated upstream


            }else if (Main.startButton.getText() == "OFF") {


=======
            } else if (Main.startButton.getText() == "OFF") {
>>>>>>> Stashed changes
                Main.startButton.setText("ON");
                Main.server.clear();
                Main.serverList.removeAllItems();
                JDAMehodes.stop();
            }
        }

        if (e.getSource() == Main.textField) {
            JDAMehodes.shardMan.getGuildById("1002465926366642268").getTextChannelById("1002465927247442002").sendMessage(Main.textField.getText());

            Main.textField.setText("");
<<<<<<< Updated upstream

        }

        if (e.getSource() == Main.whitemode){
            theme = 1;
            whitemode();
            updateComponents();
        }

        if (e.getSource() == Main.darkmode) {
            theme = 0;
            darkmode();
            updateComponents();
        }

        if (e.getSource() == token) {
            tokenframe = new JFrame("Bot");
            tokenframe.setSize(300, 200);
            tokenframe.setVisible(true);

            tokenfl = new JTextField();
            tokenfl.setSize(100, 50);
            tokenfl.setBorder(null);
            tokenfl.addActionListener(new ActionHandler());

            tokenframe.add(tokenfl, BorderLayout.CENTER);


        }

        if (e.getSource() == tokenfl) {
            JDAMehodes.botToken = tokenfl.getText();
            System.out.println(tokenfl.getText());
            tokenfl.setText("");

        }
=======
        }

        if (e.getSource() == Main.tokenField) {
            Main.botToken = Main.tokenField.getText();
            JDAMehodes.botToken = Main.tokenField.getText();
            Main.textField.setText("");
        }

        if (e.getSource() == Main.token) {
            Object[] inputFields = { Main.tokenLabel, Main.tokenField };
            int setupPane = JOptionPane.showConfirmDialog(null, inputFields, "Bot Setup", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
>>>>>>> Stashed changes

            if(setupPane == JOptionPane.OK_OPTION) {
                JDAMehodes.botToken = Main.tokenField.getText();
            }
        }
    }
}
