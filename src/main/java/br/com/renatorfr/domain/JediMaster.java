package br.com.renatorfr.domain;

public class JediMaster extends User {
    public JediMaster(String name) {
        super(name, UserType.JEDI_MASTER);
    }

    public JediMaster(Long id, String name) {
        super(id, name, UserType.JEDI_MASTER);
    }
}
