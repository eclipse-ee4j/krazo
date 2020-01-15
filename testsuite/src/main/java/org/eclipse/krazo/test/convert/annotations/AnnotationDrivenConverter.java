package org.eclipse.krazo.test.convert.annotations;

import org.eclipse.krazo.binding.convert.ConverterResult;
import org.eclipse.krazo.binding.convert.MvcConverter;

import javax.annotation.Priority;
import java.lang.annotation.Annotation;
import java.util.Locale;
import java.util.stream.Stream;

@Priority(5)
public class AnnotationDrivenConverter implements MvcConverter<Double> {

    @Override
    public boolean supports(final Class<Double> rawType, final Annotation[] annotations) {
        final boolean annotationFound = Stream.of(annotations).anyMatch(annotation -> annotation.annotationType().equals(AnswerToAll.class));
        return annotationFound;
    }

    @Override
    public ConverterResult<Double> convert(final String value, final Class<Double> rawType, final Locale locale) {
        return ConverterResult.success(42.0D);
    }
}
