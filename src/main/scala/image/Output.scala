package image

import basic.Basic._

import java.awt._
import java.awt.image._
import java.io.File
import javax.imageio.ImageIO
import javax.swing._

object Output {

  def saveImage(im: BufferedImage, fileName: String, format: String): Unit =
    ImageIO.write(im, format, new File(fileName))

  def saveImage(mat: MInt, fileName: String, format: String, imgType: Int): Unit = {
    val outImg = Operation.toImage(mat, imgType)
    saveImage(outImg, fileName, format)
  }

  def saveImage(mat: M, fileName: String, format: String, imgType: Int): Unit =
    saveImage(Operation.toColorMInt(mat), fileName, format, imgType)

  /** visualization image through frame */
  def visible(image: BufferedImage, title: String): Unit = {
    val frame = new JFrame()
    val icon = new ImageIcon(image)
    val label = new JLabel(icon)
    frame.getContentPane().add(label, BorderLayout.CENTER)
    frame.pack()
    frame.setName(title)
    frame.setTitle(title)
    frame.setVisible(true)
    frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE)
  }

  def visualisationAndSaveMat(mat: M, frameName: String, fileName: String): Unit = {
    val gRes = Operation.toColorMInt(mat)
    val grayImg = Operation.createImage(gRes, Input.imgType)
    Output.visible(grayImg, frameName)
    Output.saveImage(grayImg, fileName, Input.format)
  }
}