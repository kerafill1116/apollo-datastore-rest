package org.surfnet.oaaas.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.ConstraintValidatorContext;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import org.surfnet.oaaas.model.validation.AbstractEntityValid;

/**
 * Abstract class that serves as root for Model object (e.g. that are stored in
 * the repository)
 *
 */
@XmlRootElement
@Entity
@AbstractEntityValid
public abstract class AbstractEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @JsonProperty
    private Long id;

    @Column
    private Date creationDate;

    @Column
    private Date modificationDate;

    @Override
    public int hashCode() {
        return (id == null) ? super.hashCode() : id.hashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || !getClass().equals(other.getClass()) || !(other instanceof AbstractEntity)) {
            return false;
        }
        AbstractEntity entity = (AbstractEntity) other;
        if (id == null && entity.id == null) {
            return super.equals(entity);
        }
        if ((id != null && entity.id == null) || (id == null && entity.id != null)) {
            return false;
        }
        return id.equals(entity.id);
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     *          the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return new ReflectionToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).toString();
    }

    /**
     * Template method that validates the state of an {@link AbstractEntity}. Can
     * be used prior to saving/ updating the {@link AbstractEntity}
     *
     * @param context the ConstraintValidatorContext
     */
    public boolean validate(ConstraintValidatorContext context) {
        return true;
    }

    /**
     * Convenience method for adding a ConstraintViolation to the given context.
     * @param context the ConstraintValidatorContext
     * @param message the message to attach to the violation
     */
    protected void violation(ConstraintValidatorContext context, String message) {
        context
                .buildConstraintViolationWithTemplate(message)
                .addConstraintViolation()
                .disableDefaultConstraintViolation();
    }

    @PrePersist
    @PreUpdate
    public void updateTimeStamps() {
        modificationDate = new Date();
        if (creationDate == null) {
            creationDate = new Date();
        }
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public Date getModificationDate() {
        return modificationDate;
    }
}
