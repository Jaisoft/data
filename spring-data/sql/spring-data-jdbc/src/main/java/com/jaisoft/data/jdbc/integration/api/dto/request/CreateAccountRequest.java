package com.jaisoft.data.jdbc.integration.api.dto.request;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
public class CreateAccountRequest {
    private UserRequest userRequest;
    private ProfileRequest profileRequest;

}
