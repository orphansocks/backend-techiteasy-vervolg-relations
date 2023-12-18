package nl.novi.techiteasy1121.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

// GETTERS AND SETTERS OP DEZE MANIER WORDEN GEGENEREERD DOOR LOMBOK
@Getter
@Setter

@Entity
@Table(name = "ci_modules") // meervoud want meerdere modules in de table
public class CIModule {

    // DE KEY MET DE GENERATED VALUE

    @Id
    @GeneratedValue
    private Long id;

    // DE VARIABELEN
    // PRIVATE WANT IN CONTACT MET DATABASE INFORMATIE

    private String name;
    private String type;
    private Double price;

    // RELATIES

    // EEN TV KAN 1 KAART HEBBEN, MAAR EEN KAART KAN IN MEERDERE TVS ZITTEN
    // DUS DE ONE-KANT IS CIMODULE DIE DE JUISTE LIJST MET TELEVISIES OPHAALT

    @OneToMany(mappedBy = "CIModule")
    private Set<Television> televisions = new HashSet<>();

    // DE CONSTRUCTOR ( AUTOMATISCH GENEREREN )

    public CIModule(Long id, String name, String type, Double price) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
    }

    // EN DE DEFAULT CONSTRUCTOR ( ZONDER INFORMATIE )
    // JAVA'S WIL :)
    // ZO KAN JE ALTIJD EEN (LEGE) ENTITEIT AANMAKEN
    public CIModule() {

    }
}
