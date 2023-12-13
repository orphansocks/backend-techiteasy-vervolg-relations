package nl.novi.techiteasy1121.services;

import nl.novi.techiteasy1121.dtos.wallbracket.WallBracketDto;
import nl.novi.techiteasy1121.dtos.wallbracket.WallBracketInputDto;
import nl.novi.techiteasy1121.models.WallBracket;
import nl.novi.techiteasy1121.repositories.WallBracketRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WallBracketService {

    // DE SERVICE COMMUNICEERT MET DE REPOSITORY
    private final WallBracketRepository wallBracketRepository;

    // DE CONSTRUCTOR
    public WallBracketService(WallBracketRepository wallBracketRepository) {
        this.wallBracketRepository = wallBracketRepository;
    }


    // DE METHODE VOOR HET OPHALEN VAN DE WALLBRACKETS VANUIT DE CONTROLLER
    // CONTROLLER (DTO) < > SERVICE < > TELEVISIONS (ENTITEIT) IN DE REPOSITORY
    public List<WallBracketDto> getAllWallBrackets() {
        List<WallBracket> wallBracketList = wallBracketRepository.findAll();
        List<WallBracketDto> wallBracketDtoList = new ArrayList<>();

        for(WallBracket wb : wallBracketList) {
            WallBracketDto wallBracketDto = transferToDto(wb);
            wallBracketDtoList.add(wallBracketDto);
        }
        return wallBracketDtoList;
    }

    public List<WallBracketDto> getAllWallBracketsByName(String name) {
        List<WallBracket> wallBracketList = wallBracketRepository.findAll();
        List<WallBracketDto> wallBracketDtoList = new ArrayList<>();

        for(WallBracket wb : wallBracketList) {
            WallBracketDto wallBracketDto = transferToDto(wb);
            wallBracketDtoList.add(wallBracketDto);
        }

        return wallBracketDtoList;
    }

    // DIT IS DE METHODE OM EEN WALLBRACKET TOE TE VOEGEN
    // DIE EEN WALLBRACKETDTO IN INPUT VERWACHT
    // DEZE WALLBRACKET DTO MOET VERTAALD WORDEN NAAR EEN WALLBRACKET IN DE REPOSITORY
    // EN DAAR OOK WORDEN OPGESLAGEN
    // TERUG GEGEVEN WORDT DE TRANSFERDATADTO

    public WallBracketDto addWallBracket(WallBracketInputDto wallBracketDto) {
        WallBracket wb = transferToWallBracket(wallBracketDto);
        wallBracketRepository.save(wb);

        return transferToDto(wb);
    }

    // DE METHODE VOOR HET VERTALEN VAN DE WALLBRACKET NAAR DE WALLBRACKETDTO
    // DIE EEN WALLBRACKET VERWACHT
    // GEBRUIKT DE GET AND SET VAN DE WALLBRACKETDTO
    public WallBracketDto transferToDto(WallBracket wallBracket) {
        WallBracketDto wallBracketDto = new WallBracketDto();

        wallBracketDto.setId(wallBracket.getId());
        wallBracketDto.setSize(wallBracket.getSize());
        wallBracketDto.setAdjustable(wallBracket.getAdjustable());
        wallBracketDto.setName(wallBracket.getName());
        wallBracketDto.setPrice(wallBracket.getPrice());

        return wallBracketDto;

    }

    public WallBracket transferToWallBracket(WallBracketInputDto wallBracketInputDto) {
        var wallBracket = new WallBracket();

        wallBracket.setSize(wallBracketInputDto.getSize());
        wallBracket.setAdjustable(wallBracketInputDto.getAdjustable());
        wallBracket.setName(wallBracketInputDto.getName());
        wallBracket.setPrice(wallBracketInputDto.getPrice());

        return wallBracket;


    }




}




