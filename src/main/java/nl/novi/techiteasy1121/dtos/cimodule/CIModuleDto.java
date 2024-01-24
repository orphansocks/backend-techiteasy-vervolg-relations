package nl.novi.techiteasy1121.dtos.cimodule;

public class CIModuleDto {

    // BIJ DE INPUTDTO GEEN ID BIJ DE VARIABELEN WANT DIE GEEF JE NIET MEE ALS JE CREATE
    // DE ID WORDT LATER TOEGEVOEGD
    // DE VARIABELEN IN DE (OUTPUT) DTO MAAK IK PRIVATE
    // ID BLIJFT PRIVATE??

    private Long id;
    private String name;
    private String type;
    private Double price;

    public CIModuleDto() {
    }

    public CIModuleDto(Long id, String name, String type, Double price) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
    }

    // GETTERS AND SETTERS


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
