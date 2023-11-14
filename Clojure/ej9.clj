;; 9. Definir la función cant-dig que reciba un número entero y devuelva la cantidad de dígitos que este tiene.

(defn cant_dig [n]
  (count (str n))  
)

(println (cant_dig 55555555))