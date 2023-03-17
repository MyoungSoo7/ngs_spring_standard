package com.fastcampus.ch2;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class GlobalValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        System.out.println("GlobalValidator.validate() called");
        User user = (User) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pwd", "required");

        if(user.getId() == null || user.getId().trim().isEmpty() || user.getId().length() < 4 || user.getId().length() > 10 ) {
            errors.rejectValue("id", "invalidLength", new String[]{"","4","12"}, null );
        }
    }
}
