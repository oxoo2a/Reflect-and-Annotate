/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reflect.and.annotate;

import java.lang.annotation.*;

/**
 *
 * @author sturm
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Comment {
	String value() default "";
}
