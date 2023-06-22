package com.kvinod.dao;

import com.kvinod.entity.Shipper;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipperDao extends JpaRepository<Shipper, Integer> {
}
