public class OffsetHashTable_impl implements OffsetHashTable{
    int n;
    Element[] Table;
    int step;
    public OffsetHashTable_impl(int n, int step){
        this.n = n;
        this.step = step;
        this.Table = new Element[n];
    }


    private class Element{
      int Key;
      int nKey;
      String Value;
      public Element(int key, int nKey, String value){
          this.nKey=nKey;
          this.Value =value;
          this.Key=key;
      }
    }

    public void IterationOfAdd(int key, int Position, String value){
        if (Table[Position] == null){
            Table[Position] = new Element(key, key%n, value);
        }
        else if(Position+step<n){
            IterationOfAdd(key, Position+step, value);
        }
    }
    @Override
    public void Add(int key, String value) {
        IterationOfAdd(key, key% n, value);
    }

    @Override
    public String GetValue(int key) {
        int searched = key% n;
        while (true){
            if (Table[searched].Key == key){
                return Table[searched].Value;
            }
            else if(Table[searched+step] == null) {
                return null;
            }
            else {searched = searched+step;}
        }
    }

    @Override
    public void Delete(int key) {
        int searched = key % n;
        int remember = searched;
        while (true) {
            if (Table[searched].Key == key) {
                int current = searched;
                Table[current] = null;
                int remember2 = current;
                for (int i = current + step; i < n - 1; i = i + step) {
                    if (Table[i].nKey <= remember) {
                        Table[remember2] = Table[i];
                        Table[i] = null;
                        remember2 = i;
                        return;
                    }
                }
            } else {
                searched = searched + step;
            }
        }
    }
}



