package org.eclipse.krazo.core;

import java.lang.reflect.Method;


/**
 * Interface thats provide way to resolve view names after try looking for @View
 *
 * @author Jonatan Lemes
 */
public interface ViewPathResolver {
    
    /**
     * Return a resolved view name based on method infos. If returns null throws Exception based on spec 
     *
     * @param {@link java.lang.reflect.Method} of controller thats is current executing.
     * @return resolved view name path.
     */
    public String pathFor(Method method);
}
