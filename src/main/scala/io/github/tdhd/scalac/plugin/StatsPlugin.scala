package io.github.tdhd.scalac.plugin

import scala.tools.nsc.plugins.{Plugin, PluginComponent}
import scala.tools.nsc.{Global, Phase}

//            tree match {
//            //            case element: Tree =>
//            //              println(s"Tree: $element")
//            //              super.traverse(tree)
//            //            case element: TermTree =>
//            //              println(s"TermTree: $element")
//            //              super.traverse(tree)
//            //            case element: TypTree =>
//            //              //println(s"$element")
//            //              super.traverse(tree)
//            //            case element: SymTree =>
//            //              //println(s"$element")
//            //              super.traverse(tree)
//            //            case element: NameTree =>
//            //              //println(s"$element")
//            //              super.traverse(tree)
//            //            case element: RefTree =>
//            //              //println(s"$element")
//            //              super.traverse(tree)
//            //            case element: DefTree =>
//            //              //println(s"$element")
//            //              super.traverse(tree)
//            //            case element: MemberDef =>
//            //              //println(s"$element")
//            //              super.traverse(tree)
//            case element: PackageDef =>
//              //println(s"$element")
//              super.traverse(tree)
//            //            case element: ImplDef =>
//            //              //println(s"$element")
//            //              super.traverse(tree)
//            case element: ClassDef =>
//              //println(s"$element")
//              super.traverse(tree)
//            case element: ModuleDef =>
//              //println(s"$element")
//              super.traverse(tree)
//            //            case element: ValOrdefdef =>
//            //              //println(s"$element")
//            //              super.traverse(tree)
//            case element: ValDef =>
//              //println(s"$element")
//              super.traverse(tree)
//            case element: DefDef =>
//              println(s"def def: ${element.shortClass}")
//              //              println("YAY")
//              //              println(map(DefDef))
//              //              println(s"$element")
//              //              method(element)
//              super.traverse(tree)
//            case element: TypeDef =>
//              //println(s"$element")
//              super.traverse(tree)
//            case element: LabelDef =>
//              //println(s"$element")
//              super.traverse(tree)
//            //            case element: ImportSelector =>
//            //              //println(s"$element")
//            //              super.traverse(tree)
//            case element: Import =>
//              //println(s"$element")
//              super.traverse(tree)
//            case element: Template =>
//              //println(s"$element")
//              super.traverse(tree)
//            case element: Block =>
//              //println(s"$element")
//              super.traverse(tree)
//            case element: CaseDef =>
//              //println(s"$element")
//              super.traverse(tree)
//            case element: Alternative =>
//              //println(s"$element")
//              super.traverse(tree)
//            case element: Star =>
//              //println(s"$element")
//              super.traverse(tree)
//            case element: Bind =>
//              //println(s"$element")
//              super.traverse(tree)
//            case element: UnApply =>
//              //println(s"$element")
//              super.traverse(tree)
//            case element: Function =>
//              //println(s"$element")
//              super.traverse(tree)
//            case element: Assign =>
//              //println(s"$element")
//              super.traverse(tree)
//            case element: AssignOrNamedArg =>
//              //println(s"$element")
//              super.traverse(tree)
//            case element: If =>
//              //              println(s"$element")
//              super.traverse(tree)
//            case element: Match =>
//              //println(s"$element")
//              super.traverse(tree)
//            case element: Return =>
//              //println(s"$element")
//              super.traverse(tree)
//            case element: Try =>
//              //println(s"$element")
//              super.traverse(tree)
//            case element: Throw =>
//              //println(s"$element")
//              super.traverse(tree)
//            case element: New =>
//              //println(s"$element")
//              super.traverse(tree)
//            case element: Typed =>
//              //println(s"$element")
//              super.traverse(tree)
//            //            case element: GenericApply =>
//            //              //println(s"$element")
//            //              super.traverse(tree)
//            case element: TypeApply =>
//              //element.getClass
//              //println(s"$element")
//              super.traverse(tree)
//            case element: Apply =>
//              //println(s"$element")
//              super.traverse(tree)
//            case element: Super =>
//              //println(s"$element")
//              super.traverse(tree)
//            case element: This =>
//              //println(s"$element")
//              super.traverse(tree)
//            case element: Select =>
//              //println(s"$element")
//              super.traverse(tree)
//            case element: Ident =>
//              //println(s"$element")
//              super.traverse(tree)
//            case element: Literal =>
//              //println(s"$element")
//              super.traverse(tree)
//            case element: Annotated =>
//              //println(s"$element")
//              super.traverse(tree)
//            case element: SingletonTypeTree =>
//              //println(s"$element")
//              super.traverse(tree)
//            case element: SelectFromTypeTree =>
//              //println(s"$element")
//              super.traverse(tree)
//            case element: CompoundTypeTree =>
//              //println(s"$element")
//              super.traverse(tree)
//            case element: AppliedTypeTree =>
//              //println(s"$element")
//              super.traverse(tree)
//            case element: TypeBoundsTree =>
//              //println(s"$element")
//              super.traverse(tree)
//            case element: ExistentialTypeTree =>
//              //println(s"$element")
//              super.traverse(tree)
//            case element: TypeTree =>
//              //println(s"$element")
//              super.traverse(tree)
//            case element: TreeCopier =>
//              //println(s"$element")
//              super.traverse(tree)
//            //            case element: Modifiers =>
//            //              //println(s"$element")
//            //              super.traverse(tree)
//            //            case element: ModifiersCreator =>
//            //              //println(s"$element")
//            //              super.traverse(tree)
//            case generic =>
//              println(generic.isTerm)
//              println(generic.isDef)
//              generic.isType
//              println(s"$generic")
//              println("-" * 20)
//              super.traverse(tree)
//            //            case LabelDef(name, _,
//            //              If(
//            //                Literal(Constant(true)),
//            //                ifBody,
//            //                _
//            //              )
//            //            ) =>
//            // this is a while(true) loop
//            //              val gotoLine = appendLine("REM")
//            //              super.traverse(ifBody)
//            //              appendLine(s"GOTO $gotoLine")
//            //            case Apply(
//            //              Select(Select(This(TypeName("scala")), TermName("Predef")), TermName("println")),
//            //              List(Literal(Constant(message)))
//            //            ) => appendLine(s"""PRINT "$message"""")
//            //            case _ => super.traverse(tree)
//          }
// case element: Tree =>
// case element: TermTree =>
// case element: TypTree =>
// case element: SymTree =>
// case element: NameTree =>
// case element: RefTree =>
// case element: DefTree =>
// case element: MemberDef =>
// case element: PackageDef =>
// case element: ImplDef =>
// case element: ClassDef =>
// case element: ModuleDef =>
// case element: ValOrDefDef =>
// case element: ValDef =>
// case element: DefDef =>
// case element: TypeDef =>
// case element: LabelDef =>
// case element: ImportSelector =>
// case element: Import =>
// case element: Template =>
// case element: Block =>
// case element: CaseDef =>
// case element: Alternative =>
// case element: Star =>
// case element: Bind =>
// case element: UnApply =>
// case element: Function =>
// case element: Assign =>
// case element: AssignOrNamedArg =>
// case element: If =>
// case element: Match =>
// case element: Return =>
// case element: Try =>
// case element: Throw =>
// case element: New =>
// case element: Typed =>
// case element: GenericApply =>
// case element: TypeApply =>
// case element: Apply =>
// case element: Super =>
// case element: This =>
// case element: Select =>
// case element: Ident =>
// case element: Literal =>
// case element: Annotated =>
// case element: SingletonTypeTree =>
// case element: SelectFromTypeTree =>
// case element: CompoundTypeTree =>
// case element: AppliedTypeTree =>
// case element: TypeBoundsTree =>
// case element: ExistentialTypeTree =>
// case element: TypeTree =>
// case element: TreeCopier =>
// case element: Modifiers =>
// case element: ModifiersCreator =>


