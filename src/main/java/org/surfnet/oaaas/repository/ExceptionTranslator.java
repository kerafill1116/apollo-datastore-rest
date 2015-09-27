package org.surfnet.oaaas.repository;

public interface ExceptionTranslator {

    Exception translate(Throwable e);
}
