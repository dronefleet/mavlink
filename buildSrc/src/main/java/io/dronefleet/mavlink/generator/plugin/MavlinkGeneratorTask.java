package io.dronefleet.mavlink.generator.plugin;

import io.dronefleet.mavlink.generator.MavlinkGenerator;
import io.dronefleet.mavlink.generator.MavlinkGeneratorFactory;
import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.InputDirectory;
import org.gradle.api.tasks.OutputDirectory;
import org.gradle.api.tasks.TaskAction;

import javax.xml.stream.XMLStreamException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class MavlinkGeneratorTask extends DefaultTask {

    @InputDirectory
    private File definitions;

    @OutputDirectory
    private File generatedSources;

    public File getDefinitions() {
        return definitions;
    }

    public void setDefinitions(File definitions) {
        this.definitions = definitions;
    }

    public File getGeneratedSources() {
        return generatedSources;
    }

    public void setGeneratedSources(File generatedSources) {
        this.generatedSources = generatedSources;
    }

    @TaskAction
    public void generate() throws FileNotFoundException, XMLStreamException {
        // no need to proceed if definitions is null
        if (definitions == null) return;

        if (!definitions.isDirectory()) throw new IllegalArgumentException(
                "'definitions' should be a directory, but got a file instead.");

        if (generatedSources == null) {
            throw new IllegalStateException("'generatedSources' is not specified.");
        }

        if (generatedSources.exists() && !deleteAll(generatedSources)) {
            throw new IllegalStateException("unable to clean generated sources.");
        }

        if (!generatedSources.mkdirs()) {
            throw new IllegalStateException("unable to create 'generatedSources' directory at " + generatedSources.getAbsolutePath());
        }

        //noinspection ConstantConditions
        MavlinkGeneratorFactory generatorFactory = new MavlinkGeneratorFactory(
                "io.dronefleet.mavlink",
                Arrays.asList(definitions.listFiles()));
        MavlinkGenerator generator = generatorFactory.newGenerator();
        generator.generate().forEach(f -> {
            try {
                f.writeTo(generatedSources);
            } catch (IOException e) {
                throw new IllegalStateException("unable to save generated source", e);
            }
        });
    }

    private boolean deleteAll(File f) {
        if (f.isDirectory()) {
            //noinspection ConstantConditions
            Arrays.stream(f.listFiles()).forEach(this::deleteAll);
        }
        return f.delete();
    }
}
