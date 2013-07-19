(ns foodform.root-spec
  (:use
    [speclj.core]
    [joodo.spec-helpers.controller]
    [foodform.root]))

(describe "foodform"

  (with-mock-rendering)
  (with-routes app-handler)

  (it "handles home page"
    (let [result (do-get "/")]
      (should= 200 (:status result))
      (should= "index" @rendered-template)))
  )

(run-specs)
