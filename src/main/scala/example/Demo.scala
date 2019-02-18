package example


import picocli.CommandLine
import picocli.CommandLine.{Option, Command}

@Command(name = "Demo", version = Array("Scala picocli v3.0 demo"),
  mixinStandardHelpOptions = true, // add --help and --version options
  description = Array("@|bold Scala|@ @|underline picocli|@ example"))
class Demo extends Runnable {

  @Option(names = Array("-c", "--count"),
    description = Array("number of repetitions"))
  private var count: Int = 1

  def run() : Unit = {
    for (i <- 0 until count) {
      println(s"hello world $i...")
    }
  }
}
object Demo {
  def main(args: Array[String]) {
    CommandLine.run(new Demo(), args: _*)
  }
}
