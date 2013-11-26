(ns taz-clj.core
  (:require [taz-clj.handler :as handler]
            [taz-clj.util :as util])
  (:use [clojure.tools.cli :only [cli]])
  (:gen-class))

(defn -main [& args]
  (let [[options _ usage] (cli args
                               ["-d"   "--data-dir"  "Set the root path of PDFs"  :default "."]
                               ["-p"   "--port"      "Port to use"                :default 8080 :parse-fn #(Integer. #^Integer %)]
                               ["-h"   "--help"      "Usage"                      :default false :flag true])]
    (alter-var-root #'util/*cli-args* (constantly options))
    (if (:help options)
      (do
        (println usage)
        (System/exit 0))
      (handler/start (:port options)))))
