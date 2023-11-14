;; 2. Definir la función segundos que reciba los cuatro valores (días, horas, minutos y segundos)
;; del tiempo que dura un evento y devuelva el valor de ese tiempo expresado solamente en segundos.

(defn segundos [dias horas minutos segs]
    (cond
        (> 0 dias) (println "Error, dias Neg")
        (or (> horas 24) (> 0 horas)) (println "Error, horas Neg")
        (or (> minutos 60) (> 0 minutos)) (println "Error, minutos Neg")
        (or (> segs 60) (> 0 segs)) (println "Error, segundos Neg")
        :else (
               println (+ (* minutos 60) (* horas 3600) (* dias 86400) segs)
  
               )
    )
)

(segundos 1 0 0 0)