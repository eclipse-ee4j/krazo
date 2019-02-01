package org.eclipse.krazo.test.forms;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("resources")
public class MyApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        final Set<Class<?>> set = new HashSet<>();
        set.add(FormsController.class);
        return set;
    }
}
