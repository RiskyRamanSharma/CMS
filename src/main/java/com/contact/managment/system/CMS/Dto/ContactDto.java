package com.contact.managment.system.CMS.Dto;

//import jakarta.persistence.Column;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor

@RequiredArgsConstructor
public class ContactDto
{

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String phone;
}
