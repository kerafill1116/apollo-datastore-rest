package org.surfnet.oaaas.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * POJO representing an error response used when dealing with resources.
 *
 */
@XmlRootElement
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ValidationErrorResponse {

    @JsonProperty
    private List<String> violations = new ArrayList<String>();

    public ValidationErrorResponse() {
    }

    public ValidationErrorResponse(Set<ConstraintViolation<?>> violations) {
        for (ConstraintViolation<?> v : violations) {
            this.violations.add(v.getMessage());
        }
    }

    public List<String> getViolations() {
        return violations;
    }
}
