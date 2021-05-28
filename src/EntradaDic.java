class EntradaDic<C,V> {
    C clave;
    V valor;
    EntradaDic(C c, V v) { clave = c; valor = v; }
    EntradaDic(C c) { this(c, null); }
    @SuppressWarnings("unchecked")
    public boolean equals(Object x) {
        return ((EntradaDic<C,V>)x).clave.equals(this.clave);
    }
    public String toString() {
        return "(" + this.clave + "," + this.valor + ")";
    }
    public int hashCode() { return clave.hashCode(); }}