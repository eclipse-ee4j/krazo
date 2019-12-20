package org.eclipse.krazo.core;

import java.lang.reflect.Method;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;

@Default
@ApplicationScoped
public class DefaultViewPathResolver implements ViewPathResolver {

    @Override
    public String pathFor(Method method) {
        return null;
    }

}
