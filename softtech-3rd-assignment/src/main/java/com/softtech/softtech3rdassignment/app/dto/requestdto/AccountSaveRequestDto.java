package com.softtech.softtech3rdassignment.app.dto.requestdto;

import com.softtech.softtech3rdassignment.app.enums.AccountTypes;
import lombok.Data;

@Data
public class AccountSaveRequestDto {

    private String userName;
    private String userMail;
    private String phoneNumber;
    private AccountTypes accountTypes;

}
