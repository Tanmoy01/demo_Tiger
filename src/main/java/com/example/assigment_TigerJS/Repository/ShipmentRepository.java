package com.example.assigment_TigerJS.Repository;
import com.example.assigment_TigerJS.Model.Shipment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipmentRepository extends CrudRepository<Shipment, Long> {
}

