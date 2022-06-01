(ns clojure-hacker-news.db
  (:require [honey.sql :as honeysql]
            [next.jdbc :as jdbc]))

(def config {:dbtype "postgresql"
             :dbname "hacker_news"
             :user "postgres"
             :password "password"
             :host "localhost"
             :port "5432"})

(def ds (jdbc/get-datasource config))

(defn create-post!
  [sql]
  (jdbc/execute! ds sql)
  :ok)
