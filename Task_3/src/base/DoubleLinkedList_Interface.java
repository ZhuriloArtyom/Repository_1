package base;

import base.DoubleLinkedListElement_Interface;

public interface DoubleLinkedList_Interface<T> {
      void CreateDummy();
      void SetTail(DoubleLinkedListElement_Interface NewTail);
      void SetHead(DoubleLinkedListElement_Interface NewHead);
      DoubleLinkedListElement_Interface ReturnTail();
      DoubleLinkedListElement_Interface ReturnHead();
      DoubleLinkedListElement_Interface ReturnNext(DoubleLinkedListElement_Interface CurrentElement);
      DoubleLinkedListElement_Interface ReturnPrev(DoubleLinkedListElement_Interface CurrentElement);
      void AddElement (T Data,DoubleLinkedListElement_Interface CurrentElement);
      void DeleteElement(DoubleLinkedListElement_Interface CurrentElement);
}
