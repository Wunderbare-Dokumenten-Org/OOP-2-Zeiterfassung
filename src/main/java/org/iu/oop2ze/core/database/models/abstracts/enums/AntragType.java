package org.iu.oop2ze.core.database.models.abstracts.enums;

import java.io.Serializable;

/**
 * Beschreibt die Art eines Antrages
 *
 * @author Julius Beier
 */
public enum AntragType implements Serializable {
    ARBEIT_BEGIN,
    ARBEIT_ENDE,
    ARBEIT_ERLAUBNIS,
    URLAUB_BEGIN,
    URLAUB_ENDE,
}
