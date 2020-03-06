package day3.Battleships

import scala.Array.ofDim

class Board(xCoords: Int, yCoords: Int) {

  def makeBoard(): Array[Array[Int]] = {
    ofDim[Int](3, 3)
  }

}
