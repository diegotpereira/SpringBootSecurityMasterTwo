package br.com.java.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.com.java.model.User;
import br.com.java.service.UserService;

@Component
public class UserValidator implements Validator {
	
	@Autowired
	private UserService userService;

	@Override
	public boolean supports(Class<?> aClass) {
		// TODO Auto-generated method stub
		return User.class.equals(aClass);
	}

	@Override
	public void validate(Object o, Errors errors) {
		// TODO Auto-generated method stub
		User user = (User) o;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
		
		if (user.getUsername().length() < 6 || user.getUsername().length() > 32) {
			errors.rejectValue("username", "size.userForm.username");
		}
		if (userService.findByUsername(user.getUsername()) != null) {
			errors.rejectValue("username", "Duplicate.userForm.username");
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "Notmpty");
		if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
			errors.rejectValue("password", "Size.userForm.password");
		}
		if (!user.getPassword().equals(user.getPassword())) {
			errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
		}
	}

}
