(ns taz-clj.core
  (:require [taz-clj.handler :as handler])
  (:gen-class))

(defn -main [& args]
  (handler/start))