//$ scalac -Xshow-phases
//phase name  id  description
//----------  --  -----------
//parser   1  parse source into ASTs, perform simple desugaring
//namer   2  resolve names, attach symbols to named trees
//packageobjects   3  load package objects
//typer   4  the meat and potatoes: type the trees
//superaccessors   5  add super accessors in traits and nested classes
//pickler   6  serialize symbol tables
//refchecks   7  reference/override checking, translate nested objects
//liftcode   8  reify trees
//uncurry   9  uncurry, translate function values to anonymous classes
//tailcalls  10  replace tail calls by jumps
//specialize  11  @specialized-driven class and method specialization
//explicitouter  12  this refs to outer pointers, translate patterns
//erasure  13  erase types, add interfaces for traits
//lazyvals  14  allocate bitmaps, translate lazy vals into lazified defs
//lambdalift  15  move nested functions to top level
//constructors  16  move field definitions into constructors
//flatten  17  eliminate inner classes
//mixin  18  mixin composition
//cleanup  19  platform-specific cleanups, generate reflective calls
//icode  20  generate portable intermediate code
//inliner  21  optimization: do inlining
//closelim  22  optimization: eliminate uncalled closures
//dce  23  optimization: eliminate dead code
//jvm  24  generate JVM bytecode
//terminal  25  The last phase in the compiler chain


class StatsPlugin(val global: Global) extends Plugin {

  import global._

  val name = "stats"
  val description = "generates code stats"
  val components = List[PluginComponent](Component)

  private object Component extends PluginComponent {
    val global: StatsPlugin.this.global.type = StatsPlugin.this.global
    val runsAfter = List("parser")
    val phaseName = StatsPlugin.this.name
    override val description = StatsPlugin.this.description

    def newPhase(prev: Phase) = new StatsPhase(prev)

    class StatsPhase(prev: Phase) extends StdPhase(prev) {
      override def name = StatsPlugin.this.name

      def apply(unit: CompilationUnit): Unit = traverseAST(unit.body)

      private def dumpASTStats(codes: List[Option[Int]], fileName: String): Unit = {
        val res = codes.flatten.groupBy(x => x).toSeq.map {
          case (code, codes) => (code.toName, codes.length)
        }.sortBy(-_._2)
        val nAST = res.foldLeft(0) {
          case (l, (_, count)) => l + count
        }
        println(s"Parsed through $nAST AST entries in ${res.length} distinct AST types")
        val r = res.map {
          case (name, count) => s"$name,$count"
        }.mkString("\n")
        scala.tools.nsc.io.File(fileName).writeAll(r)
      }

      private def traverseAST(tree: Tree): Unit = {
        val traverser = new Traverser {
          var codes = List.empty[Option[Int]]

          override def traverse(tree: Tree): Unit =
            tree match {
              case generic =>
                codes = generic.shortClass.toCode :: codes
                super.traverse(tree)
            }
        }
        traverser.traverse(tree)
        dumpASTStats(traverser.codes, "stats.csv")
      }
    }

  }

}
