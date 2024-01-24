package nl.novi.techiteasy1121.models;

// SERIAL IZABLE ZORGT ERVOOR DAT ER AUTOMATISCH EEN NUMMERTJE GEGEVEN WORDT
// AUTHORITY OOK WEL ROLES
// DE TUSSENTABEL OM DE AUTHORITY AAN DE USER TE KOPPELEN

import java.io.Serializable;

public class AuthorityKey implements Serializable {
    private String username;
    private String authority;
}