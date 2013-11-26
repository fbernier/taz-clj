(ns taz-clj.converter

  (:require [taz-clj.util :as util])
  (:import [org.apache.pdfbox.pdmodel PDDocument]
           [org.apache.pdfbox.pdmodel PDPage]
           [org.apache.pdfbox.pdmodel.font PDFont]
           [org.apache.pdfbox.util RenderUtil]))

(defn convert-to-image [filename & [page-number]]
  (if-let [page-number (if-not (nil? page-number) (dec (Integer/parseInt page-number)))]
    (try
      (with-open [document (PDDocument/load (str (.getCanonicalPath (java.io.File. #^String (:data-dir util/*cli-args*))) "/" filename ".pdf"))]
        (if (<= page-number (dec (.getNumberOfPages document)))
          (let [^PDPage page (.. document getDocumentCatalog getAllPages (get page-number))]
            ^BufferedImage (RenderUtil/convertToImage page))))
      (catch java.io.FileNotFoundException e))))
