(ns core
  (:require [nrepl.server :refer [start-server]])
  (:gen-class))

;; Just a function to check if i can connect to the running jar and change things on the fly
(defn can-i-run-this? [] (println "Your are in, and the rest of the code is here"))

;; Change this function to see the hot-reloading taking place
(defn printed-every-second [] ".")

(defn -main []
  (println "Starting REPL server on port 7888...")
  (let [server (start-server :port 7888)]
    (println "REPL server started!")
    (try
      (loop [i 0]
        (if (zero? (rem i 80))
          (println "")
          (print (printed-every-second)))
        (flush)
        (Thread/sleep 1000)
        (recur (inc i)))
      (finally
        (println "Stopping REPL server...")
        ;; Gracefully stop the server when done
        (.close server)))))
