package com.shop.bookstore.core.utilities.exceptions.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = {UniqueUsernameValidatior.class})
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueUsername {
	String message() default "The entered Username exists";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
}
