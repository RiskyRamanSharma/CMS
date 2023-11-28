package com.contact.managment.system.CMS.Service;

import com.contact.managment.system.CMS.Domain.ContactEntity;
import com.contact.managment.system.CMS.Dto.ContactDto;
import com.contact.managment.system.CMS.Repository.ContactRepo;
import com.contact.managment.system.CMS.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService{


    @Autowired
    private ContactRepo contactRepo;





    public ContactEntity dtotoentity(ContactDto contactDto){
        ContactEntity contactEntity=new ContactEntity();
        contactEntity.setId(contactDto.getId());
        contactEntity.setEmail(contactDto.getEmail());
        contactEntity.setFirstName(contactDto.getFirstName());
        contactEntity.setLastName(contactDto.getLastName());
        contactEntity.setPhone((contactDto.getPhone()));
        return  contactEntity;

    }

    public ContactDto entitytodto(ContactEntity contactEntity){
        ContactDto contactDto=new ContactDto();
        contactDto.setId(contactEntity.getId());
        contactDto.setEmail(contactEntity.getEmail());
        contactDto.setFirstName(contactEntity.getFirstName());
        contactDto.setLastName(contactEntity.getLastName());
        contactDto.setPhone(contactEntity.getPhone());
        return contactDto;
    }

    @Override
    public ContactDto AddContact(ContactDto contactDto) {
        ContactEntity contactEntity=this.dtotoentity(contactDto);
        ContactEntity saveuser=this.contactRepo.save(contactEntity);
        return this.entitytodto(saveuser);
    }

    @Override
    public ContactDto UpdateContact(ContactDto contactDto, Long id) {
        ContactEntity contactEntity = contactRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Contact is not available for ID"));
        contactEntity.setFirstName(contactDto.getFirstName());
        contactEntity.setEmail(contactDto.getEmail());
        contactEntity.setLastName(contactDto.getLastName());
        contactEntity.setPhone(contactDto.getPhone());
        ContactEntity updatecontact=this.contactRepo.save(contactEntity);
        ContactDto contactDto1=this.entitytodto(updatecontact);

        return contactDto1;
    }

    @Override
    public ContactDto getContactById(Long id) {
        ContactEntity contact = contactRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("user is not available for ID"));

        return this.entitytodto(contact);
    }

    @Override
    public List<ContactDto> getContactlist() {
        List<ContactEntity> contactEntities=this.contactRepo.findAll();
        List<ContactDto> contactDtos= contactEntities.stream().map(user -> this.entitytodto(user)).collect(Collectors.toList());
        return contactDtos;
    }

    @Override
    public void DeleteContact(Long id) {
        ContactEntity contactEntity = contactRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("user is not available for ID"));
        this.contactRepo.delete(contactEntity);

    }
}
