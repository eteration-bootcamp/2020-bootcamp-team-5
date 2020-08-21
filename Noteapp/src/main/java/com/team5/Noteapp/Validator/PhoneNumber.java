package com.team5.Noteapp.Validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@Constraint(validatedBy = PhoneNumberValidator.class)
public @interface PhoneNumber  {
	String message() default "Invalid phone number";
	Class<?> [] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
