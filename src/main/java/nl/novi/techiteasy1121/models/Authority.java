package nl.novi.techiteasy1121.models;

// OOK WEL ROLES!!!


import jakarta.persistence.*;
import java.io.Serializable;

/*TODO annotatie*/
@IdClass(AuthorityKey.class)
@Table(name = "authorities")
public class Authority implements Serializable {

    @Id
    @Column(nullable = false)
    private String username;

    @Id
    @Column(nullable = false)
    private String authority;

    // DEZE ZORGT VOOR DE MANY-TO-MANY RELATIE EN LEGT DE VERBINDING TUSSEN USER EN AUTHORITY

    public Authority() {}
    public Authority(String username, String authority) {
        this.username = username;
        this.authority = authority;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getAuthority() {
        return authority;
    }
    public void setAuthority(String authority) {
        this.authority = authority;
    }

}