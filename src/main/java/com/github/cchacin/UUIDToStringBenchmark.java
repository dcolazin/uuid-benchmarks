package com.github.cchacin;

import static com.github.cchacin.BenchmarkConfiguration.ITERATIONS;
import static com.github.cchacin.BenchmarkConfiguration.TEST_TIME;

import com.fasterxml.uuid.EthernetAddress;
import com.fasterxml.uuid.Generators;
import com.fasterxml.uuid.impl.TimeBasedGenerator;
import org.openjdk.jmh.annotations.*;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Warmup(iterations = ITERATIONS, time = TEST_TIME, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = ITERATIONS, time = TEST_TIME, timeUnit = TimeUnit.MILLISECONDS)
@Fork(1)
@State(Scope.Benchmark)
public class UUIDToStringBenchmark {
    private TimeBasedGenerator timeBasedGenerator;

    @Setup
    public void setup() {
        this.timeBasedGenerator = Generators.timeBasedGenerator(EthernetAddress.fromInterface());
    }

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
}
