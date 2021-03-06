package br.com.renatorfr.dextrarun.domain;

public class JediMaster extends User {
    private JediMaster() {
        super();
    }

    public JediMaster(String name) {
        super(name, UserType.JEDI_MASTER);
    }

    public JediMaster(Long id, String name) {
        super(id, name, UserType.JEDI_MASTER);
    }
}
