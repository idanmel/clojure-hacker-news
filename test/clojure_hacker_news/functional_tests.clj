(ns clojure-hacker-news.functional_tests
  (:require [clojure.test :refer [deftest testing is use-fixtures]]
            [clojure-hacker-news.core :refer [start-server stop-server]]
            [clj-http.client :as client]))

(deftest POST-create
  (testing "We can create a post by the correct call to the server"
    (let [body "{\"content\": \"text\", \"title\": \"hola\"}"
          url "http://localhost:5000/posts"
          {status :status} (client/post url {:body body :content-type :json :accept :json})]
      (is (= 201 status)))))

(defn server-fixture
  [f]
  (start-server 5000)
  (f)
  (stop-server))

(use-fixtures :once server-fixture)