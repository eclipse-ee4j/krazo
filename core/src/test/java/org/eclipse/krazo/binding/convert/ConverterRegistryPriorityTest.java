package org.eclipse.krazo.binding.convert;

import org.junit.Before;
import org.junit.Test;

import java.util.Locale;

import static org.junit.Assert.assertTrue;

public class ConverterRegistryPriorityTest {

    private ConverterRegistry registry;

    @Before
    public void setup() {
        registry = new ConverterRegistry();
        registry.init();
    }

    @Test
    public void testConverterWithHigherPriorityIsEvaluatedBeforeBuiltInOnes() {
        registry.register(new AnswerToAllDoubleConverter());

        final boolean correctConverter = registry.lookup(Double.TYPE) instanceof AnswerToAllDoubleConverter;

        assertTrue(correctConverter);
    }

    @Test
    public void testMultipleConverterWithHigherPriorityAreEvaluatedInCorrectOrder() {
        registry.register(new AnswerToAllDoubleConverter());
        registry.register(new SomeOtherDoubleConverter());

        final boolean correctConverter = registry.lookup(Double.TYPE) instanceof AnswerToAllDoubleConverter;

        assertTrue(correctConverter);
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

    /**
     * Some really senseless converter to test the converter priority. It returns 42 on any run ;)
     */
    private static class SomeOtherDoubleConverter implements MvcConverter<Double> {

        @Override
        public boolean supports(Class<Double> rawType) {
            return Double.class.equals(rawType) || Double.TYPE.equals(rawType);
        }

        @Override
        public ConverterResult<Double> convert(String value, Class<Double> rawType, Locale locale) {
            return ConverterResult.success(999999999.0D);
        }

        @Override
        public int getPriority() {
            return 4;
        }
    }
}
