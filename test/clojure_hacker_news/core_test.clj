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
    (let [{status :status body :body headers :headers} (myapp (mock/request :get "/not-a-ping"))]
      (is (= 404 status))
      (is (= {"Content-Type" "text/plain; charset=utf-8"} headers))
      (is (= "not found" body))))
  (testing "not-found"
    (let [{status :status body :body headers :headers} (myapp (mock/request :get "/not-found"))]
      (is (= 404 status))
      (is (= {"Content-Type" "text/plain; charset=utf-8"} headers))
      (is (= "not found" body))))
  (testing "also-not-found"
    (let [{status :status body :body headers :headers} (myapp (mock/request :get "/also-not-found"))]
      (is (= 404 status))
      (is (= {"Content-Type" "text/plain; charset=utf-8"} headers))
      (is (= "not found" body)))))



