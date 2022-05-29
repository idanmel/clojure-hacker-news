(ns clojure-hacker-news.controllers-test
  (:require [clojure.test :refer :all]
            [clojure-hacker-news.responses :refer [response-plain-text]]
            [clojure-hacker-news.controllers.post :as post-controller]))

(deftest created-post-response
  (testing "post created"
    (is (= (response-plain-text "post created" 201) (post-controller/create-response :ok))))
  (testing "post not created"
    (is (= (response-plain-text "post creation failed" 500) (post-controller/create-response :error)))))

(deftest controller-2-sql-dsl
  (testing "Turn request to honeysql dsl"
    (is (= (post-controller/req->sql-dsl {:content "text" :title "awesome"})
           {:insert-into [:post] :values [{:content "text", :title "awesome"}]}))))