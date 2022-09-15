package jdaclient.Listener;

import jdaclient.JDAMethodes;
import jdaclient.Main;
import jdaclient.layouts.Theme;
import net.dv8tion.jda.api.entities.Channel;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.MessageHistory;

import javax.security.auth.login.LoginException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

public class ActionHandler implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == Main.startButton) {
            if(Main.startButton.getText() == "ON") {
                if(JDAMethodes.shardMan != null) {
                    JDAMethodes.stop();
                    Main.server.clear();
                    Main.serverList.removeAllItems();
                }
                if(JDAMethodes.botToken != null) {
                    try {
                        JDAMethodes.build(JDAMethodes.botToken);
                    } catch(LoginException | InterruptedException ex) {
                        throw new RuntimeException(ex);
                    }
                    try {
                        JDAMethodes.shardMan.awaitReady();
                    } catch(InterruptedException ex) {
                        throw new RuntimeException(ex);
                    }

                    Main.server.clear();
                    for(Guild guild : JDAMethodes.shardMan.getGuilds()) {
                        String server = guild.getName() + " | " + guild.getId();
                        Main.server.add(server);
                    }
                    Main.serverList.removeAllItems();
                    for(int i = 0; i < Main.server.size(); i++){
                        System.out.println(Main.server.get(i));
                        Main.serverList.addItem(Main.server.get(i));
                    }

                    if(Main.serverList.getSelectedItem() != null) {
                        String listItem = Main.serverList.getSelectedItem().toString();
                        String itemId[] = listItem.split(Pattern.quote(" | "));
                        for(Channel channel : JDAMethodes.shardMan.getGuildById(itemId[1]).getTextChannels()) {
                            /*JList channelChat = new JList();
                            channelChat.setName(channel.getName());
                            MessageHistory history = MessageHistory.getHistoryFromBeginning(); //MessageHistory.getHistoryFromBeginning(JDAMethodes.shardMan.getC).complete();
                            List<Message> mess = history.getRetrievedHistory();

                            Main.chatPane.add(channelChat);*/
                        }
                    }

                    Main.startButton.setText("OFF");
                }
            } else if(Main.startButton.getText() == "OFF") {
                Main.server.clear();
                Main.serverList.removeAllItems();

                JDAMethodes.stop();

                Main.startButton.setText("ON");
            }
        }

        if(e.getSource() == Main.textField) {
            JDAMethodes.shardMan.getGuildById("1002465926366642268").getTextChannelById("1002465927247442002").sendMessage(Main.textField.getText());

            Main.textField.setText("");
        }

        if(e.getSource() == Main.whitemode) {
            Main.theme = 1;
            Theme.whitemode();
            Main.updateComponents();
        }

        if(e.getSource() == Main.darkmode) {
            Main.theme = 0;
            Theme.darkmode();
            Main.updateComponents();
        }

        if(e.getSource() == Main.token) {
            Object[] inputFields = {Main.botTokenLabel, Main.botToken};
            int setupPane = JOptionPane.showConfirmDialog(null, inputFields, "Bot Setup", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            if(setupPane == JOptionPane.OK_OPTION) {
                JDAMethodes.botToken = Main.botToken.getText();
            }
        }
    }
}
