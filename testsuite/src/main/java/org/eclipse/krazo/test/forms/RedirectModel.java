package org.eclipse.krazo.test.forms;

import java.io.Serializable;
import javax.mvc.RedirectScoped;

@RedirectScoped
public class RedirectModel implements Serializable {

    private static final long serialVersionUID = 5319837332392907016L;

    private String invokedMethod;

    public RedirectModel() {
    }

    public String getInvokedMethod() {
        return invokedMethod;
    }

    public void setInvokedMethod(String invokedMethod) {
        this.invokedMethod = invokedMethod;
    }
}
