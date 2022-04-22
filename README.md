# uuid-benchmarks
This is a benchmark to compare UUID generators, trying to replicate the experiment in [this post](https://johannburkard.de/blog/programming/java/Java-UUID-generators-compared.html) by Johann Burkard.

Only UUID versions 1 and 4 are tested: version 3 and 5 are name-based; version 2 (DCE security) is not implemented in many libraries. It would be nice to test other implementations also [Apache Commons Id](https://commons.apache.org/sandbox/commons-id/).

## Test results
UUIDBenchmark is the benchmark for object generation, while UUIDToStringBenchmark is for string generation. Lower score is better (microseconds for each operation).

###Eclipse Temurin 11.0.4
| Benchmark                            | Mode | Cnt | Score | Error  | Units |
|--------------------------------------|------|-----|-------|--------|-------|
| UUIDBenchmark.testEAIOv1             | avgt | 16  | 0,020 | ±0,002 | us/op |
| UUIDBenchmark.testJUGv1              | avgt | 16  | 0,101 | ±0,001 | us/op |
| UUIDBenchmark.testJDKv4              | avgt | 16  | 0,501 | ±0,040 | us/op |
| UUIDBenchmark.testRiverv4            | avgt | 16  | 1,838 | ±0,137 | us/op |
| UUIDToStringBenchmark.testEAIOtoJava | avgt | 16  | 0,031 | ±0,002 | us/op |
| UUIDToStringBenchmark.testJUGv1      | avgt | 16  | 0,101 | ±0,001 | us/op |
| UUIDToStringBenchmark.testEAIOv1     | avgt | 16  | 0,169 | ±0,011 | us/op |
| UUIDToStringBenchmark.testJDKv4      | avgt | 16  | 0,462 | ±0,043 | us/op |
| UUIDToStringBenchmark.testRiverv4    | avgt | 16  | 2,069 | ±0,152 | us/op |