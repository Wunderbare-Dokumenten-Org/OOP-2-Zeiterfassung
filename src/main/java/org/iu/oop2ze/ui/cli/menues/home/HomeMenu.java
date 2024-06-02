package org.iu.oop2ze.ui.cli.menues.home;

import org.iu.oop2ze.ui.cli.menues.abstracts.BaseMenu;
import org.iu.oop2ze.ui.cli.menues.abstracts.HomeMenuOptions;

import java.util.Arrays;

/**
 * Klasse, welche die HomeView Menüs, der Nutzer beschreibt
 *
 * @author Julius Beier
 * @see org.iu.oop2ze.ui.cli.views.HomeView
 * @see HomeMenuOptions
 */
public class HomeMenu extends BaseMenu<HomeMenuOptions> {
    public HomeMenu() {
        this.admin = Arrays.asList(
                HomeMenuOptions.ABTEILUNGEN,
                HomeMenuOptions.MITARBEITER,
                HomeMenuOptions.LOGOUT,
                HomeMenuOptions.BEENDEN
        );

        this.hr = Arrays.asList(
                HomeMenuOptions.ZEITSTEMPELN,
                HomeMenuOptions.ANTRAEGE,
                HomeMenuOptions.ABTEILUNGEN,
                HomeMenuOptions.MITARBEITER,
                HomeMenuOptions.LOGOUT,
                HomeMenuOptions.BEENDEN
        );

        this.mitarbeiter = Arrays.asList(
                HomeMenuOptions.ZEITSTEMPELN,
                HomeMenuOptions.ANTRAEGE,
                HomeMenuOptions.LOGOUT,
                HomeMenuOptions.BEENDEN
        );
    }
}
