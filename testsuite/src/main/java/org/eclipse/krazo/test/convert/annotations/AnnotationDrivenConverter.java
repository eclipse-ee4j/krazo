package org.eclipse.krazo.test.convert.annotations;

import org.eclipse.krazo.binding.convert.ConverterResult;
import org.eclipse.krazo.binding.convert.MvcConverter;

import javax.annotation.Priority;
import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.Locale;
import java.util.stream.Stream;

@Priority(5)
public class AnnotationDrivenConverter implements MvcConverter<Double> {

    @Override
    public boolean supports(final Class<Double> rawType, final Annotation[] annotations) {
        return Stream.of(annotations).anyMatch(annotation -> annotation.annotationType().equals(AnswerToAll.class));
    }

    @Override
    public ConverterResult<Double> convert(final String value, final Class<Double> rawType, final Annotation[] annotations, final Locale locale) {
        return ConverterResult.success(getTheAnswer(annotations));
    }

    private static double getTheAnswer(final Annotation[] annotations) {
        return Arrays.stream(annotations).filter(annotation -> annotation.annotationType().equals(AnswerToAll.class))
            .findFirst().map(annotation -> ((AnswerToAll) annotation).theAnwser())
            .orElseThrow(() -> new IllegalArgumentException("You don't know the answer!"));
    }
}
