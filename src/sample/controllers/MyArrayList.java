package sample.controllers;

import java.util.*;

public class MyArrayList<T> implements List {

    private Object[] elements ;
    private int size;


    public MyArrayList(){
        elements = new Object[256];
        size = 0;
    }

    public MyArrayList(Collection collection){

        elements = new Object[256];
        size = 0;
        Iterator iterator = collection.iterator();

        while(iterator.hasNext()){
            add(iterator.next());
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0 ? true : false;
    }

    @Override
    public boolean contains(Object o) {
        for(int i=0; i<elements.length; i++){
            if(elements[i] == o)
                return true;
        }
        return false;
    }

    @Override
    public Iterator iterator() {

        return new ArrayListIterator();
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean add(Object o) {

        if(size == elements.length -1)
            reSizeArray();

        elements[size] = o;
        ++size;
        return true;
    }

    private void reSizeArray(){
        Object[] tmp = elements;

        elements = new Object[elements.length * 2];

        for(int i=0; i<tmp.length; i++){
            elements[i] = tmp[i];
        }
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public T get(int index) {
        if(index < 0 || index > elements.length -1)
            throw new ArrayIndexOutOfBoundsException();
        return (T) elements[index];
    }

    @Override
    public Object set(int index, Object element) {
        return null;
    }

    @Override
    public void add(int index, Object element) {

    }

    @Override
    public Object remove(int index) {

        Object tmp = elements[index];

        for(int i=index; i<size - 1; i++)
            elements[i] = elements[i+1];
        return tmp;
    }

    @Override
    public int indexOf(Object o) {
        for(int i=0; i<elements.length; i++)
            if(elements[i] == o)
                return i;
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    private class ArrayListIterator implements java.util.Iterator<Object> {

        private int current = 0;

        public boolean hasNext() {
            return current < size();
        }

        public Object next() {
            if (!hasNext()) throw new java.util.NoSuchElementException();
            return elements[current++];
        }

        public void remove() {
            MyArrayList.this.remove(--current); // reference the outer class
        }
    }
}
