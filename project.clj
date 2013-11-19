(defproject taz-clj "0.1.0"
  :description "Serves jpegs from pdfs like a tornado"
  :repositories {"apache-releases" "https://repository.apache.org/content/repositories/snapshots/"}
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.apache.pdfbox/pdfbox "2.0.0-SNAPSHOT"]
                 [compojure "1.1.6"]
                 [http-kit "2.1.13"]
                 [ring/ring-core "1.2.1"]
                 [javax.servlet/servlet-api "2.5"]
                 [org.clojure/tools.cli "0.2.4"]]
  :jvm-opts ^:replace []
  :main taz-clj.core)
