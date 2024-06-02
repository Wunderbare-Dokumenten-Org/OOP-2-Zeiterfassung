package org.iu.oop2ze.core.database.models;

import jakarta.persistence.Embeddable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
//@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Zeitstempel {
    private Date startTime;
    private Date endTime;

    public Zeitstempel(Date startTime, Date endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
