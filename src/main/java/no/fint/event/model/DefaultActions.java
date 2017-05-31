package no.fint.event.model;

import java.util.Arrays;
import java.util.List;

public enum DefaultActions {
    /**
     * Tells the adapter to check communication with application and that the adapter can perform necessary actions {@link no.fint.event.model.health.Health}
     */
    HEALTH;

    /**
     * Gets a list of all enums as string
     * @return A string list of all enums
     */
    public static List<String> getDefaultActions() {
        return Arrays.asList(
                Arrays.stream(DefaultActions.class.getEnumConstants()).map(Enum::name).toArray(String[]::new)
        );
    }
}
