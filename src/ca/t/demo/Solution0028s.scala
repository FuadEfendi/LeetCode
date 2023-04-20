package ca.t.demo

object Solution0028s {
  def strStr(haystack: String, needle: String): Int = {
    if (needle == "") {
      0
    } else {
      haystack
        .sliding(needle.length)
        .zipWithIndex
        .collectFirst({ case (`needle`, y) => y })
        .getOrElse(-1)
    }
  }
  def strStr2(haystack: String, needle: String): Int = {
    haystack.indexOf(needle)
  }
}
