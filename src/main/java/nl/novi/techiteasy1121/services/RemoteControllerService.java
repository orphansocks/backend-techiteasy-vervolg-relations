package nl.novi.techiteasy1121.services;

import nl.novi.techiteasy1121.repositories.RemoteControllerRepository;
import org.springframework.stereotype.Service;

@Service
public class RemoteControllerService {

    // DE SERVICELAAG COMMUNICEERT MET DE REPOSITORY
    // DE VARIABELE
    private final RemoteControllerRepository remoteControllerRepository;

    //GENERATE DE CONSTRUCTOR
    public RemoteControllerService(RemoteControllerRepository remoteControllerRepository) {
        this.remoteControllerRepository = remoteControllerRepository;
    }









}
