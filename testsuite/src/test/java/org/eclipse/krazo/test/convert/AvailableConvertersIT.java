package org.eclipse.krazo.test.convert;

import org.eclipse.krazo.binding.convert.ConverterRegistry;
import org.eclipse.krazo.binding.convert.MvcConverter;
import org.eclipse.krazo.test.util.WebArchiveBuilder;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import java.lang.annotation.Annotation;
import java.math.BigDecimal;
import java.math.BigInteger;

import static org.junit.Assert.assertNotNull;

@RunWith(Arquillian.class)
public class AvailableConvertersIT {

    private static final Annotation[] EMPTY_ANNOTATIONS = new Annotation[]{};

    @Deployment(name = "available-converters")
    public static WebArchive createDeployment() {
        return new WebArchiveBuilder()
            .addBeansXml()
            .build();
    }

    @Inject
    private ConverterRegistry converterRegistry;

    @Test
    public void shortConverterRegistered() {
        final MvcConverter<Short> converter = converterRegistry.lookup(Short.class, EMPTY_ANNOTATIONS);

        assertNotNull(formatErrorMessage(Short.class), converter);
    }

    @Test
    public void longConverterRegistered() {
        final MvcConverter<Long> converter = converterRegistry.lookup(Long.class, EMPTY_ANNOTATIONS);

        assertNotNull(formatErrorMessage(Long.class), converter);
    }

    @Test
    public void integerConverterRegistered() {
        final MvcConverter<Integer> converter = converterRegistry.lookup(Integer.class, EMPTY_ANNOTATIONS);

        assertNotNull(formatErrorMessage(Integer.class), converter);
    }

    @Test
    public void floatConverterRegistered() {
        final MvcConverter<Float> converter = converterRegistry.lookup(Float.class, EMPTY_ANNOTATIONS);

        assertNotNull(formatErrorMessage(Float.class), converter);
    }

    @Test
    public void doubleConverterRegistered() {
        final MvcConverter<Double> converter = converterRegistry.lookup(Double.class, EMPTY_ANNOTATIONS);

        assertNotNull(formatErrorMessage(Double.class), converter);
    }

    @Test
    public void bigIntegerConverterRegistered() {
        final MvcConverter<BigInteger> converter = converterRegistry.lookup(BigInteger.class, EMPTY_ANNOTATIONS);

        assertNotNull(formatErrorMessage(BigInteger.class), converter);
    }

    @Test
    public void bigDecimalConverterRegistered() {
        final MvcConverter<BigDecimal> converter = converterRegistry.lookup(BigDecimal.class, EMPTY_ANNOTATIONS);

        assertNotNull(formatErrorMessage(BigDecimal.class), converter);
    }

    private static String formatErrorMessage(final Class<?> clazz) {
        return String.format("Could not lookup default converter for %s", clazz.getName());
    }
}
