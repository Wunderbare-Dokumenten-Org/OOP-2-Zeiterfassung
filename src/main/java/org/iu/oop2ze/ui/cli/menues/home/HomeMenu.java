package org.iu.oop2ze.ui.cli.menues.home;

import java.util.Arrays;
import java.util.List;
import org.iu.oop2ze.ui.cli.views.AbteilungenAnzeigen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Scanner;
public class HomeMenu {
    public static final List<HomeMenuOptions> ADMIN = Arrays.asList(
            HomeMenuOptions.ABTEILUNGEN,
            HomeMenuOptions.MITARBEITER,
            HomeMenuOptions.LOGOUT,
            HomeMenuOptions.BEENDEN
    );
    public static final List<HomeMenuOptions> HR = Arrays.asList(
            HomeMenuOptions.ARBEITSZEITEN,
            HomeMenuOptions.ANTRAEGE,
            HomeMenuOptions.MITARBEITER,
            HomeMenuOptions.LOGOUT,
            HomeMenuOptions.BEENDEN
    );
    public static final List<HomeMenuOptions> MITARBEITER = Arrays.asList(
            HomeMenuOptions.ARBEITSZEITEN,
            HomeMenuOptions.ANTRAEGE,
            HomeMenuOptions.LOGOUT,
            HomeMenuOptions.BEENDEN
    );
}
