package org.surfnet.oaaas.model.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.surfnet.oaaas.model.AbstractEntity;

/**
 * {@link ConstraintValidator} that validates {@link org.surfnet.oaaas.model.AbstractEntity} by calling
 * the {@link org.surfnet.oaaas.model.AbstractEntity#validate(javax.validation.ConstraintValidatorContext)}
 *
 */
public class AbstractEntityValidator implements ConstraintValidator<AbstractEntityValid, AbstractEntity> {

    @Override
    public void initialize(AbstractEntityValid constraintAnnotation) {
    }

    @Override
    public boolean isValid(AbstractEntity entity, ConstraintValidatorContext context) {
        return entity.validate(context);
    }
}
