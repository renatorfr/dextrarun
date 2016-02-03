package br.com.renatorfr.domain;

public class Padwan extends User {
    public Padwan(String name) {
        super(name, UserType.PADWAN);
    }

    public Padwan(Long id, String name) {
        super(id, name, UserType.PADWAN);
    }
}
