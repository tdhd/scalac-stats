## Stats generating scalac plugin

This plugin adds a phase to the scala compiler that traverses the whole compilation unit and dumps stats about it to disk.

The project used a plugin skeleton from `https://github.com/cb372/scalac-plugin-basic`.

## Usage

First package the plugin into a jar:

```
$ sbt package
```

Then compile the sample code in `src/main/test`:

```
$ sbt test:compile
```

This will result in a CSV file:

```
$ cat stats.csv
Select,144
TypeTree,87
Apply,59
Ident,51
Literal,47
This,36
...
```

which contains the AST entries with their respective counts in the compilation unit.

```
> ;clean;package;test:compile
```
