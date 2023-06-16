package com.example.assigment_TigerJS.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "shipments")
public class Shipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "customer_name")
    private String customerName;

    @NotBlank
    @Column(name = "customer_address")
    private String customerAddress;

    @NotNull
    @Column(name = "consignment_weight")
    private double consignmentWeight;

    @NotBlank
    @Column(name = "consignment_dimensions")
    private String consignmentDimensions;

    @NotBlank
    @Column(name = "delivery_address")
    private String deliveryAddress;

}
