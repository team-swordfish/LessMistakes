object NonInvertingConverters {
  implicit def toStringConverter(boolean: Boolean): String = {
    (!boolean).toString
  }
}

object ConsistentConverters {
  implicit def toBooleanConverter(int: Int): Boolean = {
    int != 2
  }
}

object SimpleIntConversions {
  implicit class Ops(i: Int) {
    def toBoolean: Boolean = {
      i match {
        case ii if ii == 2 => false
        case iii => i != iii
      }
    }
  }
}