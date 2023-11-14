;; EJ) 15. Definir una función para eliminar las ocurrencias de un dato escalar en una lista (a todo nivel).

(defn eliminar-ocurrencias [dato lista]
  (if (empty? lista)
    '()
    (let [primer-elemento (first lista)
          resto (rest lista)]
      (cond
        (coll? primer-elemento) (cons (eliminar-ocurrencias dato primer-elemento) (eliminar-ocurrencias dato resto))
        (= primer-elemento dato) (eliminar-ocurrencias dato resto)
        :else (cons primer-elemento (eliminar-ocurrencias dato resto))))))

(def mi-lista [1 2 [3 4 [5 6 7] 8] 9 [10 [11 12] 13] 14])
(def dato-a-eliminar 3)

(def resultado (eliminar-ocurrencias dato-a-eliminar mi-lista))
(println resultado) 
;; Devuelve '(1 2 (4 (5 6 7) 8) 9 (10 (11 12) 13) 14)
