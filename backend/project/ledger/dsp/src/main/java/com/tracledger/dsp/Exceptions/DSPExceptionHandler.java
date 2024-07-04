package com.tracledger.dsp.Exceptions;

import org.hibernate.exception.ConstraintViolationException;
import org.postgresql.util.PSQLException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class DSPExceptionHandler extends Throwable{

    public DSPExceptionHandler(Throwable e) throws Throwable {

        if( e instanceof DataIntegrityViolationException || e instanceof ConstraintViolationException){
            handleDataIntegrityViolationException((DataIntegrityViolationException)e);
        }
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    private Throwable handleDataIntegrityViolationException(DataIntegrityViolationException e) throws Throwable {
        Throwable rootCause = getRootCause(e);
        if (rootCause instanceof PSQLException)
            return rootCause;
        else
            return e;
    }

    private Throwable getRootCause(Throwable throwable) {
        Throwable rootCause = throwable;
        while (rootCause.getCause() != null) {
            rootCause = rootCause.getCause();
        }
        return rootCause;
    }
}
