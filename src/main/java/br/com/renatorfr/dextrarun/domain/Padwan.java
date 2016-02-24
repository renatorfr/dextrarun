package br.com.renatorfr.dextrarun.domain;

public class Padwan extends User {
    private Padwan() {
        super();
    }

    public Padwan(String name) {
        super(name, UserType.PADWAN);
    }

    public Padwan(Long id, String name) {
        super(id, name, UserType.PADWAN);
    }
}
