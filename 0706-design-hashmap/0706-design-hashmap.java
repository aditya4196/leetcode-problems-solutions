class MyHashMap {
    
    int key_spaces;
    Bucket[] keymap;
    public MyHashMap() {
        key_spaces = 2069;
        keymap = new Bucket[key_spaces];
    }
    
    public void put(int key, int value) {
        int hashed_key = key % key_spaces;
        if(keymap[hashed_key] == null){
            keymap[hashed_key] = new Bucket();
            keymap[hashed_key].update(key, value);
        }
        else{
            Bucket currBucket = keymap[hashed_key];
            currBucket.update(key, value);
        }
    }
    
    public int get(int key) {
        int hashed_key = key % key_spaces;
        if(keymap[hashed_key] == null) return -1;
        else return keymap[hashed_key].get(key);
    }
    
    public void remove(int key) {
        int hashed_key = key % key_spaces;
        if(keymap[hashed_key] == null) return;
        else keymap[hashed_key].remove(key);
    }
}

class Bucket{
    List<Pair<Integer,Integer>> bucket;
    public Bucket(){
        bucket = new LinkedList<Pair<Integer,Integer>>();
    }
    
    public int get(int key){
        System.out.println(key);
        for(Pair<Integer,Integer> pair : bucket){
            if(pair.getKey() == key){
                return pair.getValue();
            }
        }
        return -1;
    }

    
    public void update(int key, int value){
        boolean found = false;
        
        for(Pair<Integer,Integer> pair : bucket){
            if(pair.getKey() == key){
                found = true;
                Pair<Integer,Integer> newpair = new Pair<Integer,Integer>(key, value);
                bucket.remove(pair);
                bucket.add(newpair);
                break;
            }
        }
        if(!found) bucket.add(new Pair<Integer,Integer>(key, value));
    }
    
    public void remove(int key){
        for(Pair<Integer,Integer> pair : bucket){
            if(pair.getKey() == key){
                bucket.remove(pair);
                break;
            }
        }
    }
    
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */