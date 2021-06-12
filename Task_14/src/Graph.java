public interface Graph {
    void  CreateGraph(int NumberOfNodes,  Float... Edges);
    float GetWeight(int Node1, int Node2);
    void SetWeight(int Node1, int Node2, Float Weight);
    void DeleteNode(int Node);
    void AddNode();
    void AddEdge(int Node1, int Node2, Float Weight );
    void ClearGraph();
    void DeleteEdge(int Node1, int Node2);
}
