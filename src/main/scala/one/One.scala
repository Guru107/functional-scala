package functional.snippets
package one

import scala.annotation.tailrec

object One:
  /**
   * A function suffixes of type α list → α list list
   * that takes a list xs and returns a list of all the suffixes of xs in decreasing order of length.
   * For example, suffixes [1,2,3,4] = [ [1,2,3,4], [2,3,4], [3,4], [4], [] ]
   *
   * @see Okasaki, Chris. Purely Functional Data Structures (p. 22). Cambridge University Press. Kindle Edition.
   * @param lst List[Int]
   * @return List[ List[Int] ]
   */
  def suffixes(lst: List[Int]): List[List[Int]] =
    @tailrec
    def loop(tail: List[Int], accumulator: List[List[Int]]): List[List[Int]] =
      tail match {
        case head :: tl => loop(tl, accumulator :+ tail)
        case Nil => accumulator :+ List.empty[Int]
      }

    loop(lst, List.empty[List[Int]])
