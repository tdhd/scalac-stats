ast <- read.csv("./stats.csv", header=FALSE)
barplot(ast$V2, names.arg=ast$V1)
