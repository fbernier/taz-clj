(ns taz-clj.renderer
  (:import [javax.imageio ImageIO]
           [java.io ByteArrayOutputStream ByteArrayInputStream]
           [java.awt.image BufferedImage])
  (:require [ring.util.response]))

(defn render-image [^BufferedImage image]
  (with-open [out (ByteArrayOutputStream.)]
    (do (ImageIO/write image "jpeg" out)
        (ByteArrayInputStream. (.toByteArray out)))))

(defn extend-renderable [^BufferedImage image]
  (-> (ring.util.response/response (render-image image))
      (ring.util.response/content-type "image/jpeg")))
