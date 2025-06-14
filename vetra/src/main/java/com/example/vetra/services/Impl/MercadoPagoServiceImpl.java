package com.example.vetra.services.Impl;

import com.example.vetra.entities.DetalleOrden;
import com.example.vetra.entities.OrdenCompra;
import com.example.vetra.services.MercadoPagoService;
import com.mercadopago.MercadoPagoConfig;
import com.mercadopago.client.preference.*;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.preference.Preference;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class MercadoPagoServiceImpl implements MercadoPagoService {

    @Value("${mercadopago.access_token}")
    private String accessToken;

    @PostConstruct
    public void init() {
        MercadoPagoConfig.setAccessToken(accessToken);
    }

    @Override
    public Preference createPaymentPreference(OrdenCompra ordenCompra) throws MPException, IOException, MPApiException {
        List<PreferenceItemRequest> items = new ArrayList<>();
        for (DetalleOrden detalle : ordenCompra.getDetalles()) {
            PreferenceItemRequest itemRequest = PreferenceItemRequest.builder()
                    .title(detalle.getProducto().getNombre())
                    .quantity(detalle.getCantidad())
                    .unitPrice(new BigDecimal(detalle.getPrecioUnitario()))
                    .build();
            items.add(itemRequest);
        }

        PreferenceBackUrlsRequest backUrls = PreferenceBackUrlsRequest.builder()
                .success("https://localhost:5173/success") // URL de exito
                .failure("https://localhost:5173/failure") // URL de fallo
                .pending("https://localhost:5173/pending") // URL pendiente
                .build();

        List<PreferencePaymentTypeRequest> excludedPaymentTypes = new ArrayList<>();
        excludedPaymentTypes.add(PreferencePaymentTypeRequest.builder().id("ticket").build());

        PreferencePaymentMethodsRequest paymentMethods = PreferencePaymentMethodsRequest.builder()
                .excludedPaymentTypes(excludedPaymentTypes)
                .installments(1)
                .build();

        PreferenceRequest preferenceRequest = PreferenceRequest.builder()
                .items(items)
                .backUrls(backUrls)
                .paymentMethods(paymentMethods)
                .build();
        
        PreferenceClient client = new PreferenceClient();
        return client.create(preferenceRequest);
    }
} 