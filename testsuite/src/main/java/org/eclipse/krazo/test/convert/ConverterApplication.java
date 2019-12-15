package org.eclipse.krazo.test.convert;

import org.eclipse.krazo.binding.convert.ConverterRegistry;
import org.eclipse.krazo.binding.convert.ConverterResult;
import org.eclipse.krazo.binding.convert.MvcConverter;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Locale;

@ApplicationPath("resources")
public class ConverterApplication extends Application {

    @Inject
    private ConverterRegistry converterRegistry;

    @PostConstruct
    public void init() {
        converterRegistry.register(new AnswerToAllDoubleConverter());
    }

    /**
     * Some really senseless converter to test the converter priority. It returns 42 on any run ;)
     */
    private static class AnswerToAllDoubleConverter implements MvcConverter<Double> {

        @Override
        public boolean supports(Class<Double> rawType) {
            return Double.class.equals(rawType) || Double.TYPE.equals(rawType);
        }

        @Override
        public ConverterResult<Double> convert(String value, Class<Double> rawType, Locale locale) {
            return ConverterResult.success(42.0D);
        }

        @Override
        public int getPriority() {
            return 5;
        }
    }
}
