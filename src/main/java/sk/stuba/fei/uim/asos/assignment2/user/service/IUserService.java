package sk.stuba.fei.uim.asos.assignment2.user.service;

import sk.stuba.fei.uim.asos.assignment2.ws.User;
import sk.stuba.fei.uim.asos.assignment2.ws.UserWithoutId;

import java.util.List;

/**
 * Interface pre Spring service spravujúcu používateľov
 */
public interface IUserService {

    User add(UserWithoutId user);

    User update(User user);

    List<User> getAll();

    User getOne(Long id);

}
