package com.github.cchacin;

import java.util.UUID;
import net.jini.id.UuidFactory;
import org.openjdk.jmh.annotations.Benchmark;

public class UUIDToStringBenchmark extends CommonBenchmark {

    @Benchmark
    public String testJDKv4() {
        return UUID.randomUUID().toString();
    }

    @Benchmark
    public String testJUGv1() {
        return this.timeBasedGenerator.generate().toString();
    }

    @Benchmark
    public String testEAIOv1() {
        return new com.eaio.uuid.UUID().toString();
    }

    @Benchmark
    public String testEAIOtoJava() {
        com.eaio.uuid.UUID uuid = new com.eaio.uuid.UUID();
        return new UUID(uuid.time, uuid.clockSeqAndNode).toString();
    }

    @Benchmark
    public String testRiverv4() {
        return UuidFactory.generate().toString();
    }

    @Benchmark
    public String testCommonsv1() {
        return versionOneGenerator.nextUUID().toString();
    }

    @Benchmark
    public String testCommonsv4() {
        return versionFourGenerator.nextUUID().toString();
    }
}
