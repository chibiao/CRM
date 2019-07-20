package com.tjetc.mapper;

import java.util.List;

import com.tjetc.pojo.CusContact;
import com.tjetc.pojo.Customer;

public interface CusContactMapper {
    void addContact(CusContact contact);
    void delContact(Integer conid);
    List<Customer> listContact(CusContact cusContact);
    CusContact getById(Integer conid);
    void update(CusContact contact);
}