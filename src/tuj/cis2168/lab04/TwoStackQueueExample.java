package tuj.cis2168.lab04;

import java.util.NoSuchElementException;

public class TwoStackQueueExample {
  
}

class TwoStackQueue<T> implements Queue<T> {

  private Stack<T> arrivalStack;
  private Stack<T> departureStack;

  @Override
  public void enqueue(T elem) {
    arrivalStack.push(elem);
  }

  @Override
  public T dequeue() {
    if(departureStack.isEmpty()) {
      if(!arrivalStack.isEmpty()) {
        this.flush();
      } else {
        throw new NoSuchElementException();
      }
    }

    return departureStack.pop();
  }

  private void flush() {
    while(!arrivalStack.isEmpty()) {
      departureStack.push(arrivalStack.pop());
    }
  }

  @Override
  public T peek() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'peek'");
  }

  @Override
  public boolean isEmpty() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'isEmpty'");
  }

}
