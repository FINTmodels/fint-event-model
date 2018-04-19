package no.fint.event.model;

import lombok.Data;

@Data
public class Problem {
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
