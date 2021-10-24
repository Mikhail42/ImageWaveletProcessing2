package tests

import basic.Basic._
import image._
import org.junit.runner.RunWith
import org.scalatestplus.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
object ImageTest {
  // basic directory of images
  val dir = "./src/main/resources/"

  /** test on the allocation of the field direction */
  def directionTest(): Unit = {
    val name = dir + "126.jpg"
    val img = Input.getImage(name)
    val direct: BI = Analys.direction(img)
    Output.saveImage(direct, s"${name}_field_out.jpg", Input.format)
  }

  /** test load, scale and visible .tif image */
  def imageTifTest(): Unit = {
    val name = dir + "manual1/01_g.tif"
    val img: BI = Input.getTifImage(name)
    val resImg = Operation.scale(img, 1000.0 / img.getWidth)
    Output.visible(resImg, "Test load a tif image")
  }

  /** compare two gray images. 2th image is ideal, 1th -- is my result */
  def compareTest(): Unit = {
    val imgWT = Input.getImage(dir + "02_dr_out.jpg")
    val resWt = Operation.toBinary(imgWT)

    val imgTif: BI = Input.getTifImage(dir + "manual1/02_dr.tif")

    val resCompare = Analys.compareBinaryImages(resWt, imgTif)
    println(s"Compare Image Test: result = $resCompare")
  }

  /** img <- img & mask */
  def maskTest(): Unit = {
    val inpName = dir + "images/01_g.jpg"
    val img = Input.getImage(inpName)

    val inpNameMask = dir + "mask/01_g_mask.jpg"
    val tif: BI = Input.getImage(inpNameMask)
    val tifScala: BI = Operation.scale(tif, 600.0 / tif.getWidth)
    Output.saveImage(tifScala, dir + "01_g_mask.jpg", "jpg")
    val mask = Input.getImage(inpNameMask)

    val colComps = Input.getColorsComponents(img, 0.0, 0.3, 0.7).map(_.map(255 - _))
    for (i <- 0 until mask.getHeight; j <- 0 until mask.getWidth)
      colComps(i)(j) = colComps(i)(j) & mask.getRGB(j, i)
    val greenImg = Operation.toImage(colComps)
    preprocessing.Filtr.constrast(greenImg)
    val resImg = Operation.scale(greenImg, 600.0 / greenImg.getWidth)
    Output.saveImage(resImg, dir + "01_g.jpg", "jpg")
    Output.visible(resImg, "Mask Test")
  }
}