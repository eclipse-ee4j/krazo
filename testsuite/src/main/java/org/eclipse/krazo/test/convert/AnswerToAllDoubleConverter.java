package org.eclipse.krazo.test.convert;

import org.eclipse.krazo.binding.convert.ConverterResult;
import org.eclipse.krazo.binding.convert.MvcConverter;

import javax.annotation.Priority;
import java.util.Locale;

@Priority(5)
public class AnswerToAllDoubleConverter implements MvcConverter<Double> {

    @Override
    public boolean supports(Class<Double> rawType) {
        return Double.class.equals(rawType) || Double.TYPE.equals(rawType);
    }

    @Override
    public ConverterResult<Double> convert(String value, Class<Double> rawType, Locale locale) {
        return ConverterResult.success(42.0D);
    }
}
