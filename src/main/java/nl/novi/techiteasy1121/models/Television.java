package nl.novi.techiteasy1121.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter

@Entity
@Table(name = "televisions")
public class Television {

    //  DE PRIMARY KEY WORDT AUTOMATISCH GEGENEREERD
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // + optioneel meegeven van parameter hoe je de generatedvalue moet genereren
    private Long id;

    // DE VARIABELEN
    private String type;
    private String brand;
    private String name;
    private Double price;
    private Double availableSize;
    private Double refreshRate;
    private String screenType;
    private String screenQuality;
    private Boolean smartTv;
    private Boolean wifi;
    private Boolean voiceControl;
    private Boolean hdr;
    private Boolean bluetooth;
    private Boolean ambiLight;
    private Integer originalStock;
    private Integer sold;


    // DE RELATIES

    // ER IS 1 REMOTE CONTROLLER VOOR 1 TV
    // JE HOEFT DUS GEEN LIJST AAN TE MAKEN
    // DIT IS DE OWNER KANT VAN DE RELATIE
    @OneToOne
    private RemoteController remoteController;

    // EEN TV KAN 1 KAART HEBBEN, MAAR EEN KAART KAN IN MEERDERE TVS ZITTEN
    // DUS DE OWNERKANT/ DE MANY-KANT IS TELEVISIONS DIE DE JUISTE CIMODULE OPHAALT
    // FETCHTYPE IS NIET IN DE LES BESPROKEN
    // EAGER BIJ HEEL VEEL DATA KOST VEEL TIJD (BIJV FOTO"S OP TE HALEN)
    // LAZY HAALT PAS FOTOS OP ALS DE GET DAAR SPECIFIEK OM VRAAGT = SNELLER BIJ VEEL DATA
    @ManyToOne(fetch = FetchType.EAGER)
    private CIModule CIModule;

    // ER KUNNEN MEERDERE TELEVISIES OP MEERDERE WALLBRACKETS
    // DUS JE MAAKT EEN LIJST AAN WAAR DIE WALLBRACKETS IN ZITTEN
    // IN DIT GEVAL EEN HASH SET - HOUDT REKENING MET DUPLICATES
    // OOK MOET EEN GEZAMENLIJKE TABEL WORDEN AANGEMAAKT
    @ManyToMany(fetch = FetchType.EAGER)
    // LAZY = fetch when needed (LAZY LOADING)
    // EAGER = fetch immediately
    @JoinTable(
            name = "televisions_wallBrackets",
            joinColumns = @JoinColumn(name = "wallBrackets_id"),
            inverseJoinColumns = @JoinColumn(name = "television_id")
    )

    private Set<WallBracket> wallBrackets = new HashSet<>();



    //  ALLE GETTERS NU VIA LOMBOK
    //  ALLE SETTERS NU VIA LOMBOK


}