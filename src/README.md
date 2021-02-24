# Algoritmo de ordenamiento radixSort

## Entendiendo el algoritmo

**Radix Sort** es un algoritmo diseñado para ordenar arrays de cadenas de caracteres,
pues su lógica se basa en clasificar los elementos del array según cuál sea el carácter
que tienen en la última posición, luego en la ante última, en la penúltima, y así
sucesivamente hasta llegar a clasificarlos según cuál sea el primer carácter de cada
elemento. 

Es importante conocer este funcionamiento, porque si vamos a ordenar un
array de enteros, primero tendremos que convertirlo en un array de cadenas.


Por supuesto, podemos usar Radix Sort para ordenar arrays de cualquier tipo de
dato, pero para evitar complicaciones que en este momento serían irrelevantes,
trabajaremos pensando en arrays de enteros: int[].


## El algoritmo, paso a paso

1) **Convertir el array que vamos a ordenar, de int[] a String[]**.
   Por ejemplo, si vamos a ordenar int iArr[] = {4,28,132,3,61,5}, debemos
   convertirlo en String sArr[] = {“4”,“28”,“132”,“3”,“61”,“5”}.
   
2) **Todos los elementos del String[] deben tener la misma longitud**. Para esto los
   completaremos con 0 (ceros) a la izquierda (coincidiendo con la cantidad de
   dígitos del número más grande). Según nuestro ejemplo, el array sArr debería
   quedar así: {“004”, “028”, “132” , “003”,“061”,“005”}.
   
3) **Creamos 10 listas inicialmente vacías**. L0 (será la lista para colocar los números
   que terminan con 0, En L1 colocaremos los números que terminan con 1, y
   genéricamente hablando, Li será la lista donde colocaremos aquellos números cuyo último dígito es i.
   
4) **Recorremos el String[]; por cada elemento verificamos cuál es su último dígito,
   lo removemos del array y lo agregamos a la lista que corresponda**.
   
5) **Recorremos las listas en orden: L0, L1,..., L9, y regeneramos el String[] con los
   elementos de L0, luego los de L1 y así sucesivamente**.

6) **Volvemos a (4), pero ahora trabajaremos con el anteúltimo dígito**. Es decir L0
   será la lista de los elementos que tienen 0 en su anteúltimo dígito, L1 tendrá
   aquellos elementos que tienen 1 en su anteúltimo lugar, etcétera.

7) **En cada iteración evaluamos y clasificamos los elementos del array según cuál
   sea su último, anteúltimo, antepenúltimo, (...) y primer dígito**. Luego de esto el
   array quedará ordenado.