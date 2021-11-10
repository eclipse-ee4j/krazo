package org.eclipse.krazo.test.convert.available;

import java.lang.annotation.Annotation;
import java.math.BigDecimal;
import java.math.BigInteger;

import org.eclipse.krazo.binding.convert.ConverterRegistry;

import jakarta.inject.Inject;
import jakarta.mvc.Controller;
import jakarta.mvc.Models;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Controller
@Path("available-converter")
public class AvailableConverterController{

    private static final Annotation[] EMPTY_ANNOTATIONS = new Annotation[]{};
    
    @Inject
    private ConverterRegistry converterRegistry;

    @Inject
    private Models models;

    @GET
    public String doGetIndex() {
        models.put("short", containsMvcConverterForType(Short.class));
        models.put("long", containsMvcConverterForType(Long.class));
        models.put("integer", containsMvcConverterForType(Integer.class));
        models.put("float", containsMvcConverterForType(Float.class));
        models.put("double", containsMvcConverterForType(Double.class));
        models.put("biginteger", containsMvcConverterForType(BigInteger.class));
        models.put("bigdecimal", containsMvcConverterForType(BigDecimal.class));

        return "index.jsp";
    }

    private boolean containsMvcConverterForType(Class<?> clazz) {
        return converterRegistry.lookup(clazz, EMPTY_ANNOTATIONS) != null;
    }
}
