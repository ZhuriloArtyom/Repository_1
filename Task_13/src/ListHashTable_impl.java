public class ListHashTable_impl implements ListHashTable{
    int n;
    TableElement[] Table;
    public ListHashTable_impl(int n){
        this.n = n;
        this.Table = new TableElement[n];
    }
    public class TableElement{
        TableElement Next;
        TableElement Prev;
        int Key;
        String Value;
        void Add(int key, String value){
            if(Value==null){
                Value = value;
                Key = key;
            }
            else if(Next== null){
                Next = new TableElement();
                Next.Prev = this;

            }
            Next.Add(key, value);

        }
        String get(int key){
            if (key == Key){return Value;}
            else {return Next.get(key);}
        }
        void remove(int key){
            if (Key==key){
                if (Prev==null){
                    Table[key% n] = Next;
                }
                else{
                    Next.Prev= Prev;
                    Prev.Next=Next;
                }
            }
            else{Next.remove(key);}
        }
    }

    @Override
    public void Add(int key, String value) {
        Table[key% n].Add(key, value);
    }

    @Override
    public String GetValue(int key) {

        return Table[key% n].get(key);
    }

    @Override
    public void Delete(int key) {
        int ProcessedKey = key% n;

    }


}
