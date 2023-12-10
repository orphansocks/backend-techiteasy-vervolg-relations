package nl.novi.techiteasy1121.controllers;


import nl.novi.techiteasy1121.services.RemoteControllerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


//REQUESTMAPPING VOOR 1 URL OP EEN CENTRALE PLAATS
@RequestMapping("/remotecontrollers")
@RestController
public class RemoteControllerController {

    // DE CONTROLLER COMMUNICEERT MET DE SERVICELAAG (DUS IMPORT)
    private final RemoteControllerService remoteControllerService;

    // DE CONSTRUCTOR
    public RemoteControllerController(RemoteControllerService remoteControllerService)
    { this.remoteControllerService = remoteControllerService;}




}
