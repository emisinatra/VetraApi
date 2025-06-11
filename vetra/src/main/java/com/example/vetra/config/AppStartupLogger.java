package com.example.vetra.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class AppStartupLogger {

    private static final Logger logger = LoggerFactory.getLogger(AppStartupLogger.class);

    @EventListener(ApplicationReadyEvent.class)
    public void logStartup() {
        logger.info("--- INICIO EXITOSO --- de server de Vetra ¡Listo para la acción!");
    }
}
