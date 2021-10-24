package tests

object CWTTest extends App {

  val dir = "./src/main/resources/"
  cwtTests()

  def cwtTests(): Unit = {
    import wavelets._
    val filename = dir + "images/01_dr.JPG"
    val img = image.Input.getImage(filename)
    for (id <- 1 to 1; a <- 0.4 to 3 by 0.4) {
      def cwt(wave: ICWavelet) =
        image.Transform.cwt(wave, a, id, img)

      cwt(new AsLongVessel(3, a))
      cwt(new Morlet(3, a))
      cwt(new Gauss)
      //cwt(new AsVessel(3, a))
      cwt(new MHAT(3, a))
      //cwt(new FHAT(3, a))
      //cwt(new Gabor)
    }
  }
}