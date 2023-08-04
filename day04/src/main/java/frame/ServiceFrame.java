package frame;

import java.util.List;

public interface ServiceFrame<K, V> {
    // dao 와 service 의 메서드 이름의 차이가 특징
    int register(V v) throws Exception;

    int modify(V v) throws Exception;

    int remove(K k) throws Exception;

    V get(K k) throws Exception;

    List<V> get() throws Exception; // 오버로딩
}
