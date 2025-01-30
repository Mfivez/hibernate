package jpaPark.repository;

import jpaPark.models.User;

public class UserRepository extends CrudRepository<User, Long> {
    public UserRepository() {
        super(User.class);
    }
}
