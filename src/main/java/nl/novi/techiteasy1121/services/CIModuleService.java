package nl.novi.techiteasy1121.services;

import nl.novi.techiteasy1121.dtos.cimodule.CIModuleDto;
import nl.novi.techiteasy1121.exceptions.RecordNotFoundException;
import nl.novi.techiteasy1121.models.CIModule;
import nl.novi.techiteasy1121.repositories.CIModuleRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

// DE SERVICELAAG FUNCTIONS
    // GET ALL ENTITIES
    // GET ONE ENTITY (BY ID)
    // ADD ONE ENTITY
    // DELETE ONE ENTITY
    // UPDATE ONE ENTITY
    // TRANSFER TO ENTITY
    // TRANSFER TO DTO

public List<CIModuleDto> getAllCIModules() {

    List<CIModule> ciModules = ciModuleRepository.findAll();
    List<CIModuleDto> dtos = new ArrayList<>();

    for (CIModule ciModule : ciModules) {
        dtos.add(transferToDto(ciModule));
    }
    return dtos;

}

    public CIModuleDto getCIModule(Long id) {
        Optional<CIModule> ciModuleOptional = CIModuleRepository.findById(id);

        if (ciModuleOptional.isPresent()) {
            CIModule ciModule = ciModuleOptional.get();

            return transferToDto(ciModule);

        } else {

            throw new RecordNotFoundException("no Ci-Module found");
        }

    }

    public CIModuleDto addCIModule(CIModuleDto ciModuleDto) {
        ciModuleRepository.save(transferToCIModule(ciModuleDto));
        return ciModuleDto;
    }



    public void deleteCIModule(Long id) {
        ciModuleRepository.deleteById(id);
    }

    public CIModuleDto updateCIModule(Long id, CIModule ciModuleDto) {

    if(!ciModuleRepository.existsById(id)) {
        throw new RecordNotFoundException("No ci-module found");

    } else {
        CIModule storedCIModule = ciModuleRepository.findById(id).orElse(null);

        //storedCIModule.setId(ciModuleDto.getId());
        storedCIModule.setName(ciModuleDto.getName());
        storedCIModule.setType(ciModuleDto.getType());
        storedCIModule.setPrice(ciModuleDto.getPrice());

        return transferToDto(ciModuleRepository.save(storedCIModule));
    }
}

    public CIModuleDto transferToDto(CIModule ciModule) {
        CIModuleDto dto = new CIModuleDto();

        dto.setId(ciModule.getId());
        dto.setName(ciModule.getName());
        dto.setPrice(ciModule.getPrice());
        dto.setType(ciModule.getType());

        return dto;
    }

    public CIModule transferToCIModule(CIModuleDto dto){
        CIModule ciModule = new CIModule();

        ciModule.setId(dto.getId());
        ciModule.setName(dto.getName());
        ciModule.setType(dto.getType());
        ciModule.setPrice(dto.getPrice());

        return ciModule;
    }




}