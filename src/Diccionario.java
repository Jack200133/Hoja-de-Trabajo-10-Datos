public interface Diccionario<C, V> {
    void insertar(C c, V v);
    V recuperar(C c) throws Exception;
    void eliminar(C c) throws Exception;
    boolean esVacio();
    int talla();
    ListaConPI<C> toLPIClaves();
}