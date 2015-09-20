package apollo.datastore.utils;

import java.io.Serializable;

public class CookieVariableBean implements Serializable {

    private CookieVariable variable;
    private String value;

    public CookieVariableBean() { }

    public String getName() {
        return variable.getName();
    }

    public void setName(String name) {
        variable = CookieVariable.valueOf(name);
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
