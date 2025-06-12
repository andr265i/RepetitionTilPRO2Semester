package emne26_stak;

import java.util.EmptyStackException;

public class ArrayStak <E>{

    private int maxKapacitet;
    private E[] arrayStack;
    private int top = -1;

    public ArrayStak(int maxKapacitet) {
        this.maxKapacitet = maxKapacitet;
        arrayStack = (E[])new Object[maxKapacitet];
    }

   public void push(E element) {

        if(top+1 == maxKapacitet) {
            throw new StakFuldException("Stakken er fuld");
        }

        if(top == -1) {
            arrayStack[0] = element;
            top++;
        }
        else {
            top++;
            arrayStack[top] = element;
        }
   }

   public E pop() {

        if(top == -1) {
            throw new emne26_stak.EmptyStackException("tom stack");
        }

        E element = arrayStack[top];
        arrayStack[top] = null;
        top--;

        return element;
   }

   public E peek() {

        if(top == -1) {
            throw new emne26_stak.EmptyStackException("tom stack");
        }

        return arrayStack[top];
   }

   public boolean erTom() {
        return top == -1;
   }

   public int size(){
        return top+1;
   }

   public boolean erFuld(){
        return top+1 == maxKapacitet;
    }
}
