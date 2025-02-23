(ns core-test
  (:require [clojure.test :as t]
            [core :as c]))

(t/deftest printed-every-second
  (t/testing "print a dot"
    (t/is (= "." (c/printed-every-second)))))
