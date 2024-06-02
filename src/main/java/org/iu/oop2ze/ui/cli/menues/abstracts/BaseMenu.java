package org.iu.oop2ze.ui.cli.menues.abstracts;

import lombok.Getter;
import org.iu.oop2ze.ui.cli.abstracts.InheritComponent;

import java.util.List;

/**
 * Klasse, welche die Struktur für erbende Menüs angibt
 *
 * @param <T> Die Menüoptionen
 * @author Julius Beier
 */
@Getter
@InheritComponent
public abstract class BaseMenu<T> {
    protected List<T> admin;
    protected List<T> hr;
    protected List<T> mitarbeiter;
}
