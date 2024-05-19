/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aps;

import enums.ColorTheme;
import java.awt.Color;

/**
 *
 * @author guilh
 */
public class Colors {

    private static Color light;
    private static Color lightLightness;
    private static Color lightDarkness;

    private static Color primaryLight;
    private static Color primary;

    private static Color text;
    private static ColorTheme theme;

    public static void setTheme(ColorTheme theme) {
        Colors.theme = theme;
        
        switch (theme) {
            case LIGHT -> {
                light = Color.WHITE;
                lightLightness = Color.decode("#f4f4f4");
                lightDarkness = Color.decode("#dddddd");

                primaryLight = Color.decode("#4b7bec");
                primary = Color.decode("#3867d6");

                text = Color.decode("#333333");
            }

            case DARK -> {
                light = Color.decode("#1d1d1d");
                lightLightness = Color.decode("#222222");
                lightDarkness = Color.decode("#2b2b2b");

                primaryLight = Color.decode("#759CFA");
                primary = Color.decode("#4C7BEB");

                text = Color.decode("#eeeeee");
            }
        }
    }

    public static Color getLight() {
        return light;
    }

    public static Color getLightLightness() {
        return lightLightness;
    }

    public static Color getLightDarkness() {
        return lightDarkness;
    }

    public static Color getPrimaryLight() {
        return primaryLight;
    }

    public static Color getPrimary() {
        return primary;
    }

    public static Color getText() {
        return text;
    }
    
    public static boolean isDarkTheme(){
        return theme.equals(ColorTheme.DARK);
    }
}
