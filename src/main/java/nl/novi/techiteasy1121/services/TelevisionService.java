package nl.novi.techiteasy1121.services;

import nl.novi.techiteasy1121.dtos.television.TelevisionDto;
import nl.novi.techiteasy1121.dtos.television.TelevisionInputDto;
import nl.novi.techiteasy1121.exceptions.RecordNotFoundException;
import nl.novi.techiteasy1121.models.RemoteController;
import nl.novi.techiteasy1121.models.Television;
import nl.novi.techiteasy1121.repositories.RemoteControllerRepository;
import nl.novi.techiteasy1121.repositories.TelevisionRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// @SERVICE WANT SPRING HERKENT DEZE ANNOTATIE
@Service
public class TelevisionService {

    // DE SERVICELAAG COMMUNICEERT MET DE REPOSITORY
    // DE VARIABELE (OOK VOOR HET KOPPELEN VAN DE REMOTE)
    private final TelevisionRepository televisionRepository;
    private final RemoteControllerRepository remoteControllerRepository;

    // GENERATE DE CONSTRUCTOR (+ REMOTECONTROLLER)
    public TelevisionService(TelevisionRepository televisionRepository,
                             RemoteControllerRepository remoteControllerRepository) {
        this.televisionRepository = televisionRepository;
        this.remoteControllerRepository = remoteControllerRepository;
    }

    // DE SERVICELAAG FUNCTIONS:

    // DIT IS DE METHODE VOOR HET OPVRAGEN VAN ALLE TELEVISIES IN DE REPOSITORY
    // CONTROLLER (DTO) < > SERVICE < > TELEVISIONS (ENTITEIT) IN DE REPOSITORY
    // AAN DE REPOSITORY KAN JE EEN LIJST MET TELEVISIONS VRAGEN (GETALLTELEVISIONS)
    // DIE DE SERVICE MOET VERTALEN NAAR DTO'S OM TERUG TE GEVEN AAN DE CONTROLLER

    public List<TelevisionDto> getAllTelevisions() {
        List<Television> tvList = televisionRepository.findAll();
        List<TelevisionDto> tvDtoList = new ArrayList<>();

        for (Television tv : tvList) {
            TelevisionDto dto = transferToDto(tv);
            tvDtoList.add(dto);
        }
        return tvDtoList;
    }

    // DIT IS DE METHODE VOOR HET OPVRAGEN VAN TELEVISIES PER CATEGORIE IN DE REPOSITORY
    // CONTROLLER (DTO) < > SERVICE < > TELEVISIONS (ENTITEIT) IN DE REPOSITORY
    // AAN DE REPOSITORY KAN JE SPECIEFIEKE TELEVISIES OPRAGEN (IN DIT GEVAL PER BRAND)
    // DE SERVICE MOET VERTALEN NAAR LIJST MET DTO'S OM TERUG TE GEVEN AAN DE CONTROLLER

    public List<TelevisionDto> getAllTelevisionsByBrand(String brand) {
        List<Television> tvList = televisionRepository.findAllTelevisionsByBrandEqualsIgnoreCase(brand);
        List<TelevisionDto> tvDtoList = new ArrayList<>();

        for (Television tv : tvList) {
            TelevisionDto dto = transferToDto(tv);
            tvDtoList.add(dto);
        }
        return tvDtoList;
    }

    // DIT IS DE METHODE VOOR HET OPVRAGEN VAN 1 TELEVISIE IN DE REPOSITORY
    // CONTROLLER (DTO) < > SERVICE < > TELEVISION (ENTITEIT) IN DE REPOSITORY
    // AAN DE REPOSITORY KAN JE EEN SPECIEFIEKE TELEVISIES OPRAGEN (IN DIT GEVAL PER ID)
    // DE SERVICE MOET VERTALEN NAAR DTO OM TERUG TE GEVEN AAN DE CONTROLLER
    // BIJ NIET GEVONDEN GEEF JE EEN RECORDNOTFOUND TERUG

    public TelevisionDto getTelevisionById(Long id) {
        Optional<Television> televisionOptional = televisionRepository.findById(id);

        if (televisionOptional.isPresent()) {
            Television tv = televisionOptional.get();
            return transferToDto(tv);
        } else {
            throw new RecordNotFoundException("geen televisie gevonden");
        }
    }


    // DIT IS DE METHODE VOOR HET TOEVOEGEN VAN 1 TELEVISIE IN DE REPOSITORY
    // DE INPUT DTO KOMT BINNEN EN WORDT EEN TV (TRANSFERTOTELEVISION)
    // CONTROLLER (DTO) < > SERVICE < > TELEVISION (TV) (ENTITEIT) IN DE REPOSITORY
    // DE TV WORDT OPGESLAGEN
    // EN WORDT WEER TERUG GEGEVEN ALS EEN TRANSFERTODTO


    public TelevisionDto addTelevision(TelevisionInputDto dto) {

        Television tv = transferToTelevision(dto);
        televisionRepository.save(tv);

        return transferToDto(tv);
    }

