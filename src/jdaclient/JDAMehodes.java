package jdaclient;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Guild;

public class JDAMehodes {

    public static JDABuilder builder;
    public static JDA shardMan;

    public static String botToken;
    public static String botActivity;
    public static Activity.ActivityType botActivityType;

    public static void build(String token) throws LoginException, InterruptedException {
        builder = JDABuilder.createDefault(token);
        shardMan = builder.build();

        botToken = token;

        if (botActivityType != null || botActivity != null) {
            setActivity(botActivityType, botActivity);
        }

        System.out.println("[JDA Client] Bot ready!");
    }

    public static void stop() {
        //builder.setStatus(OnlineStatus.OFFLINE);
        shardMan.shutdown();

        System.out.println("[JDA Client] Bot offline!");
    }

    public static void setActivity(Activity.ActivityType activityType, String activity) throws InterruptedException {
        shardMan.awaitReady();
        shardMan.getPresence().setActivity(Activity.of(activityType, activity));

        botActivityType = activityType;
        botActivity = activity;

        System.out.println("[JDA Client] Set activity to " + activityType + ": " + activity + "!");
    }

    //setzt die Server in der ServerList Combobox
    public static void serverList() {
        Main.server.clear();
        for (Guild guild : JDAMehodes.shardMan.getGuilds()) {
            Main.server.add(guild.getName());
        }
        Main.serverList.removeAllItems();
        for (int i = 0; i < Main.server.size(); i++) {
            System.out.println(Main.server.get(i));
            Main.serverList.addItem(Main.server.get(i));
        }
    }

    public static void channelList() {

    }

    public static void memberList() {

    }
}
