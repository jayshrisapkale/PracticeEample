package com.contact.contact.controller;

import com.contact.contact.entity.Contact;
import com.contact.contact.entity.Person;
import com.contact.contact.entity.TransactionRequest;
import com.contact.contact.entity.User;
import com.contact.contact.repository.ContactRepository;
import com.contact.contact.service.ContactService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.CompletableFuture;

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
    @GetMapping("/getById/{Id}")
    public Contact getContact(@PathVariable("Id") Integer id) throws InterruptedException {
        Thread.sleep(4000);
        return contactService.getContact(id);
    }
    @GetMapping("/getAll")
    public List<Contact> getAllContact(){
        return contactService.getAllContact();
    }

   // @HystrixCommand(fallbackMethod = "callStudentServiceAndGetData_Fallback",commandKey="hello",groupKey="hello")
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
//public String callStudentServiceAndGetData_Fallback() {
//    return "contact failed";
//}
    @GetMapping("/getuc/{id}")
    public Person getucon(@PathVariable Integer  id){
        StopWatch st = new StopWatch();
        st.start();
        Person tr = new Person();
        CompletableFuture.allOf(
                CompletableFuture.supplyAsync(()-> restTemplate.exchange("http://localhost:9077/user/getById/" +id, HttpMethod.GET,null,String.class)).thenAccept(x-> tr.setUser(x.getBody())),
                CompletableFuture.supplyAsync(()-> restTemplate.exchange("http://localhost:9078/contact/getById/" +id, HttpMethod.GET,null,String.class)).thenAccept(x-> tr.setContact(x.getBody()))).join();

//      tr.setUser(s.getBody());
//      tr.setContact(sr.getBody());

st.stop();
        System.out.println("  " +st.getTotalTimeMillis());
return tr;
    }
}

//    @GetMapping("/getuc/{id}")
//    public Person getucon(@PathVariable Integer  id){
//        StopWatch st = new StopWatch();
//        st.start();
//        ResponseEntity<String> s = restTemplate.exchange("http://localhost:9077/user/getById/" +id, HttpMethod.GET,null,String.class);
//        ResponseEntity<String> sr = restTemplate.exchange("http://localhost:9078/contact/getById/" +id, HttpMethod.GET,null,String.class);
//        Person tr = new Person();
//      tr.setUser(s.getBody());
//      tr.setContact(sr.getBody());
//        st.stop();
//        System.out.println("  " +st.getTotalTimeMillis());
//        return tr;
//    }
//}
