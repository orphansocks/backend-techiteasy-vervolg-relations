package nl.novi.techiteasy1121.dtos.wallbracket;

// BIJ DE INPUTDTO GEEN ID BIJ DE VARIABELEN WANT DIE GEEF JE NIET MEE ALS JE CREATE
// DE ID WORDT LATER TOEGEVOEGD

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class WallBracketInputDto {


    // DE VARIABELEN
    // PRIVATE WANT IN CONTACT MET DATABASE INFORMATIE VIA DE SERVICELAAG
    public String size;
    public Boolean adjustable;
    @NotNull(message = "Name is required")
    public String name;
    @Positive(message = "Price must be higher than zero")
    public Double price;

    // GETTERS AND SETTERS NIET NODIG


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
