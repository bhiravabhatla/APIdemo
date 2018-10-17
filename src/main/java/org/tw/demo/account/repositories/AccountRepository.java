package org.tw.demo.account.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tw.demo.account.domains.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account,String>{
    Account findByAccountId(String id);

}
