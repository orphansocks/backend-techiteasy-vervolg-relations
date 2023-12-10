package nl.novi.techiteasy1121.controllers;


import nl.novi.techiteasy1121.services.CIModuleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//REQUESTMAPPING VOOR 1 URL OP EEN CENTRALE PLAATS
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
