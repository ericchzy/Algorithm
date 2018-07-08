package com.deecheng.helloworld; /* Added by Eclipse.py */


import java.util.Iterator;
import java.util.ListIterator;

public class MyArrayList<AnyType> implements Iterable<AnyType>
{
    /**
     * Construct an empty ArrayList.
     */
    public MyArrayList( )
    {
        doClear( );
    }
    
    /**
     * Returns the number of items in this collection.
     * @return the number of items in this collection.
     */
    public int size( )
    {
        return theSize;
    }
    
    /**
     * Returns true if this collection is empty.
     * @return true if this collection is empty.
     */ 
    public boolean isEmpty( )
    {
        return size( ) == 0;
    }
    
    /**
     * Returns the item at position idx.
     * @param idx the index to search in.
     * @throws ArrayIndexOutOfBoundsException if index is out of range.
     */
    public AnyType get( int idx )
    {
        if( idx < 0 || idx >= size( ) )
            throw new ArrayIndexOutOfBoundsException( "Index " + idx + "; size " + size( ) );
        return theItems[ idx ];    
    }
        
    /**
     * Changes the item at position idx.
     * @param idx the index to change.
     * @param newVal the new value.
     * @return the old value.
     * @throws ArrayIndexOutOfBoundsException if index is out of range.
     */
    public AnyType set( int idx, AnyType newVal )
    {
        if( idx < 0 || idx >= size( ) )
            throw new ArrayIndexOutOfBoundsException( "Index " + idx + "; size " + size( ) );
        AnyType old = theItems[ idx ];    
        theItems[ idx ] = newVal;
        modCount++;

        return old;    
    }

    @SuppressWarnings("unchecked")
    public void ensureCapacity( int newCapacity )
    {
        if( newCapacity < theSize )
            return;

        AnyType [ ] old = theItems;
        theItems = (AnyType []) new Object[ newCapacity ];
        for( int i = 0; i < size( ); i++ )
            theItems[ i ] = old[ i ];
        modCount++;
    }
    
    /**
     * Adds an item to this collection, at the end.
     * @param x any object.
     * @return true.
     */
    public boolean add( AnyType x )
    {
        add( size( ), x );
        return true;            
    }
    
    /**
     * Adds an item to this collection, at the specified index.
     * @param x any object.
     * @return true.
     */
    public void add( int idx, AnyType x )
    {
        if( theItems.length == size( ) )
            ensureCapacity( size( ) * 2 + 1 );

        for( int i = theSize; i > idx; i-- )
            theItems[ i ] = theItems[ i - 1 ];

        theItems[ idx ] = x;
        theSize++;
        modCount++;
    }

    /**
     * Adds all the items to the end of this collection.
     * @param items list that is Iterable
     */
    //TODO: Deal with modCount param
    public void addAll(Iterable<? extends AnyType> items) {
        for (AnyType item : items) {
            add(item);
        }
    }
      
    /**
     * Removes an item from this collection.
     * @param idx the index of the object.
     * @return the item was removed from the collection.
     */
    public AnyType remove( int idx )
    {
        AnyType removedItem = theItems[ idx ];
        
        for( int i = idx; i < size( ) - 1; i++ )
            theItems[ i ] = theItems[ i + 1 ];
        theSize--;
        modCount++;
        
        return removedItem;
    }
    
    /**
     * Change the size of this collection to zero.
     */
    public void clear( )
    {
        doClear( );
    }
    
    private void doClear( )
    {
        theSize = 0;
        ensureCapacity( DEFAULT_CAPACITY );
    }
    
    /**
     * Obtains an Iterator object used to traverse the collection.
     * @return an iterator positioned prior to the first element.
     */
    public java.util.ListIterator<AnyType> iterator( )
    {
        return new ArrayListIterator( );
    }

    /**
     * Returns a String representation of this collection.
     */
    public String toString( )
    {
            StringBuilder sb = new StringBuilder( "[ " );

            for( AnyType x : this )
                sb.append( x + " " );
            sb.append( "]" );

            return new String( sb );
    }
    
    /**
     * This is the implementation of the ArrayListIterator.
     * It maintains a notion of a current position and of
     * course the implicit reference to the MyArrayList.
     */
    private class ArrayListIterator implements java.util.ListIterator<AnyType>
    {
        private int current = 0;
        private boolean okToRemove = false;
        private int expectedModCount = modCount;
        
        public boolean hasNext( )
        {
            return current < size( );
        }

        public AnyType next( ) {
            if( modCount != expectedModCount )
                throw new java.util.ConcurrentModificationException( );
            if( !hasNext( ) )
                throw new java.util.NoSuchElementException( );
                  
            okToRemove = true;
            return theItems[current++];
        }

        @Override
        public boolean hasPrevious() {
            return current > 0;
        }

        @Override
        public AnyType previous() {
            if( modCount != expectedModCount )
                throw new java.util.ConcurrentModificationException( );
            if (!hasPrevious()) {
                throw new java.util.NoSuchElementException();
            }

            okToRemove = true;
            return theItems[current--];
        }

        @Override
        public int nextIndex() {
            return current + 1;
        }

        @Override
        public int previousIndex() {
            return current - 1;
        }

        public void remove( ) {
            if( modCount != expectedModCount )
                throw new java.util.ConcurrentModificationException( );
            if( !okToRemove )
                throw new IllegalStateException( );
                
            MyArrayList.this.remove( --current );
            okToRemove = false;
            expectedModCount++;
        }

        @Override
        public void set(AnyType x) {
            MyArrayList.this.set(current, x);
            expectedModCount++;
        }

        @Override
        public void add(AnyType x) {
            if( modCount != expectedModCount )
                throw new java.util.ConcurrentModificationException( );
            MyArrayList.this.add(current, x);
            expectedModCount++;
        }

    }
    
    private static final int DEFAULT_CAPACITY = 10;
    private int modCount = 0;
    private AnyType [ ] theItems;
    private int theSize;
}

class TestArrayList
{
    public static void main( String [ ] args )
    {
        MyArrayList<Integer> lst = new MyArrayList<>( );

        for( int i = 0; i < 10; i++ )
                lst.add( i );
        for( int i = 20; i < 30; i++ )
                lst.add( 0, i );

        lst.remove( 0 );
        lst.remove( lst.size( ) - 1 );

        System.out.println( lst );

        ListIterator itr = lst.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
        while (itr.hasPrevious()) {
            System.out.println(itr.previous());
        }
    }
}
