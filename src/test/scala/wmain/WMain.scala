package wmain

object WMain extends App {
  //val res = preprocessing.DilateErose.dilateErose(image.Input.getImage("./src/main/resources/6-1-5.jpg"))
  //image.Output.visible(res, "tit")
  util.Time.measure("vesselSegmentTest") {
    tests.AnalysTest.vesselSegmentTest()
  }
}