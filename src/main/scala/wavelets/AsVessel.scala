package wavelets

import basic.Basic._

import scala.math._

class AsVessel(d: T = 3, a: T) extends ACBoundedWavelet(d, a) {
  override val wavename = "AsVessel"

  override def psi(x: T): T = exp(-0.5 * sqr(x))
}