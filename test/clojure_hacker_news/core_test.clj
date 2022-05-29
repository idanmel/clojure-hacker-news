(ns clojure-hacker-news.core-test
  (:require [clojure.test :refer :all]
            [clojure-hacker-news.core :refer :all]
            [ring.mock.request :as mock]))

(deftest ping
  (testing "ping"
    (let [{status :status body :body headers :headers} (myapp (mock/request :get "/ping"))]
      (is (= 200 status))
      (is (= {"Content-Type" "text/plain; charset=utf-8"} headers))
      (is (= "pong" body)))))

(deftest not-found
  (testing "not-a-ping"
    (is (= (myapp (mock/request :get "/not-a-ping"))
           {:body    "not found"
            :headers {"Content-Type" "text/plain; charset=utf-8"}
            :status  404})))
  (testing "not-found"
    (is (= (myapp (mock/request :get "/not-found"))
           {:body    "not found"
            :headers {"Content-Type" "text/plain; charset=utf-8"}
            :status  404})))
  (testing "also-not-found"
    (is (= (myapp (mock/request :get "/also-not-found"))
           {:body    "not found"
            :headers {"Content-Type" "text/plain; charset=utf-8"}
            :status  404}))))



