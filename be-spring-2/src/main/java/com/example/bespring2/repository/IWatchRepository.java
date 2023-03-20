package com.example.bespring2.repository;

import com.example.bespring2.model.Watch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IWatchRepository extends JpaRepository<Watch,Integer> {
}
