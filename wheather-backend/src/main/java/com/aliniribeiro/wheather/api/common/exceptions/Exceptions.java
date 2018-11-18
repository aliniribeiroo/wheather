package com.aliniribeiro.wheather.api.common.exceptions;

import com.google.gson.Gson;
import org.hibernate.service.spi.ServiceException;

/**
 * Exceções que devem ser lançadas pela aplicação.
 */
public class Exceptions {

    public static ServiceException entityNotFound(String id) {
        Gson gson = new Gson();
        String message = new String(gson.toJson(new InternalExceptions(ExceptionType.ENTITY_NOT_FOUND)));
        throw new IllegalArgumentException(String.format(message, id));
    }
}
