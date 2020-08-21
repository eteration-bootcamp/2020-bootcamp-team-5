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
@Constraint(validatedBy = PasswordValidator.class)
public @interface Password {
    String message() default "Password not strong enough. <br/> At least one digit [0-9] <br/> At least one lowercase character [a-z] <br/> At least one uppercase character [A-Z] " +
            "<br/> At least one special character [*.!@#$%^&(){}[]:;<>,.?/~_+-=|\\] <br/> At least 8 characters in length, but no more than 32.";
    Class<?> [] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
