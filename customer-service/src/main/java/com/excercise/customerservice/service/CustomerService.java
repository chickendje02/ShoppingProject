package com.excercise.customerservice.service;

import com.excercise.customerservice.model.update.CustomerUpdateModel;

public interface CustomerService {

    void save(CustomerUpdateModel model);

    String login(String userName, String password);
}
