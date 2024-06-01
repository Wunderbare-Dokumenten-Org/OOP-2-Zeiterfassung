package org.iu.oop2ze.ui.cli.abstracts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation, welche ein Feld, per DI Initialisiert
 *
 * @author Julius Beier
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Lazy
@Autowired
public @interface LazyInject {
}
