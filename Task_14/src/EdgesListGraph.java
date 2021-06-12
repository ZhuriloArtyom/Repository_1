
public class EdgesListGraph implements  Graph{
    Float[][] List;
    int Length;

    @Override
    public void CreateGraph(int NumberOfNodes, Float... Edges) {
        Length=0;
        for(Float i:Edges){
        Length++;}
        List = new Float[Length][3];
        int Counter = 1;
        int Clock =0;
        Float remember1 = Float.valueOf(0);
        Float remember2= Float.valueOf(0);
        for(Float i:Edges){
            switch (Counter){
                case 1: remember1 = i ;
                case 2 : remember2 = i;
                case 3:{ List[Clock][1] =  remember1;
                        List[Clock][2] =  remember2;
                        List[Clock][3] = i;
                        Clock++;
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
        for(int i=0; i < Length;i++ ){
            if (List[i][1]==Node1&&List[i][2]==Node2){
                return List[i][3];
            }
        }
        return Float.POSITIVE_INFINITY;
    }

    @Override
    public void SetWeight(int Node1, int Node2, Float Weight) {
        for(int i=0; i < Length;i++ ){
            if (List[i][1]==Node1&&List[i][2]==Node2){
                List[i][3] = Weight;
                return;
            } }
        AddEdge(Node1,Node2,Weight);
    }

    @Override
    public void DeleteNode(int Node) {
        for(int i=0; i<Length;i++){
            if((List[i][1].equals(Float.valueOf(Node)))||(List[i][2].equals(Float.valueOf(Node)))){
                DeleteEdge(List[i][1].intValue(), List[i][2].intValue());
            }
        }
    }

    @Override
    public void AddNode() { }

    @Override
    public void AddEdge(int Node1, int Node2, Float Weight) {
        Float[][] NewList = new Float[Length+1][3];
        for(int i = 0; i< Length; i++){
            NewList[i][1]= List[i][1];
            NewList[i][2]= List[i][2];
            NewList[i][3]= List[i][3];
        }
        NewList[Length][1]= Float.valueOf(Node1);
        NewList[Length][2]= Float.valueOf(Node2);
        NewList[Length][3]= Weight;
        List =NewList;
        Length++;
    }

    @Override
    public void ClearGraph() {
        Length=0;
        List=null;
    }

    @Override
    public void DeleteEdge(int Node1, int Node2) {
        Float[][] NewList = new Float[Length-1][3];
        for(int i=0; i < Length;i++ ){
            if (List[i][1]==Node1&&List[i][2]==Node2){
                for (int j =i+1; j< Length; j++){
                    NewList[j-1][1]= List[j][1];
                    NewList[j-1][2]= List[j][2];
                    NewList[j-1][3]= List[j][3];
                }
            } }
        List =NewList;
        Length--;
    }
}
