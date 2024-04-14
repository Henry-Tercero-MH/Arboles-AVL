public class ArbolAvl {
    public static void main(String[] args) {
        Nodo raiz = null;

        // insertamos datos
        raiz = new Nodo().insertar(raiz, 10);
        raiz = new Nodo().insertar(raiz, 20);
        raiz = new Nodo().insertar(raiz, 30);
        raiz = new Nodo().insertar(raiz, 40);
        raiz = new Nodo().insertar(raiz, 50);
        raiz = new Nodo().insertar(raiz, 25);

        // Imprimir en orden
        System.out.println("Recorrido inorden del árbol AVL:");
        raiz.imprimirInOrden(raiz);
    }
}

