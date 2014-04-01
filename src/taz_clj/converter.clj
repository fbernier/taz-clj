(ns taz-clj.converter
  (:require [taz-clj.util :as util])
  (:import [java.awt.image BufferedImage]
           [org.apache.pdfbox.pdmodel PDDocument]
           [org.apache.pdfbox.pdmodel.font PDFont]
           [org.apache.pdfbox.rendering PDFRenderer]))

(defn convert-to-image [filename & [page-number]]
  (if-let [page-number (if-not (nil? page-number) (dec (Integer/parseInt page-number)))]
    (try
      (with-open [document (PDDocument/load (str (.getCanonicalPath (java.io.File. #^String (:data-dir util/*cli-args*))) "/" filename ".pdf"))]
        (if (<= page-number (dec (.getNumberOfPages document)))
          (let [^PDFRenderer renderer (PDFRenderer. document)]
            ^BufferedImage (. renderer renderImage page-number 2))))
      (catch java.io.FileNotFoundException e))))
