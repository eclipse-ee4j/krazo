package org.eclipse.krazo.test.redirectboundaryonroot;

import jakarta.mvc.RedirectScoped;
import java.io.Serializable;
import java.util.Objects;

@RedirectScoped
public class RedirectBean implements Serializable {

    private static final long serialVersionUID = -1;

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RedirectBean that = (RedirectBean) o;
        return Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message);
    }

    @Override
    public String toString() {
        return "RedirectBean{" +
            "message='" + message + '\'' +
            '}';
    }
}
