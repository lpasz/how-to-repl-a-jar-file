(ns core
  (:require [nrepl.server :refer [start-server]])
  ;; This tells clojure to generate a Java Class for this module. 
  ;; This makes java `find` this module.
  ;; Clojure see java, but java does not see clojure out of the box
  (:gen-class))

;; If you can see this function this mean that you are on the jar running this code.
;; Change this function to see the hot-reloading taking place
(defn printed-every-second [] ".")

(def not-a-fn ".")
;; This is the main entrypoint of the application.
(defn -main []
  (println "Starting REPL server on port 7888...")
  ;; We start the start-server for nrepl, this is non blocking 
  (let [server (start-server :port 7888)]
    (println "REPL server started!")
    (try
      ;; Infinity Loop that keeps printing what is the function above
      (loop [i 0]
        (if (zero? (rem i 80))
          (println "")
          (print not-a-fn))
        (flush)
        (Thread/sleep 1000)
        (recur (inc i)))
      (finally
        (println "Stopping REPL server...")
        ;; Gracefully stop the server when done
        (.close server)))))

(comment
  (printed-every-second))
