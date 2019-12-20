package org.eclipse.krazo.core;

import java.lang.reflect.Method;

public interface ViewPathResolver {
    public String pathFor(Method method);
}
