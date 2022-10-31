package com.jaisoft.data.jdbc.integration.api.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateAccountResponse {
    private UserResponse userResponse;
    private ProfileResponse profileResponse;

}
