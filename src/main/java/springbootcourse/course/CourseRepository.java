package springbootcourse.course;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course, String> {

    public List<Course> findByTopicId(String topiId);
    public List<Course> findByName(String name);
    public List<Course> findByDescription(String description);


}
