package nl.novi.techiteasy1121.services;

import nl.novi.techiteasy1121.dtos.wallbracket.WallBracketDto;
import nl.novi.techiteasy1121.dtos.wallbracket.WallBracketInputDto;
import nl.novi.techiteasy1121.exceptions.RecordNotFoundException;
import nl.novi.techiteasy1121.models.WallBracket;
import nl.novi.techiteasy1121.repositories.WallBracketRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// DEZE KLASSE BEVAT DE SERVICEMETHODES VAN DE WALLBRACKET
@Service
public class WallBracketService {

    // DE SERVICELAAG COMMUNICEERT MET DE REPOSITORY
    private WallBracketRepository wallBracketRepository;

    // DE CONSTRUCTOR
    public WallBracketService(WallBracketRepository wallBracketRepository) {
        this.wallBracketRepository = wallBracketRepository;
    }

// BETER GENERIEK HELPERFUNCTIES MAKEN IPV ALLES DUBBEL UITTYPEN??

    // DE METHODE VOOR HET OPHALEN VAN DE WALLBRACKETS UIT DE REPOSITORY
    // CONTROLLER (TELEVISIONDTO) < > DE SERVICE KOPPELT < > TELEVISIONS (ENTITEIT) IN DE REPOSITORY
    public List<WallBracketDto> getAllWallBrackets() {
        List<WallBracket> wallBracketList = wallBracketRepository.findAll();
        List<WallBracketDto> dtos = new ArrayList<>();

        for (WallBracket wb : wallBracketList) {
            dtos.add(transferToDto(wb));
        }
        return dtos;
    }

    // DIT IS DE METHODE OM 1 WALLBRACKET PER ID OP TE HALEN
    // ALS DE MOGELIJKE WALLBRACKET IS GEVONDEN IN DE REPOSITORY
    // DAN IS DE GEVRAAGDE WALLBRACKET PER ID GELIJK AAN DE DTO
    // STOP DAN DIE WALLBRACKET IN DE TRANSFER EN RETURN
    public WallBracketDto getWallBracket(Long id) {
        Optional<WallBracket> wallBracketOptional = wallBracketRepository.findById(id);

        if (wallBracketOptional.isPresent()) {
            WallBracket wallBracket = wallBracketOptional.get();
            return transferToDto(wallBracket);
        } else {
            throw new RecordNotFoundException("No Wallbracket found");
        }
    }

    // DIT IS DE METHODE OM EEN WALLBRACKET TOE TE VOEGEN
    // DIE EEN WALLBRACKETDTO IN INPUT VERWACHT
    // DEZE WALLBRACKET DTO MOET VERTAALD WORDEN NAAR EEN WALLBRACKET IN DE REPOSITORY
    // EN DAAR OOK WORDEN OPGESLAGEN
    // TERUG GEGEVEN WORDT DE TRANSFERDATADTO

    public WallBracketDto addWallBracket(WallBracketInputDto dto) {
        WallBracket wb = transferToWallBracket(dto);
        wallBracketRepository.save(wb);

        return transferToDto(wb);
    }


    // DIT IS DE METHODE OM EEN WALLBRACKET TE VERWIJDEREN

    public void deleteWallBracket(Long id) {
        wallBracketRepository.deleteById(id);
    }

    // DIT IS DE METHODE OM EEN WALLBRACKET TE WIJZIGEN
    // ALS DE WALLBRACKET NIET BESTAAN NA INVULLEN ID - DAN NIET GEVONDEN
    // ALS DE OPGESLAGEN WALLBRACKET GELIJK IS AAN DE GEVRAAGDE WALLBRACKET PAS DAN AAN
    //  SLA DE GEGEVENS WEER OP IN DE REPOSITORY EN VERTAAL NAAR DTO EN GEEF TERUG
    public WallBracketDto updateWallBracket(Long id, WallBracketDto wallBracketDto) {
        if (!wallBracketRepository.existsById(id)) {
            throw new RecordNotFoundException("No wallbracket found");
        }
        WallBracket storedWallBracket = wallBracketRepository.findById(id).orElse(null);

        //storedWallBracket.setId(wallBracketDto.getId());
        storedWallBracket.setSize(wallBracketDto.getSize());
        storedWallBracket.setAdjustable(wallBracketDto.getAdjustable());
        storedWallBracket.setName(wallBracketDto.getName());
        storedWallBracket.setPrice(wallBracketDto.getPrice());

        return transferToDto(wallBracketRepository.save(storedWallBracket));
    }

    // DE METHODE VOOR HET VERTALEN VAN DE WALLBRACKET NAAR DE WALLBRACKETDTO
    // DIE EEN WALLBRACKET VERWACHT
    // NEW IS DE DTO DUS DTO.SET en GET FROM WALLBRACKET
    public WallBracketDto transferToDto(WallBracket wallBracket) {
        WallBracketDto dto = new WallBracketDto();

        dto.setId(wallBracket.getId());
        dto.setSize(wallBracket.getSize());
        dto.setAdjustable(wallBracket.getAdjustable());
        dto.setName(wallBracket.getName());
        dto.setPrice(wallBracket.getPrice());

        return dto;

    }

    // DE METHODE DIE DE INPUTDTO OMZET NAAR DE WALLBRACKETMODEL
    // DTO <> SERVICE <> MODELENTITY
    // INGEGEVEN WORDT DE INPUTDTO
    // TERUGGEGEVEN WORDT DE WALLBRACKET MODELENTITY
    public WallBracket transferToWallBracket(WallBracketInputDto wallBracketInputDto) {
        WallBracket wallBracket = new WallBracket();

        wallBracket.setSize(wallBracketInputDto.getSize());
        wallBracket.setAdjustable(wallBracketInputDto.getAdjustable());
        wallBracket.setName(wallBracketInputDto.getName());
        wallBracket.setPrice(wallBracketInputDto.getPrice());

        return wallBracket;


    }
}




