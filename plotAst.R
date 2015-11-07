ast <- read.csv("./ast.csv", header=FALSE)
barplot(ast$V2, names.arg=ast$V1)
