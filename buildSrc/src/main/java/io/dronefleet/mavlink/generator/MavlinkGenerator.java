package io.dronefleet.mavlink.generator;

import com.squareup.javapoet.JavaFile;

import java.util.List;
import java.util.stream.Collectors;

public class MavlinkGenerator {
    private final List<PackageGenerator> packages;

    MavlinkGenerator(List<PackageGenerator> packages) {
        this.packages = packages;
    }

    public List<JavaFile> generate() {
        return packages.stream()
                .map(PackageGenerator::generate)
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }
}
