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
@Table(name = "wall_brackets") // meervoud want meerdere brackets in de table

public class WallBracket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // DE VARIABELEN
    // PRIVATE WANT IN CONTACT MET DATABASE INFORMATIE

    private String size;
    private Boolean adjustable;
    private String name;
    private Double price;

    // DE RELATIES

    // ER KUNNEN MEERDERE TELEVISIES OP MEERDERE WALLBRACKETS
    // DUS JE MAAKT EEN LIJST AAN IN WALLBRACKETS WAAR DIE TELEVISIES IN ZITTEN
    // IN DIT GEVAL EEN HASH SET - HOUDT REKENING MET DUPLICATES

    @ManyToMany(mappedBy = "wallBrackets" )
    private Set<Television> televisions = new HashSet<>();

    // DE CONSTRUCTOR ( AUTOMATISCH GENEREREN )

    public WallBracket(Long id, String size, Boolean adjustable, String name, Double price) {
        this.id = id;
        this.size = size;
        this.adjustable = adjustable;
        this.name = name;
        this.price = price;
    }


    // EN DE LEGE CONSTRUCTOR
    // JAVA'S WIL :)
    // ZO KAN JE ALTIJD EEN (LEGE) ENTITEIT AANMAKEN

    public WallBracket() {

    }
}
