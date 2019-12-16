package org.eclipse.krazo.test.convert;

import org.eclipse.krazo.binding.convert.ConverterRegistry;
import org.eclipse.krazo.binding.convert.ConverterResult;
import org.eclipse.krazo.binding.convert.MvcConverter;

import javax.inject.Inject;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.Locale;

@WebListener
public class StartupListener implements ServletContextListener {

    @Inject
    private ConverterRegistry converterRegistry;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
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
