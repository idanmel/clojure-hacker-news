(ns clojure-hacker-news.migrations
  (:require [migratus.core :as migratus]
            [clojure-hacker-news.db :as db]))

(def config {:store                :database
             :migration-dir        "migrations/"
             :init-script          "init.sql"
             :init-in-transaction? false
             :migration-table-name "migrations"
             :db db/config})

(defn init []
  (migratus/init config))

(defn migrate []
  (migratus/migrate config))
