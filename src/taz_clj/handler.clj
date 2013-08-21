(ns taz-clj.handler
  (:import [javax.imageio ImageIO]
           [java.io ByteArrayOutputStream ByteArrayInputStream]
           [java.awt.image BufferedImage])
  (:use [compojure.route :only [files not-found]]
        [compojure.handler :only [api]]
        [compojure.core :only [defroutes GET]]
        [compojure.response :only [Renderable render]]
        org.httpkit.server)
  (:require [ring.util.response]
            [taz-clj.renderer :as renderer]))

(defn render-image [^BufferedImage image]
  (with-open [out (ByteArrayOutputStream.)]
    (do (ImageIO/write image "jpeg" out) (ByteArrayInputStream. (.toByteArray out)))))

(extend-protocol Renderable
  BufferedImage
  (render [image _]
    (-> (ring.util.response/response (render-image image))
        (ring.util.response/content-type "image/jpeg"))))

(defroutes all-routes
  (GET "/:filename.pdf" [filename page]
       (renderer/convert-to-image filename
                                  (re-matches #"[1-9]+" (str page)))))

(defn start []
  (run-server (api #'all-routes) {:port 8080}))
