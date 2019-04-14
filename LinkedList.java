import java.util.ArrayList;
import java.util.Iterator;

/**
 * LinkedList
 */
public class LinkedList<T> implements Iterable<T>{
    private int n;
    private ArrayList<T> list;
    /**
     * Ctor linkedlist
     */
    public LinkedList() {
        n = 0;
        list = new ArrayList<T>();
    }
    public LinkedList(LinkedList<T> original) {
        n = original.n;
        list = new ArrayList<T>();
        for (Object el : original) {
            list.add((T) el);
        }
    }
    @Override
    public Iterator<T> iterator() {
        return this.list.iterator();
    }
    /**
     * Mengembalikan indeks dimana elemen ditemukan, -1 jika tidak ada
     * @param element elemen yang ingin dicari dari linked list
     * @return index elemen, -1 jika tidak ada
     */
    public int find(T element) {
        if (n > 0){
            for (int i = 0; i < n; i++) {
                if (list.get(i).equals(element)){
                    return i;
                }
            }
            return -1;
        }else{
            return -1;
        }
    }
    /**
     * Mengembalikan True jika linked list kosong
     * @return apakah linked list kosong
     */
    public boolean isEmpty(){ return n == 0; }
    /**
     * Mengembalikan panjang linkedlist
     * @return jumlah elemen pada linkedlist
     */
    public int length(){ return n; }
    /**
     * Menambahkan elemen sebagai elemen paling akhir
     * @param elemen elemen yang akan ditambahkan pada linked list
     */
    public void add(T element) {
        list.add(element);
        n++;
    }
    /**
     * Membuang elemen dari linked list. 
     * Jika dua elemen yang identik, maka hanya element pertama yang dihapus
     * @param elemen yang akan dibuang dari linked list
     */
    public void remove(T element){
        list.remove(element);
    }
    /**
     * Mengembalikan elemen pada indeks
     * @param index index dari data yang diinginkan
     * @return objek pada index ke-index
     */
    public T get(int index) throws IndexOutOfBoundsException{
        if (index != -1 && index < n){
            return list.get(index);
        }else{
            throw new IndexOutOfBoundsException();
        }
    }
    /**
     * Mengosongkan linked list
     */
    public void removeAll(){
        if (!isEmpty()){
            n = 0;
            list = new ArrayList<T>();
        }
    }
}