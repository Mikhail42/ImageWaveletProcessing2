package wavelets
import basic.Basic._

import scala.math._

class AsLongVessel(d: T = 4, a: T) extends ACBoundedWavelet(d, a) {
  override val wavename = "AsLongVessel"
  override def psi(x: T): T = (d-abs(x))*exp(-sqr(x))
}