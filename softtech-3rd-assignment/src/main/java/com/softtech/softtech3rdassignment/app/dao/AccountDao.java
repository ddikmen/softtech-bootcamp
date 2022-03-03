package com.softtech.softtech3rdassignment.app.dao;

import com.softtech.softtech3rdassignment.app.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountDao extends JpaRepository<Account, Long> {

    Account findByUserName(String userName);

}
