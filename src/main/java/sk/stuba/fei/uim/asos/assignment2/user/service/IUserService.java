package sk.stuba.fei.uim.asos.assignment2.user.service;

import sk.stuba.fei.uim.asos.assignment2.ws.User;

import java.util.List;

/**
 * Interface pre Spring service spravujúcu používateľov
 */
public interface IUserService {

    User add(User user);

    User update(User user);

    List<User> getAll();

    User getOne(Long id);

}
