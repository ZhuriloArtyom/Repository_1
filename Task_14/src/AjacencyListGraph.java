public class AjacencyListGraph implements Graph{
    ListElement[] List;
    int Length;
    public class ListElement{
        ListElement Next;
        ListElement Prev;
        int Node;
        Float Weight;

        public void SetNode(int NewNode) {
            Node = NewNode;
        }
        public void SetWeight(Float NewWeight) {
            Weight = NewWeight;
        }
        public void SetPrev(ListElement newElement) {
            Prev = newElement;
        }
        public void AddNext(ListElement NewElement) {
            Next = NewElement;
            NewElement.SetPrev(this);
        }
    }

    @Override
    public void CreateGraph(int NumberOfNodes, Float... Edges) {
        Length = NumberOfNodes;
        List = new ListElement[NumberOfNodes];
        int Counter = 1;
        int remember1 = 0;
        int remember2 = 0;
        for(Float i:Edges){
            switch (Counter){
                case 1: remember1 = i.intValue() ;
                case 2 : remember2 = i.intValue();
                case 3:{
                    ListElement NewConnection = new ListElement();
                    NewConnection.SetNode(remember2);
                    NewConnection.SetWeight(i);
                    if (List[remember1].Next!= null){
                        NewConnection.AddNext(List[remember1].Next);
                    }
                    List[remember1].AddNext(NewConnection);
                }
            }
            Counter++;
            if(Counter>3){
                Counter=1;
            }

        }
    }

    @Override
    public float GetWeight(int Node1, int Node2) {
        ListElement CurrentElement = List[Node1].Next;
        while(CurrentElement.Node!= Node2){
            if(CurrentElement.Next == null){
                return Float.POSITIVE_INFINITY;
            }
            else CurrentElement = CurrentElement.Next;
        }
        return CurrentElement.Weight;
    }

    @Override
    public void SetWeight(int Node1, int Node2, Float Weight) {
        if (GetWeight(Node1,Node2)== Float.POSITIVE_INFINITY){
            AddEdge(Node1,Node2,Weight);}
        else {
            ListElement CurrentElement = List[Node1].Next;
            while(CurrentElement.Node!= Node2){
                CurrentElement = CurrentElement.Next;
            }
            CurrentElement.SetWeight(Weight);
        }
        }


    @Override
    public void DeleteNode(int Node) {
        for(int i=0; i < Length; i++){
            ListElement CurrentElement = List[i];
            while (CurrentElement.Next!=null){
                if(CurrentElement.Next.Node>= Node){
                    CurrentElement.Next.Node--;
                }
            }
        }
        ListElement[] NewList = new ListElement[Length-1];
        for(int i=0; i < Node; i++){
            NewList[i].Next = List[i].Next;
        }
        for(int i=Node+1; i < Length; i++){
            NewList[i-1].Next = List[i].Next;
        }
        Length--;
        List = NewList;
    }

    @Override
    public void AddNode() {
        ListElement[] NewList = new ListElement[Length+1];
        for(int i=0; i < Length; i++){
            NewList[i].Next = List[i].Next;
        }
        Length++;
        List = NewList;
    }

    @Override
    public void AddEdge(int Node1, int Node2, Float Weight) {
        ListElement NewConnection = new ListElement();
        NewConnection.SetNode(Node2);
        NewConnection.SetWeight(Weight);
        if (List[Node1].Next!= null){
            NewConnection.AddNext(List[Node1].Next);
        }
        List[Node1].AddNext(NewConnection);
    }

    @Override
    public void ClearGraph() {
        Length=0;
        List=null;
    }
}
