package com.github.cchacin;

import static com.github.cchacin.BenchmarkConfiguration.ITERATIONS;
import static com.github.cchacin.BenchmarkConfiguration.TEST_TIME;

import com.fasterxml.uuid.EthernetAddress;
import com.fasterxml.uuid.Generators;
import com.fasterxml.uuid.impl.TimeBasedGenerator;
import java.util.concurrent.TimeUnit;
import org.apache.commons.id.uuid.VersionFourGenerator;
import org.apache.commons.id.uuid.VersionOneGenerator;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Warmup(iterations = ITERATIONS, time = TEST_TIME, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = ITERATIONS, time = TEST_TIME, timeUnit = TimeUnit.MILLISECONDS)
@Fork(1)
@State(Scope.Benchmark)
public abstract class CommonBenchmark {

    protected TimeBasedGenerator timeBasedGenerator;
    protected VersionOneGenerator versionOneGenerator;
    protected VersionFourGenerator versionFourGenerator;

    @Setup
    public void setup() {
        System.getProperties().setProperty("org.apache.commons.id.uuid.config.resource.filename", "commons-id-uuid.xml");
        this.timeBasedGenerator = Generators.timeBasedGenerator(EthernetAddress.fromInterface());
        this.versionOneGenerator = VersionOneGenerator.getInstance();
        this.versionFourGenerator = VersionFourGenerator.getInstance();
    }
}
