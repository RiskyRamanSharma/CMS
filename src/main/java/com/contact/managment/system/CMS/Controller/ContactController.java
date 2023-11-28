package com.contact.managment.system.CMS.Controller;

import com.contact.managment.system.CMS.Domain.ContactEntity;
import com.contact.managment.system.CMS.Dto.ContactDto;
import com.contact.managment.system.CMS.Repository.ContactRepo;
import com.contact.managment.system.CMS.Repository.ContactSearchRepo;
import com.contact.managment.system.CMS.Service.ContactService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/v1/contact")
@RequiredArgsConstructor
public class ContactController {
@Autowired
private ContactService contactService;



@Autowired
private ContactSearchRepo contactRepo;


    Logger logger = LoggerFactory.getLogger(ContactController.class);


    @PostMapping("/addcontact")
    public ResponseEntity<ContactDto> addContact(@RequestBody ContactDto contactDto){
        ContactDto CreateContactDto=this.contactService.AddContact(contactDto);
        return new ResponseEntity<>(CreateContactDto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public  ResponseEntity<ContactDto> updateContact(@RequestBody ContactDto contactDto,@PathVariable  Long id){
        ContactDto updatecontact=this.contactService.UpdateContact(contactDto,id);
        return  ResponseEntity.ok(updatecontact);


    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteContact(@PathVariable Long id){
        this.contactService.DeleteContact(id);
        return new ResponseEntity(Map.of("msg" , id),HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<ContactDto>>getContactList(){

        return ResponseEntity.ok(this.contactService.getContactlist());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ContactDto>getContactbyid(@PathVariable Long id){
        return ResponseEntity.ok(this.contactService.getContactById(id));
    }

    @GetMapping(value = "/searchname/{name}")
    public List<?>getContactbyName(@PathVariable String  name){
        List <?> list=contactRepo.findContactByName(name);
       return list;
    }
}
