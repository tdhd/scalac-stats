package io.github.tdhd.scalac.plugin

import scala.annotation.tailrec
import scala.tools.nsc.doc.DocParser.Tree

trait BaseKernel {
  def similarity: Double
}


// http://machinelearning.wustl.edu/mlpapers/paper_files/nips02-AA58.pdf
// Convolution Kernels for Natural Language

class ConvTreeKernel(val first: Tree, val second: Tree) extends BaseKernel {

  def allNodes(t: Tree): Seq[Tree] = {

    @tailrec
    def rec(tail: Seq[Tree], accum: Seq[Tree]): Seq[Tree] = tail match {
      case Nil => accum
      case elem :: elems => rec(elems, Seq(elem) ++ accum)
    }

    rec(t.children, Seq.empty)
  }

  private def score(first: Tree, second: Tree): Double = {
    val firstNodes = allNodes(first)
    val secondNodes = allNodes(second)

    if (first.shortClass != second.shortClass) 0.0
    else if (first.shortClass == second.shortClass && firstNodes.isEmpty && secondNodes.isEmpty) 1.0
    else {
      val products = for {
        j <- 0 until scala.math.min(firstNodes.size, secondNodes.size)
      } yield 1 + score(firstNodes(j), secondNodes(j))
      products.product
    }
  }

  def similarity: Double = {
    val firstVertices = allNodes(first)
    val secondVertices = allNodes(second)

    val scores = for {
      v1 <- firstVertices
      v2 <- secondVertices
    } yield score(v1, v2)

    scores.sum
  }
}


