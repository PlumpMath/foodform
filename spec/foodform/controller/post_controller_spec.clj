(ns sample_app.controller.post-controller-spec
  (:require [speclj.core :refer [describe around it should= run-specs]]
            [joodo.spec-helpers.controller :refer [do-get rendered-template rendered-context
                                                   with-mock-rendering with-routes]]
            [sample_app.controller.post-controller :refer [post-controller]]))

(describe "post-controller"
  (with-mock-rendering)
  (with-routes post-controller)

  (it "directs to the not_found page if the blog post isn't specified"
    (let [result (do-get "/post")]
      (should= 404 (:status result))
      (should= "not_found" @rendered-template)
      (should= "You must specify a blog post." (:error @rendered-context)))))
