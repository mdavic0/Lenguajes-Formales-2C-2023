;; 3. Definir la función sig-mul-10 que reciba un número entero y devuelva el primer múltiplo de 10 que lo supere.

(defn sig-mul-10 [x]
  (* 10 (+ 1 (quot x 10)))
)