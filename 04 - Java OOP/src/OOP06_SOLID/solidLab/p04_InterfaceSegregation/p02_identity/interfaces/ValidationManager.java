package OOP06_SOLID.solidLab.p04_InterfaceSegregation.p02_identity.interfaces;

public interface ValidationManager {
    boolean getRequireUniqueEmail();

    int getMinRequiredPasswordLength();

    int getMaxRequiredPasswordLength();

}
