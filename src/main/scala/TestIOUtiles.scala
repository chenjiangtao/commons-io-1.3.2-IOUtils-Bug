import java.io.{File, FileWriter}
import java.nio.charset.StandardCharsets
import java.nio.file.{Files, Paths}

import org.apache.commons.io.IOUtils

import scala.io.Source

object TestIOUtils extends App {
  println("Hello, World!")

  val filePath = "dir"
  val source_file_b64 = "dir/ffb5c2aea04c4f208018eb81f891b6dc"
  //  val source_file_b64 = "dir/mystring"

  /**
    * file reader
    *
    * @param file
    * @return
    */
  def fileReader(file: String): String = {
    var imgB64 = ""
    for (line <- Source.fromFile(file).getLines) {
      println(line)
      imgB64 = line
    }
    imgB64
  }

  /**
    * IOUtils test
    * write to data file
    *
    * @param value
    * @return
    */
  def writeFile1(value: String, fileType: String): String = {
    val fileName = "test_by_ioutils"
    val pathData = new File(filePath)
    if (!pathData.exists()) {
      pathData.mkdirs()
    }
    IOUtils.write(value, new FileWriter(filePath + File.separator + fileName))
    var tmp = fileReader(filePath + File.separator + fileName)
    println("source file length :" + value.length)
    println("save file length   :" + tmp.length)
    //    assert(tmp.length == value.length)

    value.length + ""
  }

  /**
    * Files.write test
    * write to data file
    *
    * @param value
    * @return
    */
  def writeFile(value: String, fileType: String) = {
    val fileName = "test_by_files"
    val pathData = new File(filePath)
    if (!pathData.exists()) {
      pathData.mkdirs()
    }
    Files.write(Paths.get(filePath + File.separator + fileName), value.getBytes(StandardCharsets.UTF_8))

    var tmp = fileReader(filePath + File.separator + fileName)
    println("source file length :" + value.length)
    println("save file length   :" + tmp.length)
    //    assert(tmp.length == value.length)
  }

  writeFile1(fileReader(source_file_b64), "")

  writeFile(fileReader(source_file_b64), "")

}