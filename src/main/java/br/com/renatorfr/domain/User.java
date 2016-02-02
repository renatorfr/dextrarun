package br.com.renatorfr.domain;

public class User {
    private final Long id;
    private final String name;
    private final UserType type;

    public User(String name, UserType type) {
        this(null, name, type);
    }

    public User(Long id, String name, UserType type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }
}

enum UserType {
    JEDI_MASTER("J"), PADWAN("P");

    private final String type;

    UserType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
