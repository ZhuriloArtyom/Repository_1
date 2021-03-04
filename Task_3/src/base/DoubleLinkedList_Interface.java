package base;

public interface DoubleLinkedList_Interface<T> {
      void CreateDummy();
      DoubleLinkedListElement_Interface ReturnTail();
      DoubleLinkedListElement_Interface ReturnHead();
      DoubleLinkedListElement_Interface ReturnNext(DoubleLinkedListElement_Interface CurrentElement);
      DoubleLinkedListElement_Interface ReturnPrev(DoubleLinkedListElement_Interface CurrentElement);
      void AddElement (T Data,DoubleLinkedListElement_Interface CurrentElement);
      void DeleteElement(DoubleLinkedListElement_Interface CurrentElement);
      DoubleLinkedListElement_Interface FindFromHead(int Steps);
      DoubleLinkedListElement_Interface FindFromTail(int Steps);
      DoubleLinkedListElement_Interface FindFromHeadByData(T InputData);
      DoubleLinkedListElement_Interface FindFromTailByData(T InputData);
      void ChangeData(DoubleLinkedListElement_Interface CurrentElement, T NewData);
      int ReturnSize();
}
