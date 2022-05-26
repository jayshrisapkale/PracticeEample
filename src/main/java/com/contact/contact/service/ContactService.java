package com.contact.contact.service;

import com.contact.contact.entity.Contact;

import java.util.List;

public interface ContactService {
    Contact insertContact(Contact contact);

    Contact getContact(int id);

    List<Contact> getAllContact();
}
