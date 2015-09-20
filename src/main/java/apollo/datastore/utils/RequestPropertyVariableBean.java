package apollo.datastore.utils;

import java.io.Serializable;

public class RequestPropertyVariableBean implements Serializable {

    private RequestPropertyVariable variable;
    private Object value;

    public RequestPropertyVariableBean() { }

    public String getName() {
        return variable.getName();
    }

    public void setName(String name) {
        variable = RequestPropertyVariable.valueOf(name);
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
