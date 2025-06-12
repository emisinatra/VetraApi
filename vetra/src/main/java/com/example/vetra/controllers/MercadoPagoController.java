package com.example.vetra.controllers;

import com.example.vetra.entities.OrdenCompra;
import com.example.vetra.services.MercadoPagoService;
import com.example.vetra.services.OrdenCompraService;
import com.mercadopago.resources.preference.Preference;
import com.mercadopago.MercadoPagoConfig;
import com.mercadopago.exceptions.MPApiException;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/mercadopago")
@CrossOrigin(origins = "http://localhost:5173")
@RequiredArgsConstructor
public class MercadoPagoController {

    private final MercadoPagoService mercadoPagoService;
    private final OrdenCompraService ordenCompraService;

    @Value("${mercadopago.access_token}")
    private String mercadoPagoAccessToken;

    @PostMapping("/create-preference/{ordenId}")
    public ResponseEntity<String> createPreference(@PathVariable Long ordenId) {
        MercadoPagoConfig.setAccessToken(mercadoPagoAccessToken);
        try {
            OrdenCompra orden = ordenCompraService.findById(ordenId);
            Preference preference = mercadoPagoService.createPaymentPreference(orden);
            // Devolvemos el ID de la preferencia, que es lo que el frontend necesita
            return ResponseEntity.ok(preference.getId());
        }catch(MPApiException e){
            System.out.println("Status code: " + e.getStatusCode());
            System.out.println("Cause: " + e.getCause());
            System.out.println("Message: " + e.getMessage());
            System.out.println("Response body: " + e.getApiResponse().getContent());
            return ResponseEntity.status(500).body("Error al crear la preferencia de pago: " + e.getMessage());
        } 
        catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error al crear la preferencia de pago: " + e.getMessage());
        }
    }
} 