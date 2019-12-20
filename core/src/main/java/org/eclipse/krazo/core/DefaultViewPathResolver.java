package org.eclipse.krazo.core;

import static org.eclipse.krazo.util.AnnotationUtils.getAnnotation;

import java.lang.reflect.Method;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import javax.mvc.View;

@Default
@ApplicationScoped
public class DefaultViewPathResolver implements ViewPathResolver {

    @Override
    public String pathFor(Method method) {
	View an = getAnnotation(method, View.class);
        if (an == null) {
            an = getAnnotation(method.getDeclaringClass(), View.class);
        }
        return (an != null ? an.value() : null);
    }

}
