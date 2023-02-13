package com.excercise.customerservice.service.impl;

import com.excercise.customerservice.constant.CommonConstant;
import com.excercise.customerservice.exception.CommonBusinessException;
import com.excercise.customerservice.model.orm.Customer;
import com.excercise.customerservice.model.update.CustomerUpdateModel;
import com.excercise.customerservice.producer.MessageProducer;
import com.excercise.customerservice.repository.CustomerRepository;
import com.excercise.customerservice.service.CustomerService;
import com.excercise.customerservice.utils.PasswordUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    MessageProducer messagePr;

    @Override
    public void save(CustomerUpdateModel model) {
        this.validation(model);
        Customer customer = new Customer();
        customer.setUsername(model.getUserName());
        customer.setPassword(PasswordUtils.encryptPassword(model.getPassword()));
        customer.setPhoneNumber(model.getPhoneNumber());
        Customer savedCustomer = customerRepository.save(customer);
        messagePr.sendMessage(savedCustomer, "customer");
    }

    @Override
    public String login(String userName, String password) {
        String result = CommonConstant.WRONG_PASSWORD_OR_USERNAME;
        Optional<Customer> customer = customerRepository.findByUsernameOrPhoneNumber(userName, userName);
        if (customer.isPresent()) {
            boolean equalsPass = PasswordUtils.decryptPassword(password, customer.get().getPassword());
            if (equalsPass) {
                result = CommonConstant.LOGIN_SUCCESS;
            }
        }
        return result;
    }

    private void validation(CustomerUpdateModel model) {
        if (StringUtils.isEmpty(model.getUserName())) {
            throw new CommonBusinessException("Username can not be emptied");
        }
        if (StringUtils.isEmpty(model.getPassword())) {
            throw new CommonBusinessException("Password can not be emptied");
        }
        if (StringUtils.isEmpty(model.getPhoneNumber()) || !model.getPhoneNumber().startsWith("0")) {
            throw new CommonBusinessException("Invalid phone number");
        }
        Optional<Customer> customer = customerRepository.findByUsername(model.getUserName());
        if (customer.isPresent()) {
            throw new CommonBusinessException("Username is already existed");
        }
        Optional<Customer> customerPhone = customerRepository.findByPhoneNumber(model.getPhoneNumber());
        if (customerPhone.isPresent()) {
            throw new CommonBusinessException("Phone Number is already existed");
        }

    }

}
