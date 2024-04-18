package no.fintlabs.event.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Problem implements Serializable {
    private static final long serialVersionUID = -8067829906715894759L;
    /**
     * The name of the field the problem relates to.  Either a simple name or a JSON Path to the field.
     */
    private String field;
    /**
     * Human understandable message describing the problem.
     */
    private String message;
    /**
     * Machine traceable error code indicating the type of problem.
     */
    private String code;
}
