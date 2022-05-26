package com.contact.contact.service;
import com.contact.contact.entity.Contact;
import com.contact.contact.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ContactServiceImpl implements ContactService{
    @Autowired
    ContactRepository contactRepository;
    @Override
    public Contact insertContact(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public Contact getContact(int id) {
        return contactRepository.findById(id).get();
    }

    @Override
    public List<Contact> getAllContact() {
        return contactRepository.findAll();
    }
}
