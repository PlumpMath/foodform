(ns foodform.controller.order-controller-spec
  (:require [speclj.core :refer [describe around it should= run-specs]]
            [joodo.spec-helpers.controller :refer [do-get rendered-template rendered-context
                                                   with-mock-rendering with-routes]]
            [foodform.controller.order-controller :refer [order-controller]]))

(describe "order-controller"
  (with-mock-rendering)
  (with-routes order-controller)

  (it "directs to the not_found page if the blog order isn't specified"
    (let [result (do-get "/order")]
      (should= 404 (:status result))
      (should= "not_found" @rendered-template)
      (should= "You must specify a blog order." (:error @rendered-context)))))
