package jdaclient.Listener;

import jdaclient.JDAMehodes;
import jdaclient.Main;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.TextChannel;

import javax.security.auth.login.LoginException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionHandler implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Main.startButton){
            if (Main.startButton.getText() == "ON"){
                if (JDAMehodes.shardMan != null){
                    JDAMehodes.stop();
                    Main.server.clear();
                    Main.serverList.removeAllItems();
                }
                if (JDAMehodes.botToken != null){
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

                    Main.server.clear();

                    for (Guild guild : JDAMehodes.shardMan.getGuilds()) {

                        Main.server.add(guild.getName());
                    }
                    Main.serverList.removeAllItems();
                    for (int i = 0; i < Main.server.size(); i++){

                        System.out.println(Main.server.get(i));
                        Main.serverList.addItem(Main.server.get(i));


                    }

                    Main.startButton.setText("OFF");

                }


            }else if (Main.startButton.getText() == "OFF"){


                Main.startButton.setText("ON");
                Main.server.clear();
                Main.serverList.removeAllItems();
                JDAMehodes.stop();
            }
        }

        if (e.getSource() == Main.textField){
            JDAMehodes.shardMan.getGuildById("1002465926366642268").getTextChannelById("1002465927247442002").sendMessage(Main.textField.getText());




            Main.textField.setText("");

        }
        if (e.getSource() == Main.tokenfield){
            Main.bottoken = Main.tokenfield.getText();
            JDAMehodes.botToken = Main.tokenfield.getText();
            Main.textField.setText("");
        }



    }
}
