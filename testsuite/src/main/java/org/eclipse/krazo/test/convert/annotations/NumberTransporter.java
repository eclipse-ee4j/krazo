package org.eclipse.krazo.test.convert.annotations;

import javax.mvc.RedirectScoped;
import java.io.Serializable;

@RedirectScoped
public class NumberTransporter implements Serializable {
    private static final long serialVersionUID = -2849277180682084268L;

    private double number;

    public void setNumber(double number) {
        this.number = number;
    }

    public double getNumber() {
        return number;
    }
}
