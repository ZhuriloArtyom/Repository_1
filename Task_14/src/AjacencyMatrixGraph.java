
public class AjacencyMatrixGraph implements Graph{
    int vertex;
    Float[][] Matrix;

    @Override
    public void CreateGraph(int NumberOfNodes, Float... Edges) {
        vertex = NumberOfNodes;
        Matrix = new Float[vertex][vertex];
        int Counter = 1;
        int remember1 = 0;
        int remember2 = 0;
        for(Float i:Edges){
            switch (Counter){
                case 1: remember1 = i.intValue() ;
                case 2 : remember2 = i.intValue();
                case 3:{ Matrix[remember1][remember2] = i;
                    Matrix[remember2][remember1] = i;}
            }
            Counter++;
            if(Counter>3){
                Counter=1;
            }

        }

        FillTheMatrix(Matrix);
}

    @Override
    public float GetWeight(int Node1, int Node2) {
        return Matrix[Node1][Node2];
    }

    @Override
    public void SetWeight(int Node1, int Node2, Float Weight) {
        Matrix[Node1][Node2] = Weight;
        Matrix[Node2][Node1] = Weight;
    }

    @Override
    public void DeleteNode(int Node) {
        for(int j = Node+1; j<vertex-1; j++){
            for(int i = 0; i<vertex-1; i++){
            Matrix[i][j-1] = Matrix[i][j];
            Matrix[j-1][i] = Matrix[j][i];
            }}
         Float[][] NewMatrix = new Float[vertex-1][vertex-1];
        for(int j = 0; j<vertex-2; j++){
            for(int i = 0; i<vertex-2; i++){
                NewMatrix[i][j]= Matrix[i][j];
                NewMatrix[j][i]= Matrix[j][i];
            }
        }
        Matrix = NewMatrix;
        vertex--;
    }

    @Override
    public void AddNode() {
        Float[][] NewMatrix = new Float[vertex+1][vertex+1];
        for(int j = 0; j<vertex-1; j++){
            for(int i = 0; i<vertex-1; i++){
                NewMatrix[i][j]= Matrix[i][j];
                NewMatrix[j][i]= Matrix[j][i];
            }
        }
         for(int j = 0; j<vertex; j++){
             NewMatrix[j][vertex+1] = Float.POSITIVE_INFINITY;
             NewMatrix[vertex+1][j] = Float.POSITIVE_INFINITY;
         }
         Matrix = NewMatrix;
         vertex++;
    }

    @Override
    public void AddEdge(int Node1, int Node2, Float Weight) {
        SetWeight(Node1,Node2,Weight);
    }

    @Override
    public void ClearGraph() {
        vertex = 0;
        Matrix = null;
    }

    public void FillTheMatrix(Float[][] Matrix){
        for(int j = 0; j<vertex-1; j++){
            for(int i = 0; i<vertex-1; i++){
                if (Matrix[j][i] == null){
                    Matrix[j][i] =  Float.POSITIVE_INFINITY;
                }
            }
            }
    }

}
