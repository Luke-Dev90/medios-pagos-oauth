package com.lchalela.app.ouath.models;

import lombok.Data;
import java.util.List;
import com.lchalela.app.ouath.dto.AccountDTO;

@Data
public class UserDTO {

    private Long id;
    private String email;
    private String password;
    private String name;
    private String lastName;
    private Boolean enabled;
    private List<AccountDTO> accountDTO;
    private List<Role> roles;
}
