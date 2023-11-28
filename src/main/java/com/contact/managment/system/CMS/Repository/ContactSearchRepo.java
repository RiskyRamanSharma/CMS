package com.contact.managment.system.CMS.Repository;

import com.contact.managment.system.CMS.Domain.ContactEntity;
//import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;
@Repository
public interface ContactSearchRepo extends JpaRepository<ContactEntity,String > {

    @Transactional
    @Query("SELECT \n" +
            "  nr.phone  \n" +
            "FROM ContactEntity nr\n" +
            "WHERE nr.firstName = :firstName\n")
    List<?> findContactByName
            (@Param("firstName") String firstName);

}
