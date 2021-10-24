package wavelets

import basic.Basic._

import scala.math._

class Gauss extends ICWavelet {
  override val wavename = "Gauss"
  /** wavelet for blood vessel  */
  override def psi(x: T, y: T): T = 
    exp(-0.5*norm2(x, y))
}