package nl.novi.techiteasy1121.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

// GETTERS AND SETTERS OP DEZE MANIER WORDEN GEGENEREERD DOOR LOMBOK
@Getter
@Setter

@Entity
@Table(name = "remote_controllers") // meervoud want meerdere remotes in de table
public class RemoteController {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

    // DE VARIABELEN
    // PRIVATE WANT IN CONTACT MET DATABASE INFORMATIE

    private String compatibleWith;
    private String batteryType;
    private String name;
    private String brand;
    private Double price;
    private Integer originalStock;

    // DE RELATIE
    // 1 REMOTECONTROLLER VOOR 1 TELEVISIE (DUS HOEFT NIET IN EEN LIJST OID)
    // DE REMOTECONTROLLERS WORDEN GEMAPT DOOR DE ENTITEIT IN DEBRELATIE ONETOONE AAN DE ANDERE KANT
    // IN DIT GEVAL IN TELEVISION EN DIE HEET REMOTECONTROLLER -
    // LET OP PRECIES DE JUISTE SPELLING!
    // IS TELEVISION DAN IN DIT GEVAL DE PARENT??
    // ALS JE EN TELEVISIE OPHAALT, KRIJG JE OOK DE REMOTECONTROLLER TE ZIEN, NIET ANDERSOM

    @OneToOne(mappedBy = "remoteController")
    private Television television;


    // DE CONSTRUCTOR ( AUTOMATISCH GENEREREN )

    public RemoteController(Long id, String compatibleWith, String batteryType, String name, String brand, Double price, Integer originalStock) {
        this.id = id;
        this.compatibleWith = compatibleWith;
        this.batteryType = batteryType;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.originalStock = originalStock;
    }


    // EN DE DEFAULT CONSTRUCTOR ( ZONDER INFORMATIE )
    // JAVA'S WIL :)
    // ZO KAN JE ALTIJD EEN (LEGE) ENTITEIT AANMAKEN

    public RemoteController() {

    }
}
