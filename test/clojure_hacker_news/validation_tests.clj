(ns clojure-hacker-news.validation-tests
  (:require [clojure.test :refer [deftest testing is]]
            [clojure-hacker-news.validations :refer [valid-create-inputs?]]))

(deftest validate-inputs
  (testing "request map is made from :content and :title keys"
    (is (= (valid-create-inputs? {:content "text" :title "awesome"}) true)))
  (testing "request map had invalid keys"
    (is (= (valid-create-inputs? {:not-content "text" :title "awesome"}) false))))