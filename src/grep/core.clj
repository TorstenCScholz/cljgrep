(ns grep.core
  (:require [clojure.string :as str])
  (:gen-class))

(defn filter-by-pattern
  "Filters the given sequence of strings by pattern"
  [pattern seq]
  (filter #(re-find (re-pattern pattern) %) seq))

(defn -main
  "Prints all lines that contain the specified pattern"
  [pattern & args]
  (let [input-lines (str/split-lines (slurp *in*))]
    (doseq [line (filter-by-pattern pattern input-lines)] (println line))))
