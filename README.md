A leiningen template for creating new storm projects.

To use:

```bash
lein new storm-project my-awesome-storm-project
```

This will give you working storm topology. Take it for a spin:

```bash
cd my-awesome-storm-project && lein run -m my-awesome-storm-project.topology/run!
```


## License

Copyright © 2012 Travis Vachon

Distributed under the Eclipse Public License, the same as Clojure.
