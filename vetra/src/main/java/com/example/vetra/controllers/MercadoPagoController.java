package com.example.vetra.controllers;

import com.example.vetra.entities.OrdenCompra;
import com.example.vetra.services.MercadoPagoService;
import com.example.vetra.services.OrdenCompraService;
import com.mercadopago.resources.preference.Preference;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/mercadopago")
@CrossOrigin(origins = "http://localhost:5173")
@RequiredArgsConstructor
public class MercadoPagoController {

    private final MercadoPagoService mercadoPagoService;
    private final OrdenCompraService ordenCompraService;

    @PostMapping("/create-preference/{ordenId}")
    public ResponseEntity<String> createPreference(@PathVariable Long ordenId) {
        try {
            OrdenCompra orden = ordenCompraService.findById(ordenId);
            Preference preference = mercadoPagoService.createPaymentPreference(orden);
            // Devolvemos el ID de la preferencia, que es lo que el frontend necesita
            return ResponseEntity.ok(preference.getId());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error al crear la preferencia de pago: " + e.getMessage());
        }
    }
} 