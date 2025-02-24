# How to setup a repl in a jar file

## You should run the following commands

```bash
# Build the uberjar
clj -T:build uber
# Run the uberjar
java -jar ./target/app-standalone.jar
# You will need another terminal window now. or use `&` at the end of the previous command
clj -M -m nrepl.cmdline --connect --port 7888
```

Inside the REPL you can call functions that exist (tab auto completes stuff sometimes)
```clojure
(ns core) ;; change to the core namespace

(printed-every-second) ;; can call the function

;; redefine the function, you can see that the jar running is changed as well.
(defn printed-every-second [] "*") 
```

What is going on in this repo.

There is 3 main parts

* `src/core.clj` is where the actual code run in the jar file can be found. Just a loop with a few functions to show hot code reload.
* `build.clj` is the build tool used to generate the uberjar. uberjar are fat jars that contains all it need to run but the JVM.
* `deps.edn` describe the project dependencies, and aliases like for build in `clj -T:`*build*` uber`


