package apollo.datastore.utils;

import java.io.Serializable;

public class FormVariableBean implements Serializable {

    private FormVariable variable;
    private String value;

    public FormVariableBean() { }

    public String getName() {
        return variable.getName();
    }

    public void setName(String name) {
        variable = FormVariable.valueOf(name);
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
