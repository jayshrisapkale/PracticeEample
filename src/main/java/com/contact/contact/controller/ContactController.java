package com.contact.contact.controller;

import com.contact.contact.entity.Contact;
import com.contact.contact.entity.TransactionRequest;
import com.contact.contact.entity.User;
import com.contact.contact.repository.ContactRepository;
import com.contact.contact.service.ContactService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/contact")
public class ContactController {
    @Autowired
    ContactService contactService;
@Autowired
    ContactRepository contactRepository;
    @Autowired
    RestTemplate restTemplate;

    @PostMapping("/save")
    public Contact inserContact(@RequestBody Contact contact){
        return contactService.insertContact(contact);
    }
    @GetMapping("/getById/{cId}")
    public Contact getContact(@PathVariable("id") int id){
        return contactService.getContact(id);
    }
    @GetMapping("/getAll")
    public List<Contact> getAllContact(){
        return contactService.getAllContact();
    }

    @HystrixCommand(fallbackMethod = "callStudentServiceAndGetData_Fallback",commandKey="hello",groupKey="hello")
    @PostMapping("/contactsaveuser")
    public TransactionRequest insertContactUser(@RequestBody TransactionRequest request){
        Contact contact = request.getContact();
        restTemplate.postForObject("http://localhost:9078/contact/save",contact ,Contact.class);
        User user = new User();
        user.setName(contact.getContactName());
        user.setPhone(request.getPhone());
        user.setAddress(request.getAddress());
        user.setId(contact.getId());
        restTemplate.postForObject("http://localhost:9077/user/save",user ,User.class);
        return request;
    }
@GetMapping("getusercontact/{id}")
    public TransactionRequest getUserContact(@PathVariable Integer id){
    TransactionRequest tr = new TransactionRequest();
    Contact contact = contactRepository.findById(id).get();
    tr.setContact(contact);
User user = restTemplate.getForObject("http://localhost:9077/user/getById/" +id, User.class);
tr.setPhone(user.getPhone());
tr.setAddress(user.getAddress());
tr.setId(user.getId());

return  tr;
}
public String callStudentServiceAndGetData_Fallback() {
    return "contact failed";
}
}
