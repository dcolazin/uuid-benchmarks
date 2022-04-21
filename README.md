# uuid-benchmarks
This is a benchmark to compare UUID generators, trying to replicate the experiment in [this post](https://johannburkard.de/blog/programming/java/Java-UUID-generators-compared.html) by Johann Burkard.

UUID version 3 and 5 are name-based and not tested; also version 2 (DCE security) is not implemented in the tested implementations. It would be nice to test other implementations, like [Apache River](https://river.apache.org/), [Apache Commons Id](https://commons.apache.org/sandbox/commons-id/) and newer ones in the [Maven Central](https://search.maven.org).

### Test results
| Benchmark                            | Mode  | Cnt  | Score | Error | Units |
|--------------------------------------|-------|------|-------|-------|-------|
| UUIDBenchmark.testJDKv4              | avgt |  16  | 0,444 | ±0,014 | us/op |
| UUIDBenchmark.testJUGv1              | avgt |  16  | 0,101 | ±0,001 | us/op |
| UUIDBenchmark.testEAIOv1             | avgt |  16  | 0,022 | ±0,008 | us/op |
| UUIDToStringBenchmark.testJDKv4      | avgt |  16  | 0,505 | ±0,115 | us/op |
| UUIDToStringBenchmark.testJUGv1      | avgt |  16  | 0,101 | ±0,001 | us/op |
| UUIDToStringBenchmark.testEAIOv1     | avgt |  16  | 0,149 | ±0,007 | us/op |
| UUIDToStringBenchmark.testEAIOtoJava | avgt |  16  | 0,029 | ±0,001 | us/op |