# uuid-benchmarks
This is a benchmark to compare UUID generators, trying to replicate the experiment in [this post](https://johannburkard.de/blog/programming/java/Java-UUID-generators-compared.html) by Johann Burkard.

Only UUID versions 1 and 4 are tested: version 3 and 5 are name-based; version 2 (DCE security) is not implemented in many libraries.

## Test results
UUIDBenchmark is the benchmark for object generation, while UUIDToStringBenchmark is for string generation. Lower score is better (microseconds for each operation). For this test I used Eclipse Temurin 11.0.4, but tests with Oracle OpenJDK 17.0.2 are similar.

| Benchmark                            | Mode | Cnt | Score | Error  | Units |
|--------------------------------------|------|-----|-------|--------|-------|
| UUIDBenchmark.testEAIOv1             | avgt | 16  | 0,013 | ±0,001 | us/op |
| UUIDBenchmark.testCommonsv4          | avgt | 16  | 0,042 | ±0,001 | us/op |
| UUIDBenchmark.testCommonsv1          | avgt | 16  | 0,052 | ±0,001 | us/op |
| UUIDBenchmark.testJUGv1              | avgt | 16  | 0,101 | ±0,001 | us/op |
| UUIDBenchmark.testJDKv4              | avgt | 16  | 0,363 | ±0,023 | us/op |
| UUIDBenchmark.testRiverv4            | avgt | 16  | 1,446 | ±0,044 | us/op |
| UUIDToStringBenchmark.testEAIOtoJava | avgt | 16  | 0,023 | ±0,001 | us/op |
| UUIDToStringBenchmark.testJUGv1      | avgt | 16  | 0,101 | ±0,001 | us/op |
| UUIDToStringBenchmark.testCommonsv1  | avgt | 16  | 0,109 | ±0,001 | us/op |
| UUIDToStringBenchmark.testCommonsv4  | avgt | 16  | 0,115 | ±0,002 | us/op |
| UUIDToStringBenchmark.testEAIOv1     | avgt | 16  | 0,122 | ±0,002 | us/op |
| UUIDToStringBenchmark.testJDKv4      | avgt | 16  | 0,370 | ±0,008 | us/op |
| UUIDToStringBenchmark.testRiverv4    | avgt | 16  | 1,604 | ±0,029 | us/op |