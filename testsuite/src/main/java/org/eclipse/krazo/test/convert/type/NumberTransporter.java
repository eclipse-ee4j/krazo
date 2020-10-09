package org.eclipse.krazo.test.convert.type;

import jakarta.mvc.RedirectScoped;
import java.io.Serializable;

@RedirectScoped
public class NumberTransporter implements Serializable {

    private static final long serialVersionUID = -1466071117599036181L;

    private double number;

    public void setNumber(double number) {
        this.number = number;
    }

    public double getNumber() {
        return number;
    }
}
