package com.example.vetra.controllers;

import com.example.vetra.entities.Talle;
import com.example.vetra.services.Impl.TalleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/talles")
//Esto permite que el front pueda hacer request, si no estuviera, al hacer una request lanzaria CORS error.
@CrossOrigin(origins = "http://localhost:5173")
public class TalleController extends BaseControllerImpl<Talle, TalleServiceImpl> {

    @Autowired
    public TalleController(TalleServiceImpl talleService) {
        super(talleService);
    }

    // Acordate que los endpoints CRUD ya vienen de arriba, del BaseControllerImpl.
    // Si no queremos que se puedan actualizar los talles (y el TalleServiceImpl tira error en el update),
    // entonces el endpoint PUT ("/{id}") va a fallar como corresponde.
    // Si sí se pueden actualizar, BaseControllerImpl se encarga de todo.
}
