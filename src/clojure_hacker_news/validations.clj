(ns clojure-hacker-news.validations)

(defn valid-create-inputs?
  [req]
  (= #{:title :content} (set (keys req))))