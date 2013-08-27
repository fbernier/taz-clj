(ns taz-clj.handler
  (:use [compojure.route :only [files not-found]]
        [compojure.handler :only [api]]
        [compojure.core :only [defroutes GET]]
        [compojure.response :only [Renderable render]]
        org.httpkit.server)
  (:require [ring.util.response]
            [taz-clj.converter :as converter]
            [taz-clj.renderer :as renderer]))

(extend-protocol Renderable
  java.awt.image.BufferedImage
  (render [image _]
    (renderer/extend-renderable image)))

(defroutes all-routes
  (GET "/:filename.pdf" [filename page]
       (converter/convert-to-image filename
                                   (re-matches #"[1-9]+" (str page)))))

(defn start [port]
  (run-server (api #'all-routes) {:port port}))
