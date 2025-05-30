package com.example.wmsproject.controller;

import com.example.wmsproject.service.Service;
import com.example.wmsproject.utils.observer.Observer;

public interface Controller extends Observer {
    void setService(Service service);
}

