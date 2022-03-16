package com.wtc.induction.orderinfo.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.wtc.induction.orderinfo.model.OrderDetails;

@Repository
public interface OrderInfoRepo extends MongoRepository<OrderDetails, Integer>{

}
