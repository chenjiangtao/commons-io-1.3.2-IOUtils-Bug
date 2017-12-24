import java.io.{File, FileWriter}
import java.nio.charset.StandardCharsets
import java.nio.file.{Files, Paths}

import org.apache.commons.io.IOUtils

import scala.io.Source

object TestIOUtils extends App {
  println("Hello, World!")

  val filePath = "dir"
  val source_file_b64 = "dir/mycat.jpg.b64"
//    val source_file_b64 = "dir/mystring"

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
    val fp = filePath + File.separator + fileName
    IOUtils.write(value, new FileWriter(fp))
    var tmp = fileReader(fp)
    printf("file[%.10s],length:%10d\n", source_file_b64, value.length)
    printf("file[%.10s],length:%10d\n", fp, tmp.length)
    //    assert(tmp.length == value.length)

    value.length + ""
  }

  /**
    *
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

    val fp = filePath + File.separator + fileName
    Files.write(Paths.get(fp), value.getBytes(StandardCharsets.UTF_8))
    var tmp = fileReader(fp)

    printf("file[%.10s],length:%10d\n", source_file_b64, value.length)
    printf("file[%.10s],length:%10d\n", fp, tmp.length)
    //    assert(tmp.length == value.length)
  }

  //   IOUtils test
  writeFile1(fileReader(source_file_b64), "")
  //Files.write test
  writeFile(fileReader(source_file_b64), "")

}