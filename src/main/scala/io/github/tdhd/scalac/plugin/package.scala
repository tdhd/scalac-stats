package io.github.tdhd.scalac

package object plugin {
  // FIXME: make this a list of types instead
  val symbols = List(
    "PackageDef",
    "ImplDef",
    "ClassDef",
    "ModuleDef",
    "ValOrDefDef",
    "ValDef",
    "DefDef",
    "TypeDef",
    "LabelDef",
    "ImportSelector",
    "Import",
    "Template",
    "Block",
    "CaseDef",
    "Alternative",
    "Star",
    "Bind",
    "UnApply",
    "Function",
    "Assign",
    "AssignOrNamedArg",
    "If",
    "Match",
    "Return",
    "Try",
    "Throw",
    "New",
    "Typed",
    "GenericApply",
    "TypeApply",
    "Apply",
    "Super",
    "This",
    "Select",
    "Ident",
    "Literal",
    "Annotated",
    "SingletonTypeTree",
    "SelectFromTypeTree",
    "CompoundTypeTree",
    "AppliedTypeTree",
    "TypeBoundsTree",
    "ExistentialTypeTree",
    "TypeTree",
    "TreeCopier",
    "Modifiers",
    "ModifiersCreator"
  )
  // inverted map
  val nameToCode = symbols.zipWithIndex.toMap
  val codeToName = nameToCode.map(_.swap)


  implicit class CodeToNameMapper(code: Int) {
    def toName = codeToName(code)
  }

  implicit class NameToCodeMapper(name: String) {
    def toCode = nameToCode.get(name)
  }
}
