package org.eclipse.krazo.ext.jinja2;

import com.hubspot.jinjava.Jinjava;

import org.eclipse.krazo.engine.ViewEngineConfig;

import jakarta.enterprise.inject.Produces;

/**
 * Producer for {@link com.hubspot.jinjava.Jinjava} used by {@link Jinja2ViewEngine}.
 * 
 * @author Jeremias Weber
 */
public class DefaultJinjavaProducer {
    
    @Produces
    @ViewEngineConfig
    public Jinjava getJinjava() {
        return new Jinjava();
    }

}
