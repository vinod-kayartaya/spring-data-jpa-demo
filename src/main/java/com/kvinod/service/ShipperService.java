package com.kvinod.service;

import com.kvinod.dao.ShipperDao;
import com.kvinod.entity.Shipper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipperService {

    @Autowired
    ShipperDao dao;

    public List<Shipper> getAllShippers(){
        return dao.findAll();
    }
}
