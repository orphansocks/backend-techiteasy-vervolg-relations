package nl.novi.techiteasy1121.controllers;

import nl.novi.techiteasy1121.dtos.wallbracket.WallBracketDto;
import nl.novi.techiteasy1121.dtos.wallbracket.WallBracketInputDto;
import nl.novi.techiteasy1121.services.WallBracketService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    // WAT JE TERUG ONTVANGT IS EEN OK + LIJST MET WALLBRACKETDTO'S BODY'S
   @GetMapping
    public ResponseEntity<List<WallBracketDto>> getAllWallBrackets() {

        List<WallBracketDto> wallBrackets = wallBracketService.getAllWallBrackets();

        return ResponseEntity.ok().body(wallBrackets);

   }


// DE METHODE OM 1 WALBRACKET OP TE HALEN MBV DE ID
    // WAT JE TERUG WILT GEVEN IS DE WALLBRACKETDTO DIE JE OPHAALT MET DE METHODE GETTWALLBRACKET

    @GetMapping("/{id}")
    public ResponseEntity<WallBracketDto> getWallBracket(@PathVariable("id") Long id) {

        WallBracketDto wallBracketDto = wallBracketService.getWallBracket(id);

        return ResponseEntity.ok(wallBracketDto);
    }

    @PostMapping()
    public ResponseEntity<WallBracketDto> addWallBracket(@RequestBody WallBracketInputDto dto) {
        WallBracketDto wallBracket = wallBracketService.addWallBracket(dto);
        return ResponseEntity.created(null).body(wallBracket);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteWallBracket(@PathVariable Long id) {
        wallBracketService.deleteWallBracket(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<WallBracketDto> updateWallBracket(@PathVariable Long id, @RequestBody WallBracketDto dto) {
        var returnDto = wallBracketService.updateWallBracket(id, dto);
        return ResponseEntity.ok(returnDto);
    }

    // Deze methode haalt alle televisies op die aan een bepaalde wallbracket gekoppeld zijn.
    // Deze methode maakt gebruikt van de televisionWallBracketService.

    //@GetMapping("/wallbrackets/televisions/{wallBracketId}")
    //public ResponseEntity<Collection<TelevisionDto>> getTelevisionsByWallBracketId(@PathVariable("wallBracketId") Long wallBracketId){
       // return ResponseEntity.ok(televisionWallBracketService.getTelevisionsByWallBracketId(wallBracketId));
   // }


}
