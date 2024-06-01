package org.iu.oop2ze.ui.cli.abstracts;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * Annotation, welche alle Kind klassen, einer Basis Klasse, als @Component markiert
 *
 * @author Julius Beier
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Component
@Inherited
public @interface InheritComponent {
}
