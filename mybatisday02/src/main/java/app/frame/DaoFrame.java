package app.frame;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

public interface DaoFrame<K, V> {
    // dao 와 service 의 메서드 이름의 차이가 특징
    int insert(V v, SqlSession session) throws Exception;  // SqlSession 은 트랜잭션 처리를 위해 넣어준다

    int update(V v, SqlSession session) throws Exception;

    int delete(K k, SqlSession session )throws Exception;

    V select(K k, SqlSession session) throws Exception;

    List<V> select(SqlSession session) throws Exception; // 오버로딩
}
