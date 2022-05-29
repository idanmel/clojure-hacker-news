(defproject clojure-hacker-news "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.11.1"]
                 [compojure "1.6.3"]
                 [http-kit "2.5.3"]
                 [ring/ring-mock "0.4.0"]
                 [com.github.seancorfield/next.jdbc "1.2.780"]]
  :repl-options {:init-ns clojure-hacker-news.core})
