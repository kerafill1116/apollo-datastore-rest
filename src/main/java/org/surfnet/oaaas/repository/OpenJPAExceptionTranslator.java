package org.surfnet.oaaas.repository;

import javax.persistence.EntityExistsException;
import javax.persistence.PersistenceException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OpenJPAExceptionTranslator implements ExceptionTranslator {

    private static final Logger LOG = LoggerFactory.getLogger(OpenJPAExceptionTranslator.class);

    @Override
    public Exception translate(Throwable e) {
        if (e.getCause() != null && isRelevantCause(e.getCause())) {
            return translate(e.getCause());
        }
        Class<? extends Throwable> c = e.getClass();
        if (c.equals(EntityExistsException.class)) {
            return new javax.persistence.EntityExistsException(e.getMessage(), e);
        } else if (c.equals(javax.validation.ConstraintViolationException.class)) {
            return (Exception) e;
        }
        LOG.info("Cannot translate '{}' to specific subtype, will return generic PersistenceException", e.getClass().getName());
        return new PersistenceException(e);
    }

    /**
     * OpenJPA starts with an irrelevant ReportingSQLException....
     */
    private boolean isRelevantCause(Throwable cause) {
        return ! false; //(cause instanceof ReportingSQLException);
    }
}
