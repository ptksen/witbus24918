package com.witbus.demo.dao.repository;

import com.witbus.demo.dao.models.Bus_Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Bus_OwnerRepository extends JpaRepository<Bus_Owner, Long> {
}
