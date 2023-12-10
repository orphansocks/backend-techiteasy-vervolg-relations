package nl.novi.techiteasy1121.services;

import nl.novi.techiteasy1121.repositories.CIModuleRepository;
import org.springframework.stereotype.Service;

@Service
public class CIModuleService {

    // DE SERVICELAAG COMMUNICEERT MET DE REPOSITORY
    // DE VARIABELE
    private final CIModuleRepository ciModuleRepository;


    // GENERATE DE CONSTRUCTOR


    public CIModuleService(CIModuleRepository ciModuleRepository) {
        this.ciModuleRepository = ciModuleRepository;
    }
}
