package frame;

import java.util.List;

public interface ServiceFrame<K, V> {
    // dao 와 service 의 메서드 이름의 차이가 특징
    void register(V v);

    void modify(V v);

    void remove(K k);

    V get(K k);

    List<V> get(); // 오버로딩
}
