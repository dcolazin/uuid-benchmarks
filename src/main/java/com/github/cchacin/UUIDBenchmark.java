package com.github.cchacin;

import java.util.UUID;
import net.jini.id.Uuid;
import net.jini.id.UuidFactory;
import org.openjdk.jmh.annotations.Benchmark;

public class UUIDBenchmark extends CommonBenchmark {

    @Benchmark
    public UUID testJDKv4() {
        return UUID.randomUUID();
    }

    @Benchmark
    public UUID testJUGv1() {
        return this.timeBasedGenerator.generate();
    }

    @Benchmark
    public com.eaio.uuid.UUID testEAIOv1() {
        return new com.eaio.uuid.UUID();
    }

    @Benchmark
    public Uuid testRiverv4() {
        return UuidFactory.generate();
    }

    @Benchmark
    public org.apache.commons.id.uuid.UUID testCommonsv1() {
        return versionOneGenerator.nextUUID();
    }

    @Benchmark
    public org.apache.commons.id.uuid.UUID testCommonsv4() {
        return versionFourGenerator.nextUUID();
    }
}
