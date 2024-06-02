package org.iu.oop2ze.core.database.models.abstracts.enums;

import java.io.Serializable;

/**
 * Beschreibt den Status eines Antrages
 *
 * @author Julius Beier
 */
public enum StatusType implements Serializable {
    AUSSTEHEND,
    IN_BEARBEITUNG,
    BEARBEITET,
}
