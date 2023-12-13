package nl.novi.techiteasy1121.controllers;


import nl.novi.techiteasy1121.dtos.wallbracket.WallBracketDto;
import nl.novi.techiteasy1121.services.WallBracketService;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//REQUESTMAPPING VOOR 1 URL OP EEN CENTRALE PLAATS
@RequestMapping("/wallbrackets")
@RestController
public class WallBracketController {

    // DE CONTROLLER COMMUNICEERT MET DE SERVICELAAG
    private final WallBracketService wallBracketService;

    // GENERATE CONSTRUCTOR MET DE JUISTE PARAMETER
    public WallBracketController(WallBracketService wallBracketService) {
        this.wallBracketService = wallBracketService;
    }

// DE METHODE OM ALLE WALLBRACKETS OP TE HALEN
    // DE PARAMETER WAARMEE JE OPHAALT IS DE NAME
    // WAT JE TERUG ONTVANGT IS EEN LIJST MET WALLBRACKETDTO'S
   @GetMapping
    public ResponseEntity<List<WallBracketDto>> getAllWallBrackets (@RequestParam(value = "name", required = false) Optional<String> name) {
        List<WallBracketDto> wallBracketDtos;

        if (name.isEmpty()){
            wallBracketDtos = wallBracketService.getAllWallBrackets();
        } else {
            wallBracketDtos = wallBracketService.getAllWallBracketsByName(name.get());
        }

        return ResponseEntity.ok().body(wallBracketDtos);

   }




}
