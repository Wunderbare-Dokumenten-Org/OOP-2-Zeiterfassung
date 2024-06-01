package org.iu.oop2ze.ui.cli.abstracts;

/**
 * Interface, welches zur Formatierung, von Menüeinträgen genutzt wird
 *
 * @author Julius Beier
 */
public interface MenuComponent<T> {
    /**
     * Gibt ein formatierten String, des angegebenen Models zurück
     *
     * @param entryModel Das Model, welches zu einem String formatiert wird
     * @return Den formatierten Menüeintrag
     * @author Julius Beier
     */
    String getMenuEntry(T entryModel);
}
