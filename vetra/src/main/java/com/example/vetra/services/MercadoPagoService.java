package com.example.vetra.services;

import com.example.vetra.entities.OrdenCompra;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.preference.Preference;
import java.io.IOException;

public interface MercadoPagoService {
    Preference createPaymentPreference(OrdenCompra ordenCompra) throws MPException, IOException, MPApiException;
} 