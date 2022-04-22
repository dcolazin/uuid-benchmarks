package com.github.cchacin;

import static com.github.cchacin.BenchmarkConfiguration.ITERATIONS;
import static com.github.cchacin.BenchmarkConfiguration.TEST_TIME;

import com.fasterxml.uuid.EthernetAddress;
import com.fasterxml.uuid.Generators;
import com.fasterxml.uuid.impl.TimeBasedGenerator;
import net.jini.id.Uuid;
import net.jini.id.UuidFactory;
import org.openjdk.jmh.annotations.*;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Warmup(iterations = ITERATIONS, time = TEST_TIME, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = ITERATIONS, time = TEST_TIME, timeUnit = TimeUnit.MILLISECONDS)
@Fork(1)
@State(Scope.Benchmark)
public class UUIDBenchmark {
    private TimeBasedGenerator timeBasedGenerator;

    @Setup
    public void setup() {
        this.timeBasedGenerator = Generators.timeBasedGenerator(EthernetAddress.fromInterface());
    }

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

}
