package com.softtech.softtech3rdassignment.app.entity;

import com.softtech.softtech3rdassignment.app.enums.AccountTypes;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "ACCOUNT")
@Getter
@Setter
public class Account {

    @Id
    @SequenceGenerator(name = "Account", sequenceName = "ACCOUNT_ID_SEQ")
    @GeneratedValue(generator = "Account")
    private Long id;

    @Column(name = "USER_NAME", nullable = false, length = 25, unique = true)
    private String userName;

    @Column(name = "USER_MAIL", nullable = false, length = 50, unique = true)
    private String userMail;

    @Column(name = "USER_PHONE", nullable = false, length = 11, unique = true)
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "ACCOUNT_TYPE", nullable = false)
    private AccountTypes accountTypes;

}
