package homework3;

import java.util.AbstractSequentialList;
import java.util.ListIterator;

/**
 * This class is a double linked list class.It contains Itrlist class for use Listiterator class
 * this class extend to AbstractSequentialList and Itrlist implement by using ListIterator interface
 * @author Hamza konaç
 * @since   1.4.23
 */
public class LDLinkedlist<E> extends AbstractSequentialList<E>{
    /**
     * A Node object is block of the double linkedlist
     */
    private static class Node<E>
    {
        /**data of the block */
        private E data;

        /**situtaion of node is delete or not */
        private boolean lazy_delete;

        /**link to next node */
        private Node<E> next=null;
        
        /**link to previous node */
        private Node<E> prev=null;
        
        /**
         * Condtructer of the linked list
         * @param data data of the block
         * @param next next block
         * @param prev previous block
         */
        Node(E data, Node<E> next, Node<E> prev) 
        {
            this.data = data;
            this.next = next;
            this.prev = prev;
            this.lazy_delete=false;
        }

    }
    
    /**Head block of the list */
    private Node<E> head;

    /**Tail of the list */
    private Node<E> tail;

    /**number of the block in linked list*/
    private int size;

    private int lazy_delete_number;

    /**
     * Constructer of the linked list
     */
    public LDLinkedlist()
    {
        head=null;
        tail=null;
        size=0;
    }

    /**
     * return total element in the linked list
     */
    public int size()
    {
        return this.size;
    }

    /**
     * return node at index's position
     * @param index index that will return
     * @return node
     */
    private Node<E> node(int index)
    {
        Node<E> temp;
        // System.out.println((size/2));
        if(index>size/2)
        {
            int i=0;
            temp=tail;
            index=size-index-1;
            while(i<index)
            {
                temp=temp.prev;
                i++;
            }
        }
        else
        {
            temp=head;
            int i=0;
            while(i<index)
            {
                temp=temp.next;
                i++;
            }
        }
            return temp;
    }

    /**
     * add new item the list
     * @param item new block of the list
     */
    private void linklast(E item)
    {
        Node<E> temp=tail;
        Node<E> newNode=new Node<E>(item,null,temp);
        tail=newNode;
        if(temp==null)
            head=newNode;
        else
            temp.next=newNode;
    
    }

    /**
     * add new to middle or head of the list
     * @param refnode referance node after new node
     * @param item new block for the list
     */
    private void linkbefore(Node<E> refnode,E item)
    {
        Node<E> prev_ref=refnode.prev;
        Node<E> new_node=new Node<E>(item,refnode,refnode.prev);
        refnode.prev=new_node;
        if(prev_ref==null)
            head=new_node;
        else
            prev_ref.next=new_node;
    }

    /**
     * Remove node from linked list
     * @param node node that will removed
     * @return node's data
     */
    private E remove_link(Node<E> node)
    {
        
        Node<E> prev_ref=node.prev;
        E return_data=node.data;
        if(prev_ref==null)
        {
            head=head.next;
            if(head!=null)
                head.prev=null;
            if(head==null)
                tail=head;
        }
        else if(node.next==null)
        {
            node=node.prev;
            node.next=null;
        }
        else
        {
            prev_ref.next=node.next;
            node.next.prev=prev_ref;
        }
        return return_data;
    }
    /**
     * 
     * @return true if item can added to list
     */
    public boolean add(E item)
    {
        linklast(item);
        size++;
        return true;
        
    }

    /** add node last of the linked list*/
    public void addLast(E e)
    {
        linklast(e);
        size++;   
    }

    /**
     * Add new block at specified indec
     */
    public void add(int index,E item) throws IndexOutOfBoundsException
    {
        if(index>size)  
            throw new IndexOutOfBoundsException();
        else if(index==size)
            linklast(item);
        else
        {
            linkbefore(node(index), item);
        }
        size++;

    }

    /**
     * return data of the specified number of the index
     * if index exceed to size exception IndexOutOfBoundsException will be thromwn
     */
    public E get(int index)
    {
        if(index<0||index>size)
            throw new IndexOutOfBoundsException();
        Node<E> temp=node(index);
        if(temp!=null)
        {

            if(!temp.lazy_delete)
                return temp.data;
        }
        return null;

    }
    
    /**
     * set new data to specified number block
     */
    public E set(int index,E anEntry)
    {
        if(index<0||index>size)
            throw new IndexOutOfBoundsException();
        Node<E> temp=node(index);
        E value=temp.data;
        temp.data=anEntry;
        return value;
    }

    /**
     * return index of target
     * @param target target that will be resarch
     * @return index of target.if there is no target -1 will be returned
     * 
     */
    public int indexOf(Object target_)
    {
        Node<E> temp=head;
        int i=0;
        
        while(temp!=null)
        {
            if(target_.equals(temp.data))
                return i;
            i++;
            temp=temp.next;
        }
        return -1;
    }

