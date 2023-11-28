package com.contact.managment.system.CMS.Service;

import com.contact.managment.system.CMS.Domain.ContactEntity;
import com.contact.managment.system.CMS.Dto.ContactDto;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ContactService {

    ContactDto AddContact(ContactDto contactDto);

   ContactDto UpdateContact(ContactDto contactDto, Long id);
   ContactDto getContactById(Long id);

   List<ContactDto>getContactlist();
    void DeleteContact(Long id);

}
