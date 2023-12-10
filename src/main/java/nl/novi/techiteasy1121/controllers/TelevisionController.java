package nl.novi.techiteasy1121.controllers;

import nl.novi.techiteasy1121.dtos.television.TelevisionDto;
import nl.novi.techiteasy1121.dtos.television.TelevisionInputDto;
import nl.novi.techiteasy1121.services.TelevisionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;


// DE CONTROLLER IS DE LAAG WAAR DE HTTP REQUESTS BINNEN KOMEN
// EN WAAR DE RESPONSE WEER WORDT TERUG GEGEVEN
// RESTFUL COMMUNICATIE VIA MAP METHODS: POST - GET - PUT - DELETE
@RestController
public class TelevisionController {

    // DE TELEVISIONS KOMEN NU UIT DE SERVICELAAG (IPV DIRECT UIT DE REPOSITORY)
    private final TelevisionService televisionService;


    public TelevisionController(TelevisionService televisionService){
        this.televisionService = televisionService;
    }

    // GETALLTELEVISIONS
    // DE METHOD OM ALLE TELEVISIONS (MEERVOUD) OP TE HALEN
    // JE VERWACHT EEN LIJST MET TELEVISIONS TERUG
    // IN DIT GEVAL NU DTO'S!!
    // RESPONSE ENTITY IS ResponseEntity<List<TelevisionDto>>
    @GetMapping("/televisions")
    public ResponseEntity<List<TelevisionDto>> getAllTelevisions(@RequestParam(value = "brand", required = false) Optional<String> brand) {

        List<TelevisionDto> dtos;

        if (brand.isEmpty()){
            dtos = televisionService.getAllTelevisions();

        } else {
            dtos = televisionService.getAllTelevisionsByBrand(brand.get());

        }

        return ResponseEntity.ok().body(dtos);

    }

    // DE METHODE OM 1 TELEVISIE OP TE HALEN (ID = KEY)
    // GETALLTELEVISION (ENKELVOUD!)
    // JE VERWACHT (UIT DE SERVICE) 1 TELEVISIE-DTO TERUG
    // RESPONSE ENTITY IS ResponseEntity<<TelevisionDto>
    @GetMapping("/televisions/{id}")
    public ResponseEntity<TelevisionDto> getTelevision(@PathVariable("id")Long id) {

        // We spreken hier ook weer een service methode aan in plaats van direct de repository aan te spreken
        TelevisionDto television = televisionService.getTelevisionById(id);

            return ResponseEntity.ok().body(television);

    }

    // DE METHOD OM 1 TELEVISION-DTO AAN TE MAKEN (INPUT!)
    // DAARVOOR HEB JE EEN VALID BODY NODIG EN ALS PARAMETER DE BODY
    // EN DE TELEVISION-INPUT-DTO WIL JE NATUURLIJK OOK TOEVOEGEN AAN DE TELEVISIONSERVICE
    // ALS RESPONSE WIL JE HOREN DAT DE DTO CREATED IS
    @PostMapping("/televisions")
    public ResponseEntity<TelevisionDto> addTelevision(@Valid @RequestBody TelevisionInputDto televisionInputDto) {

        TelevisionDto dto = televisionService.addTelevision(televisionInputDto);

        return ResponseEntity.created(null).body(dto);

    }

    // DE METHODE OM 1 TELEVISIE TE DELETEN
    // MBV DE ID
    @DeleteMapping("/televisions/{id}")
    public ResponseEntity<Object> deleteTelevision(@PathVariable Long id) {

        televisionService.deleteTelevision(id);

        return ResponseEntity.noContent().build();

    }

    // DE METHODE OM EEN TELEVISIE TE UPDATEN MET NIEUWE INFO MBV DE ID
    // JE VERWACHT DE NIEUWE TELVISIONDTO TERUG MET DE UPDATE
    // ALS PARAMETER HEB JE NODIG DE ID EN DE TELEVISION-INPUT-DTO VAN DE NIEUWE (AANGEPASTE) TELEVISIE
    // TERUG GEGEVEN WORDT DE NIEUWE INFO EN OK
    @PutMapping("/televisions/{id}")
    public ResponseEntity<TelevisionDto> updateTelevision(@PathVariable Long id, @Valid @RequestBody TelevisionInputDto newTelevision) {

        TelevisionDto dto = televisionService.updateTelevision(id, newTelevision);

        return ResponseEntity.ok().body(dto);
    }

}
