package jdaclient.layouts;

import jdaclient.Main;

import java.awt.*;

public class Theme {

    public static Color background;
    public static Color components;
    public static Color components1;
    public static Color schrift;
    public static Color hover;
    public static void darkmode(){
        background = Color.decode("#2F3136");
        components = Color.decode("#36393F");
        components1 = Color.decode("#202225");
        schrift = Color.decode("#99AAB5");
        hover = Color.decode("#4d525b");

    }
    public static void whitemode(){
        background = Color.decode("#F5F5F5");
        components = Color.decode("#D8D8D8");
        components1 = Color.decode("#ECECEC");
        schrift = Color.decode("#676767");
        hover = Color.decode("#BFBFBF");

    }

    public Theme(){
        if (Main.theme == 0)
        {
            darkmode();
        }else if (Main.theme == 1)
        {
            whitemode();
        }else
        {
            System.out.println("pech gehabt");
        }
        Main.updateComponents();
    }
}
