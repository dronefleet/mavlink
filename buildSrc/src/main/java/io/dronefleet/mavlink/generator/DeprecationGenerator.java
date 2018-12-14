package io.dronefleet.mavlink.generator;

import com.squareup.javapoet.AnnotationSpec;

public class DeprecationGenerator {
    private final boolean deprecated;
    private final String since;
    private final String replacedBy;
    private final String message;

    public DeprecationGenerator(boolean deprecated, String since, String replacedBy, String message) {
        this.deprecated = deprecated;
        this.since = since;
        this.replacedBy = replacedBy;
        this.message = message;
    }

    public boolean deprecated() {
        return deprecated;
    }

    public AnnotationSpec annotation() {
        return AnnotationSpec.builder(Deprecated.class).build();
    }

    public String javadoc() {
        return "@deprecated Since " + since + ", replaced by " + replacedBy + ". "
                + (message != null ? message : "");
    }
}
