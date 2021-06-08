package bench
import java.util.concurrent.TimeUnit
import org.openjdk.jmh.annotations._
import org.graalvm.polyglot.*

@State(Scope.Benchmark)
@BenchmarkMode(Array(Mode.Throughput))
@Fork(1)
@Threads(1)
@Warmup(iterations = 10, time = 5, timeUnit = TimeUnit.SECONDS, batchSize = 1)
@Measurement(
  iterations = 10,
  time = 15,
  timeUnit = TimeUnit.SECONDS,
  batchSize = 1
)
class PolyCtxBench {

  @Benchmark
  def wellHelloThere(): Unit = {
    val polyCtx = Context
      .newBuilder()
      .allowAllAccess(true)
      .option("engine.Mode", "throughput")
      .build()
    val jsSource = Source
      .newBuilder(
        "js",
        "Math.random()",
        "dummymodule"
      )
      .build()
    polyCtx.eval("js", "")
    polyCtx.eval(jsSource)
    ()
  }

}
