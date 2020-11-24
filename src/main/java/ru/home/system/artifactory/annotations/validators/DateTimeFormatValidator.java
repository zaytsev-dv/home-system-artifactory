package ru.home.system.artifactory.annotations.validators;

import lombok.extern.slf4j.Slf4j;
import ru.home.system.artifactory.annotations.DateTimeFormat;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import static ru.home.system.artifactory.service.util.DateTimeUtil.stringToDateTime;


@Slf4j
public class DateTimeFormatValidator implements ConstraintValidator<DateTimeFormat, Object>
{
	public DateTimeFormatValidator()
	{
	}

	private String formatFromAnnotation;

	@Override
	public void initialize(DateTimeFormat constraintAnnotation)
	{
		formatFromAnnotation = constraintAnnotation.format();
	}

	public boolean isValid(Object value, ConstraintValidatorContext context)
	{
		boolean result = false;
		try
		{
			stringToDateTime((String) value, formatFromAnnotation);
			result = true;
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
		}

		return result;
	}
}