(ns clojure-hacker-news.validations)

(defn valid-create-inputs?
  [body]
  (->> body
       keys
       set
       (= #{:title :content})))
