package io.dronefleet.mavlink.generator.plugin;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

public class MavlinkGeneratorPlugin implements Plugin<Project> {
    @Override
    public void apply(Project project) {
        project.getTasks().create(
                "generateDialect",
                MavlinkGeneratorTask.class);

        project.getTasks()
                .getByName("compileJava")
                .dependsOn("generateDialect");
    }
}
