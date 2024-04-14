class Nodo {
    //clase nodo para inicializar el arbol
    int valor;//va almacenar el valor del nodo raiz
    Nodo izquierda, derecha;//va almacenar el valor de los nodos hijos
    int altura;

    public Nodo() {//constructor vacio
    }

    Nodo(int valor) {//constructor con parametros
        this.valor = valor;
        this.altura = 1; //segun la teoria de los arboles AVL se incializa la altura en 1
    }
    public Nodo insertar(Nodo raiz, int valor) {//metodo para insertar un nuevo valor
        if (raiz == null) {
            return new Nodo(valor);//si la raiz es null crea un nuevo nodo con el valor pasado por parametros
        }

        if (valor < raiz.valor) {
            raiz.izquierda = insertar(raiz.izquierda, valor); // Si el valor es menor, insertará en el subárbol izquierdo
        } else if (valor > raiz.valor) {
            raiz.derecha = insertar(raiz.derecha, valor); // Si el valor es mayor, insertará en el subárbol derecho
        }

        // Actualiza la altura del nodo actual
        raiz.altura = 1 + Math.max(altura(raiz.izquierda), altura(raiz.derecha));

        // Calcula el balance del nodo para determinar si se requieren rotaciones para balancear el árbol
        int balance = calcularBalance(raiz);

        // Rotaciones para balancear el árbol
        if (balance > 1 && valor < raiz.izquierda.valor) {
            return rotaciónDerecha(raiz);
        }
        if (balance < -1 && valor > raiz.derecha.valor) {
            return rotaciónIzquierda(raiz);
        }
        if (balance > 1 && valor > raiz.izquierda.valor) {
            raiz.izquierda = rotaciónIzquierda(raiz.izquierda);
            return rotaciónDerecha(raiz);
        }
        if (balance < -1 && valor < raiz.derecha.valor) {
            raiz.derecha = rotaciónDerecha(raiz.derecha);
            return rotaciónIzquierda(raiz);
        }

        return raiz;
    }

   public int altura(Nodo nodo) {
        if (nodo == null) {
            return 0;
        }
        return nodo.altura;
    }

    public int calcularBalance(Nodo nodo) {
        if (nodo == null) {
            return 0;
        }
        return altura(nodo.izquierda) - altura(nodo.derecha);
    }

    public Nodo rotaciónDerecha(Nodo y) {
        Nodo x = y.izquierda;
        Nodo T2 = x.derecha;

        // Rotación
        x.derecha = y;
        y.izquierda = T2;

        // Actualizar alturas
        y.altura = 1 + Math.max(altura(y.izquierda), altura(y.derecha));
        x.altura = 1 + Math.max(altura(x.izquierda), altura(x.derecha));

        return x;
    }

    public Nodo rotaciónIzquierda(Nodo x) {
        Nodo y = x.derecha;
        Nodo T2 = y.izquierda;

        // Rotación
        y.izquierda = x;
        x.derecha = T2;

        // Actualizar alturas
        x.altura = 1 + Math.max(altura(x.izquierda), altura(x.derecha));
        y.altura = 1 + Math.max(altura(y.izquierda), altura(y.derecha));

        return y;
    }

    public void imprimirInOrden(Nodo nodo) {
        if (nodo != null) {
            imprimirInOrden(nodo.izquierda);
            System.out.print(nodo.valor + " ");
            imprimirInOrden(nodo.derecha);
        }
    }

}