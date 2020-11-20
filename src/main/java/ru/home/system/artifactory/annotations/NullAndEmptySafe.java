package ru.home.system.artifactory.annotations;


import ru.home.system.artifactory.annotations.validators.NullAndEmptySafeValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(
		validatedBy = {NullAndEmptySafeValidator.class}
)
public @interface NullAndEmptySafe {
	String message() default "field not be null or empty";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
