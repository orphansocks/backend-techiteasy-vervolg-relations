package nl.novi.techiteasy1121.dtos.wallbracket;

public class WallBracketDto {

    // DE VARIABELEN
    // PRIVATE WANT IN CONTACT MET DATABASE INFORMATIE VIA DE SERVICELAAG

    private Long id;
    private String size;
    private Boolean adjustable;
    private String name;
    private Double price;

    // GETTERS AND SETTERS

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Boolean getAdjustable() {
        return adjustable;
    }

    public void setAdjustable(Boolean adjustable) {
        this.adjustable = adjustable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
