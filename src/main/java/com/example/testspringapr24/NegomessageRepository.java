package com.example.testspringapr24;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface NegomessageRepository extends JpaRepository<Negomessage, String> {


    @Transactional
    @Query(value = "select * from negomessages n where n.negorefid=?1 order by n.time",nativeQuery = true)
    List<Negomessage> findByNegorefid(String negorefid);


}