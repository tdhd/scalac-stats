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
    def rec(tail: Seq[Tree], allChildren: Seq[Tree]): Seq[Tree] = tail match {
      case Nil ⇒ allChildren
      case elem :: elems ⇒ rec(elem.children ++ elems, Seq(elem) ++ allChildren)
    }

    rec(Seq(t), Seq.empty)
  }

  private def score(f: Tree, s: Tree): Double = {
    val firstNodes = allNodes(f) diff Seq(f)
    val secondNodes = allNodes(s) diff Seq(s)

    if (f.shortClass != s.shortClass) 0.0
    else if (f.shortClass == s.shortClass && firstNodes.isEmpty && secondNodes.isEmpty) 1.0
    else {
      val products = for {
        j ← 0 until scala.math.min(firstNodes.size, secondNodes.size)
      } yield 1 + score(firstNodes(j), secondNodes(j))
      products.product
    }
  }

  def similarity: Double = {
    val firstVertices = allNodes(first)
    val secondVertices = allNodes(second)

    val scores = for {
      v1 ← firstVertices
      v2 ← secondVertices
    } yield score(v1, v2)

    scores.sum
  }
}


