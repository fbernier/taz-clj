(ns taz-clj.converter
  (:import [org.apache.pdfbox.pdmodel PDDocument]
           [org.apache.pdfbox.pdmodel PDPage]
           [org.apache.pdfbox.pdmodel.font PDFont]))

(defn convert-to-image [filename & [page-number]]
  (if-let [page-number (if-not (nil? page-number) (dec (Integer/parseInt page-number)))]
    (try
      (with-open [document (PDDocument/load (str (. (java.io.File. ".") getCanonicalPath) "/" filename ".pdf"))]
        (if (<= page-number (dec (.getNumberOfPages document)))
          (let [^PDPage page (.. document getDocumentCatalog getAllPages (get page-number))]
            ^BufferedImage (.convertToImage page))))
      (catch java.io.FileNotFoundException e))))
