;"EJ5. Definir la función capicua? que reciba un número entero no negativo
; de hasta 5 dígitos y devuelva true si el número es capicúa; si no, false."

 (defn es-capicua? [n]
  (cond
      (> 0 n) (println "Error, numero Neg")
      (> n 99999) (println "Error, numero mayor a 5 cifras")
      :else (
             println (= (str n) (apply str (reverse (str n))))
            )
  )
)

(es-capicua? 121)
(es-capicua? 123)
(es-capicua? 123255)
(es-capicua? -123)

