package org.eclipse.krazo.core;

import java.lang.reflect.Method;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;


/**
 * Default view path resolver that keeps default compatibility
 *
 * @author Jonatan Lemes
 */
@Default
@ApplicationScoped
public class DefaultViewPathResolver implements ViewPathResolver {

    
    /**
     * Default implementation that keeps default compatibility
     * @param Controller method thats is current executing {@link java.lang.reflect.Method}.
     * @return resolved view name path.
     */
    @Override
    public String pathFor(Method method) {
        return null;
    }

}
