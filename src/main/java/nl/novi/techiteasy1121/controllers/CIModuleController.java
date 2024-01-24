package nl.novi.techiteasy1121.controllers;


import nl.novi.techiteasy1121.services.CIModuleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// DE CONTROLLER IS DE LAAG WAAR DE HTTP REQUESTS BINNEN KOMEN
// EN WAAR DE RESPONSE (BODY) WEER WORDT TERUG GEGEVEN
// RESTFUL COMMUNICATIE VIA MAP METHODS: POST - GET - PUT - DELETE
// REQUESTMAPPING VOOR 1 URL OP EEN CENTRALE PLAATS
@RequestMapping("/cimodules")
@RestController
public class CIModuleController {

    // DE CONTROLLER COMMUNICEERT MET DE SERVICELAAG
    private final CIModuleService ciModuleService;


    // GENERATE CONSTRUCTOR MET DE JUISTE PARAMETER - LET OP SCHRIJFWIJZE BESTANDSNAMEN
    public CIModuleController(CIModuleService ciModuleService) {
        this.ciModuleService = ciModuleService;
    }
}
