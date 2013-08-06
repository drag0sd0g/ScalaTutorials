package code

object FileMatcher {

  private def filesHere = (new java.io.File(".")).listFiles()

  def filesEnding(query: String) =
    filesMatching(query, _.endsWith(_))

  def filesContaining(query: String) =
    filesMatching(query, (fileName, query) => fileName.contains(query))

  def filesRegex(query: String) =
    filesMatching(query, _.matches(_))

  def filesMatching(query: String, matcher : (String, String) => Boolean) =
    for(file <- filesHere; if matcher(file.getName,  query))
      yield file

}
