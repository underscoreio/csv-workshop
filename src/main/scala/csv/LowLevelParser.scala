package csv

import java.io.{Reader, InputStreamReader, StringReader}

object LowLevelParser extends LowLevelParser

trait LowLevelParser {
  /**
   * Return the contents of a resource on the classpath as a `List[List[String]]`.
   * Use this to open the files in `src/main/resources` as follows:
   *
   * ```
   * parseCsvResource("test.csv")
   * ```
   */
  def parseCsvResource(name: String): List[List[String]] = {
    val reader = new InputStreamReader(getClass.getResourceAsStream(prefixWithSlash(name)))
    try parseCsvReader(reader).toList finally reader.close()
  }

  /**
   * Return the contents of `string` as a `List[List[String]]`.
   * Use this to parse a string as CSV:
   *
   * ```
   * parseCsvString("A,B,C\nD,E,F\nG,H,I")
   * ```
   */
  def parseCsvString(string: String): List[List[String]] =
    parseCsvReader(new StringReader(string))

  /**
   * Return the contents of `reader` as a `List[List[String]]`.
   * Close `reader` afterwards.
   */
  private def parseCsvReader(reader: Reader): List[List[String]] = {
    import com.bizo.mighty.csv.{CSVReader => MightyCsvReader}
    import au.com.bytecode.opencsv.{CSVReader => OpenCsvReader}
    MightyCsvReader(new OpenCsvReader(reader)).map(_.toList).toList
  }

  /**
   * Prefix `string` with a slash.
   * Use to ensure resource paths are absolute.
   */
  private def prefixWithSlash(string: String): String =
    if(string.length == 0 || string(0) != '/') s"/$string" else string
}
