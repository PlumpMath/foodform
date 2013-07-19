(ns foodform.root
  (:use
    [compojure.core :only (defroutes GET)]
    [compojure.route :only (not-found)]
    [joodo.middleware.view-context :only (wrap-view-context)]
    [joodo.views :only (render-template render-html)]
    [joodo.controllers :only (controller-router)]))

(defroutes foodform-routes
  (GET "/" [] (render-template "index"))
  (GET "/wm" [] (render-template "wm"))
  (controller-router 'foodform.controller)
  (not-found (render-template "not_found" :template-root "foodform/view" :ns `foodform.view.view-helpers)))

(def app-handler
  (->
    foodform-routes
    (wrap-view-context :template-root "foodform/view" :ns `foodform.view.view-helpers)))

