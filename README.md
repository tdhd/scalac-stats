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

This will result in a CSV file being created:

```
$ cat ast.csv
```

```
> ;clean;package;test:compile
```
