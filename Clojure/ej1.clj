;; 1. Definir la función tercer-angulo que reciba los valores de dos de 
;; los ángulos interiores de un triángulo y devuelva el valor del restante.

(defn tercer-angulo [angulo1, angulo2]
    (cond
        (> 0 angulo1) (printl "Error, angulo 1 Neg")
        (> 0 angulo2) (printl "Error, angulo 2 Neg")
        (< 180 (+ angulo1 angulo2)) (printl "Error suma mayor a 180")
        :else (printl (- 180 (+ angulo1 angulo2)))
    )
)

;; ej: (tercer-angulo 20 60)
;;      ->   100
;;      (tercer-angulo 20 1860)
;;      -> Error suma mayor a 180
