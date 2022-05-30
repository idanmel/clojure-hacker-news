(ns migrations
  (:require [migratus.core :as migratus]))

(def config {:store                :database
             :migration-dir        "migrations/"
             :init-script          "init.sql"
             :init-in-transaction? false
             :migration-table-name "migrations"
             :db {:dbtype "postgresql"
                  :dbname "hacker_news"
                  :user "postgres"
                  :password "password"
                  :host "localhost"
                  :port "5432"}})

;initialize the database using the 'init.sql' script
(migratus/init config)

;apply pending migrations
(migratus/migrate config)

;rollback the migration with the latest timestamp
(migratus/rollback config)

