(defproject taz-clj "0.1.0"
  :description "Serves jpegs from pdfs like a tornado"
  :repositories {"apache-releases" "https://repository.apache.org/content/repositories/snapshots/"}
  :url "https://github.com/fbernier/taz-clj"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0-RC4"]
                 [org.apache.pdfbox/pdfbox "2.0.0-SNAPSHOT"]
                 [compojure "1.4.0"]
                 [http-kit "2.1.19"]
                 [ring/ring-core "1.4.0"]
                 [javax.servlet/servlet-api "2.5"]
                 [org.clojure/tools.cli "0.3.1"]]
  :jvm-opts ^:replace []
  :main taz-clj.core)
