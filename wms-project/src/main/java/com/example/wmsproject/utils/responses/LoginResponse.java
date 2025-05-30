package com.example.wmsproject.utils.responses;

import com.example.wmsproject.utils.enums.LoginResponseType;
import com.example.wmsproject.model.Employee;

public class LoginResponse {
    private LoginResponseType type;
    private Employee body;

    public LoginResponse(LoginResponseType type, Employee body) {
        this.type = type;
        this.body = body;
    }

    public LoginResponseType getType() {
        return type;
    }

    public void setType(LoginResponseType type) {
        this.type = type;
    }

    public Employee getBody() {
        return body;
    }

    public void setBody(Employee body) {
        this.body = body;
    }
}
