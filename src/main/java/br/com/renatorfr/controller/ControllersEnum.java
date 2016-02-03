package br.com.renatorfr.controller;

public enum ControllersEnum {
    TRAINING_CONTROLLER(TrainingController.class);

    private final Class clazz;

    ControllersEnum(Class clazz) {
        this.clazz = clazz;
    }

    public Class getClazz() {
        return clazz;
    }
}
