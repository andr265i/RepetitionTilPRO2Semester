package emne27_koe;

import java.util.NoSuchElementException;

public class ArrayKø <E> {

    private int makskapacitet;
    private int front;
    private int back;
    private int size = 0;
    private E[] arrayKø;

    public ArrayKø(int makskapacitet) {
        this.makskapacitet = makskapacitet;
       arrayKø = (E[])new Object[makskapacitet];
       front = 0;
       back = 0;
       size = 0;
    }

   public void enqueue(E element) {

        if(size == makskapacitet) {
            throw new KøFuldException();

        }

       arrayKø[back] = element;
       back = (back + 1) % makskapacitet;
       size++;
   }

   public E dequeue() {

       if (size == 0) {
           throw new NoSuchElementException();
       }
       E fjernet = arrayKø[front];
       arrayKø[front] = null;
       front = (front +1) % makskapacitet;
       size--;

        return fjernet;
   }

   public E peek() {
        if(size == 0) {
            throw new NoSuchElementException();
        }
        return arrayKø[front];
   }

   public int size() {
        return size;
   }

    boolean erTom() {
        return size == 0;
    }

    boolean erFuld() {
        return size == makskapacitet;
    }


}
