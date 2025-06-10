package no.fint.event.util;

import java.util.regex.Pattern;

public final class ODataQueryFilter {
    private ODataQueryFilter() {}

    private static final Pattern ODATA_FILTER =
            Pattern.compile("(\\$filter=)[^&]*", Pattern.CASE_INSENSITIVE);

    public static String maskFilter(String q) {
        if (q == null) return null;
        return ODATA_FILTER.matcher(q).replaceAll("$1***");
    }
}
