package com.contact.managment.system.CMS.Dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class JWTResponse
{

    public String JwtToken;
    public String username;
}
