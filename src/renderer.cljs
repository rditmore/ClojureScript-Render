(ns renderer
  (:require
   [clojure.string :as string]
   [cljs.reader :as reader]
   [goog.dom :as dom]
   [goog.events :as events]
   [goog.events.EventType :as event-type]))

(defn debug
  "Output goes to your web browser's console"
  [msg]
  (js/console.log msg))
;(defn debug [_]) ;; switch to this debug to turn off output

(defn attrs-props [attrs]
  (string/join " "
               (map
                (fn [[k v]]
                  (str " " (name k) "=\"" v "\""))
                attrs)))

(defn closing-tag [tag attrs]
  (str "<" tag (attrs-props attrs) " />"))

(defn wrapping-tag [tag attrs inner]
  (str "<" tag (attrs-props attrs) ">"
       inner
       "</" tag ">"))

(defn compile-form [form]
  (cond
   (vector? form)
   (let [[tag attrs & body] form]
     ;(debug (name tag))
     ;(debug attrs)
     ;(debug body)
     (if (seq body)
       (wrapping-tag (name tag) attrs (apply str (map compile-form body)))
       (closing-tag (name tag) attrs)))
   (seq? form) (apply str (map compile-form form))
   :else
   (str form)))

(defn render [& _]
  (let [input-text (.value (dom/getElement "input-text"))
        input-form (reader/read-string input-text)
        output-compiled (compile-form input-form)]
    ; (debug (.value (dom/getElement "input-text")))
    (dom/setTextContent
     (dom/getElement "output-compiled") output-compiled)
    (set! (.innerHTML (dom/getElement "output-rendered") ) output-compiled)))

(defn init []
  (events/listen (dom/getElement "input-text") event-type/KEYUP render)
  (render))

(init)
  
