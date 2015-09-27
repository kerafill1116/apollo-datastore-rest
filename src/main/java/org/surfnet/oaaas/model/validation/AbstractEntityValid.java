package org.surfnet.oaaas.model.validation;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * Ensures the {@link org.surfnet.oaaas.model.AbstractEntity} is validated.
 *
 */
@Target({TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = AbstractEntityValidator.class)
@Documented
public @interface AbstractEntityValid {

    String message() default "";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
