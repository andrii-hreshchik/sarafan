package letscode.sarafan.repository;


import letscode.sarafan.model.Message;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MessageRepository extends MongoRepository<Message, String> {

    @Override
    <S extends Message> S save(S entity);

    @Override
    Optional<Message> findById(String id);

    @Override
    void deleteById(String id);

    @Override
    List<Message> findAll();


}
