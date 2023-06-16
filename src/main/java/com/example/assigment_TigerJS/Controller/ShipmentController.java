package com.example.assigment_TigerJS.Controller;

import com.example.assigment_TigerJS.Repository.ShipmentRepository;
import jakarta.validation.Valid;
import org.springframework.ui.Model;
import com.example.assigment_TigerJS.Model.Shipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ShipmentController {
    @Autowired
    private ShipmentRepository shipmentRepository;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/shipment-booking")
    public String shipmentBooking(Model model) {
        model.addAttribute("shipment", new Shipment());
        model.addAttribute("shipments", shipmentRepository.findAll());
        return "shipment-booking";
    }

    @PostMapping("/shipment-booking")
    public String createShipment(@ModelAttribute("shipment") @Valid Shipment shipment, BindingResult result) {
        if (result.hasErrors()) {
            return "shipment-booking";
        }

        shipmentRepository.save(shipment);
        return "redirect:/shipment-booking";
    }

    @GetMapping("/shipment/delete/{id}")
    public String deleteShipment(@PathVariable("id") Long id) {
        shipmentRepository.deleteById(id);
        return "redirect:/shipment-booking";
    }
}
