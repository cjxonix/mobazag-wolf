package startek.util.annotation;

import javax.validation.ConstraintValidatorContext;

import java.lang.reflect.Field;
import java.util.Date;

public class ValidatorUtil {

	public static void addValidationError(String field,
			ConstraintValidatorContext context) {
		context.buildConstraintViolationWithTemplate(
				context.getDefaultConstraintMessageTemplate()).addNode(field)
				.addConstraintViolation();
	}

	public static Object getFieldValue(Object object, String fieldName)
			throws NoSuchFieldException, IllegalAccessException {
		Field f = object.getClass().getDeclaredField(fieldName);
		f.setAccessible(true);
		return f.get(object);
	}
	
	public static Object getFieldValue(Object object, Date fieldName)
			throws NoSuchFieldException, IllegalAccessException {
		Field f = object.getClass().getDeclaredField(fieldName.toString());
		f.setAccessible(true);
		return f.get(object);
	}

	public static void addValidationError(Date field,
			ConstraintValidatorContext context) {
		context.buildConstraintViolationWithTemplate(
				context.getDefaultConstraintMessageTemplate()).addNode(field.toString())
				.addConstraintViolation();
	}
}