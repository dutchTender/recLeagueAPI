package li.zhang.app.model.base;


import java.util.List;

public interface BaseDTOMapper<T, K>{
    K toDTO(T entity);
    T toEntity(K dto);
    List<K> toDTOList(List<T> entityList);
    List<T> toEntityList(List<K> dtoList);
}