    /**
     * This implementation of class do lazy deletion.therefore some node dont remove pysically
     * so that this method show situation of the linked list with marked nodes
     */
    public void ToString()
    {
        System.out.println("Current situation of the linked list.Mean of the marked is logically deleted\n");
        Node<E> temp=head;
        System.out.println("****************************************");
        while(temp!=null)
        {
            if(temp.lazy_delete)
            System.out.print("(Marked)"+temp.data+"-->");
            else
            System.out.print(temp.data+"-->");
            temp=temp.next;
        }   
        System.out.println();
        System.out.println("****************************************");
    }

    /**
     * remove node from specified index value
     */
    public E remove(int index)
    { 
        if(index>=size||index<0)
            throw new IndexOutOfBoundsException();
        Node<E> temP=node(index);
        temP.lazy_delete=true;
        lazy_delete_number++;
        E var=temP.data;
        int counter=0;
        if(2==lazy_delete_number||size==1)
        {
            temP=head;
            while(temP!=null)
            {
                if(temP.lazy_delete)
                {
                    if(temP==head)
                    {
                        head=head.next;
                        if(head!=null)
                            head.prev=null;
                        else
                        {
                            tail=null;
                            head=null;
                        }

                    }
                    else
                    {
                        Node<E> ref=temP.next;
                        if(ref!=null)
                        {
                            ref.prev=temP.prev;
                            temP.prev.next=ref;
                        }
                        else 
                        {
                            temP=temP.prev;
                            temP.next=null;
                        }
                    }
                    size--;
                }
                temP=temP.next;
            }
            lazy_delete_number=0;
        }
        ToString();
        return var;
        
    }

    /**
     * return Itrlist class' object and it between first two nodfe if exist
     */
    public ListIterator<E> listIterator()
    {
        return new Itrlist();
    }

    /**
     * return Itrlist class' object and it come after index i if exist
     */
    public ListIterator<E> listIterator(int i)
    {
        if(i>=size||i<0)
            throw new IndexOutOfBoundsException();

        return new Itrlist(i);
    }

    /**
     * this class represent for use iterator in LDLinkedlist class
     * this class implements to ListIterator interface
     * @author Hamza konaç
     * @since 1.4.23
     */
    private class Itrlist implements ListIterator<E>
    {
        /**node that last returned */
        private Node<E> last_returned;
        
        /** next node */
        private Node<E> next;
        
        /** next index of the list*/
        private int next_index;

        /**
         * constructer that take head of the linkedlist
         */
        private Itrlist()
        {
            next=node(0);
            next_index=0;
        }
        
        /**
         * Construnter that create a iterator that take reference of item at the specified index
         * @param index return index at spesifiad by parameter
         */
        private Itrlist(int index)
        {
            next=index>=size ? null : node(index);
            next_index=index;
        }
        
        /**
         * check list has next node
         */
        @Override
        public boolean hasNext() {
           return (next_index<size);
        }

        /**
         * return next node data
         */
        @Override
        public E next() {
            if(hasNext())
            {
                if(next!=null)
                {
                    last_returned=next;
                    next=next.next;
                    next_index++;
                    return last_returned.data;
                }
                throw new IllegalAccessError();
            }
            throw new IndexOutOfBoundsException(); 
        }

        /**
         * check list to has previos node
         */
        @Override
        public boolean hasPrevious() {
            return next_index>0;
        }

        /**
         * return previous node
         */
        @Override
        public E previous() {
            if(hasPrevious())
            {
                if(next==null)
                {
                    next=tail;
                    last_returned=tail;
                }
                else
                {
                    next=next.prev;
                    last_returned=next.prev;
                }
                next_index--;
                return next.data;
            }
            throw new IndexOutOfBoundsException();
        }

        /**
         * return next node's index
         */
        @Override
        public int nextIndex() {
            return next_index;
        }

        /**
         * return previos node index
         */
        @Override
        public int previousIndex() {
            return next_index -1;
        }

        /**
         * remove last node
         */
        @Override
        public void remove() 
        {
            if(last_returned==null)
                    throw new IndexOutOfBoundsException();
            remove_link(last_returned);
            next_index--;
            size--;
            last_returned=null;
        }

        /**
         * set new data to last returned 
         */
        @Override
        public void set(E e) {
            if(last_returned==null)
                throw new IndexOutOfBoundsException();
            last_returned.data=e;
        }

        /**
         * if last node is tail of the list add new data to last
         * else add new data to location it has been
         */
        @Override
        public void add(E e) {
            if(next==null)
                linklast(e);
            else    
                linkbefore(next, e);
            size++;
            next_index++;
        }

    }

}
