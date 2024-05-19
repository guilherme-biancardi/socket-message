/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aps;

import enums.PageEnum;
import java.util.HashMap;
import javax.swing.JFrame;

/**
 *
 * @author guilh
 */
public class Pages {

    private static final HashMap<PageEnum, JFrame> pages = new HashMap<>();

    public static void setPage(PageEnum key, JFrame page) {
        pages.put(key, page);
    }

    public static void redirect(PageEnum key, JFrame currentPage) {
        getPage(key).setVisible(true);

        if (currentPage != null) {
            currentPage.dispose();
        }

    }

    public static void removePage(PageEnum key) {
        if (pages.containsKey(key)) {
            pages.remove(key);
        }
    }

    private static JFrame getPage(PageEnum key) {
        return pages.get(key);
    }
}
