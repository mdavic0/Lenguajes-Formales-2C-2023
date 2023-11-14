;; Ej 12) Definir la función repartir que, llamada sin argumentos, devuelva la 
;; cadena "Uno para vos, uno para mí". De lo contrario, se devolverá una lista, 
;; en la que habrá una cadena "Uno para X, uno para mí" por cada argumento X.

(defn reparto [x]
  (str "Uno para " x ", uno para mi\n"))

(defn repartir
  ([] ["Uno para vos, uno para mí"])
  ([& args] (map reparto args)))

(println (repartir))
(println (repartir "Juan"))
(println (repartir "Juan" "Roman" "Riquelme"))
