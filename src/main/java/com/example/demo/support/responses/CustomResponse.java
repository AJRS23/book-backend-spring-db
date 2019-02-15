package com.example.demo.support.responses;

public class CustomResponse  {
    Object value;

    public CustomResponse(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
