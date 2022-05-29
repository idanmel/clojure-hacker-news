(ns clojure-hacker-news.responses)

(def content-type-plain-text {"Content-Type" "text/plain; charset=utf-8"})

(defn response-plain-text [body status]
  {:headers content-type-plain-text
   :status status
   :body body})

(def response-not-found
  (response-plain-text "not found" 404))

(defn response-json [body]
  {:headers {"Content-Type" "application/json; charset=utf-8"}
   :status 200
   :body body})
