package com.example.bespring2.repository;

import com.example.bespring2.model.Watch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface IWatchRepository extends JpaRepository<Watch, Long> {

//    @Query(value = "select * from watch", nativeQuery = true)
//    List<Watch> getListWatch(@Param("nameWatch") String nameWatch);
//


    @Query(value = "select * from watch", nativeQuery = true)
    List<Watch> getListWatch();


    @Query(value = "select * from watch where id=:idInput", nativeQuery = true)
    Watch getWatch(@Param("idInput") Long idInput);
}
