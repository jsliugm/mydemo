package com.map;

import java.util.HashMap;
import java.util.Map;

public class ManagedMap {
    private Map<String, ManagedObject> innerMap = new HashMap();
    private Map<Object, ManagedObject> idMap = new HashMap<>();

    public void put(final String key, IdObject value) {
        ManagedObject managedObject = new ManagedObject(value) {
            @Override
            void remove() {
                innerMap.remove(key);
                idMap.remove(value.getId());
            }
        };
        innerMap.put(key, managedObject);
        idMap.put(value.getId(), managedObject);
    }

    public Object get(String key) {
        return innerMap.get(key).getValue();
    }

    public void remove(Object id){
        idMap.get(id).remove();
    }

    public static void main(String[] args) {
        ManagedMap map = new ManagedMap();
        map.put("aaa", new Student("id", "zhangsan"));
        map.remove("id");

        System.out.println("xxxx");
    }

}
