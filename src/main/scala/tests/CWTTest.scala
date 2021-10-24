package tests

import org.junit.runner.RunWith
import org.scalatestplus.junit.JUnitRunner
      
@RunWith(classOf[JUnitRunner])
object CWTTest {

  val dir = "/home/misha/"
      
  def cwtTests(): Unit = {
    import wavelets._
    val filename = dir + "01_dr.jpg"
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