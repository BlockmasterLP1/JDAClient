package jdaclient.layouts;

import jdaclient.Main;

import java.awt.*;

public class Theme {

    public static Color backgroundColor;
    public static Color componentsColor;
    public static Color panelColor;
    public static Color menuColor;
    public static Color schriftColor;
    public static Color hoverColor;

    public static void darkmode(){
        backgroundColor = Color.decode("#2F3136");
        componentsColor = Color.decode("#36393F");
        panelColor = Color.decode("#282B30");
        menuColor = Color.decode("#23262A");
        schriftColor = Color.decode("#99AAB5");
        hoverColor = Color.decode("#4d525b");
    }
    public static void whitemode(){
        backgroundColor = Color.decode("#F5F5F5");
        componentsColor = Color.decode("#D8D8D8");
        panelColor = Color.decode("#ECECEC");
        schriftColor = Color.decode("#676767");
        hoverColor = Color.decode("#BFBFBF");
    }

    public Theme(){
        if (Main.theme == 0) {
            darkmode();
        } else if (Main.theme == 1) {
            whitemode();
        } else {
            System.out.println("pech gehabt");
        }
        Main.updateComponents();
    }
}
