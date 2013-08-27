(defproject taz-clj "0.1.0"
  :description "Serves jpegs from pdfs like a tornado"
  :repositories {"apache-releases" "https://repository.apache.org/content/repositories/releases/"}
  :url "https://github.com/fbernier/taz-clj"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.apache.pdfbox/pdfbox "1.8.2"]
                 [compojure "1.1.5"]
                 [http-kit "2.1.10"]
                 [ring/ring-core "1.2.0"]
                 [org.clojure/tools.cli "0.2.4"]]
  :main taz-clj.core)
