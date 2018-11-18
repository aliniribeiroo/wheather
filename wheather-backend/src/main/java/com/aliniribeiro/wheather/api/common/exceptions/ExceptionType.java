package com.aliniribeiro.wheather.api.common.exceptions;

public enum ExceptionType {

    /***/
    ENTITY_NOT_FOUND(0, "%s not found with id %s .");

    private int cod;
    private String description;

    private ExceptionType(int cod, String description) {
        this.cod = cod;
        this.description = description;
    }

    public int getCod() {
        return cod;
    }

    public String getDescription() {
        return description;
    }

    public static ExceptionType toEnum(Integer cod) {

        if (cod == null) {
            return null;
        }

        for (ExceptionType x : ExceptionType.values()) {
            if (cod.equals(x.getCod())) {
                return x;
            }
        }
        throw new IllegalArgumentException("Invalid ID" + cod);

    }

}