    // DIT IS DE METHODE VOOR HET VERWIJDEREN VAN EEN TELEVISIE UIT DE REPOSITORY
    // JE HEBT HIER NATUURLIJK DE UNIEKE ID VOOR NODIG
    public void deleteTelevision(@RequestBody Long id) {

        televisionRepository.deleteById(id);

    }

// DIT IS DE METHODE OM DE DATE IN EEN TELEVISION OPGESLAGEN IN DE REPOSITORY TE WIJZIGEN
    // JE HEBT HIER NATUURLIJK DE UNIEKE ID VOOR NODIG EN DE JUISTE DATA
    // ALS DE DATA IN DE REPOSITORY AANWEZIG IS, HAAL DAN ALLE DATA OP (GET) EN GEEF TERUG ALS DTO
    // BIJ NIET GEVONDEN THROW RECORDNOTFOUND

    // CONTROLLER (DTO) < > SERVICE < > TELEVISION (TV) (ENTITEIT) IN DE REPOSITORY

    // TRANSFERTODTO (CONTROLLER) < UPDATETELEVISION (SERVICE) > TRANSFERTELEVISION (REPOSITORY)

    public TelevisionDto updateTelevision(Long id, TelevisionInputDto newTelevision) {

        Optional<Television> televisionOptional = televisionRepository.findById(id);

        if (televisionOptional.isPresent()) {

            Television television1 = televisionOptional.get();


            television1.setAmbiLight(newTelevision.getAmbiLight());
            television1.setAvailableSize(newTelevision.getAvailableSize());
            television1.setAmbiLight(newTelevision.getAmbiLight());
            television1.setBluetooth(newTelevision.getBluetooth());
            television1.setBrand(newTelevision.getBrand());
            television1.setHdr(newTelevision.getHdr());
            television1.setName(newTelevision.getName());
            television1.setOriginalStock(newTelevision.getOriginalStock());
            television1.setPrice(newTelevision.getPrice());
            television1.setRefreshRate(newTelevision.getRefreshRate());
            television1.setScreenQuality(newTelevision.getScreenQuality());
            television1.setScreenType(newTelevision.getScreenType());
            television1.setSmartTv(newTelevision.getSmartTv());
            television1.setSold(newTelevision.getSold());
            television1.setType(newTelevision.getType());
            television1.setVoiceControl(newTelevision.getVoiceControl());
            television1.setWifi(newTelevision.getWifi());

            Television returnTelevision = televisionRepository.save(television1);

            return transferToDto(returnTelevision);

        } else {

            throw new RecordNotFoundException("geen televisie gevonden");

        }

    }

// DIT IS DE METHOD VOOR HET VERTALEN VAN DE UPDATE NAAR DE TELEVISION IN DE REPOSITORY

    public Television transferToTelevision(TelevisionInputDto dto) {
        Television television = new Television();

        television.setType(dto.getType());
        television.setBrand(dto.getBrand());
        television.setName(dto.getName());
        television.setPrice(dto.getPrice());
        television.setAvailableSize(dto.getAvailableSize());
        television.setRefreshRate(dto.getRefreshRate());
        television.setScreenType(dto.getScreenType());
        television.setScreenQuality(dto.getScreenQuality());
        television.setSmartTv(dto.getSmartTv());
        television.setWifi(dto.getWifi());
        television.setVoiceControl(dto.getVoiceControl());
        television.setHdr(dto.getHdr());
        television.setBluetooth(dto.getBluetooth());
        television.setAmbiLight(dto.getAmbiLight());
        television.setOriginalStock(dto.getOriginalStock());
        television.setSold(dto.getSold());

        return television;
    }

    // DIT IS DE METHOD VOOR HET VERTALEN VAN DE TELEVISIE NAAR DE DTO IN DE CONTROLLER
    public TelevisionDto transferToDto(Television television) {
        TelevisionDto dto = new TelevisionDto();

        dto.setId(television.getId());
        dto.setType(television.getType());
        dto.setBrand(television.getBrand());
        dto.setName(television.getName());
        dto.setPrice(television.getPrice());
        dto.setAvailableSize(television.getAvailableSize());
        dto.setRefreshRate(television.getRefreshRate());
        dto.setScreenType(television.getScreenType());
        dto.setScreenQuality(television.getScreenQuality());
        dto.setSmartTv(television.getWifi());
        dto.setWifi(television.getWifi());
        dto.setVoiceControl(television.getVoiceControl());
        dto.setHdr(television.getHdr());
        dto.setBluetooth(television.getBluetooth());
        dto.setAmbiLight(television.getAmbiLight());
        dto.setOriginalStock(television.getOriginalStock());
        dto.setSold(television.getSold());

        return dto;
    }

    public void assignRemoteControllerToTelevision(Long id, Long remoteControllerId) {
        
        Optional<Television> optionalTelevision = televisionRepository.findById(id);
        Optional<RemoteController> optionalRemoteController = remoteControllerRepository.findById(remoteControllerId);

        if (optionalTelevision.isPresent() && optionalRemoteController.isPresent()) {
            Television television = optionalTelevision.get();
            RemoteController remoteController = optionalRemoteController.get();

            television.setRemoteController(remoteController);
            televisionRepository.save(television);
        } else {
            throw new RecordNotFoundException();
        }
    }

}