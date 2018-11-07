package org.tw.demo.user.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tw.demo.user.domains.User;


@Repository
public interface UserRepository extends JpaRepository<User,String> {

    User findByUserID(String Id);
}
