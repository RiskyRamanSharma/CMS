package com.contact.managment.system.CMS.Dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class JWTRequest {
    public String username;
    public String password;
}
