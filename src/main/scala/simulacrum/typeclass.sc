import simulacrum._

@simulacrum.typeclass trait CanTruthy[A] { self =>
  /** Return true, if `a` is truthy. */
  def truthy(a: A): Boolean
}

object CanTruthy {
  def fromTruthy[A](f: A => Boolean): CanTruthy[A] = new CanTruthy[A] {
    def truthy(a: A): Boolean = f(a)
  }
}