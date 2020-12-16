package sk.stuba.fei.uim.asos.assignment2.user.web;

import sk.stuba.fei.uim.asos.assignment2.user.service.UserService;
import sk.stuba.fei.uim.asos.assignment2.ws.ObjectFactory;
import sk.stuba.fei.uim.asos.assignment2.ws.User;
import sk.stuba.fei.uim.asos.assignment2.ws.UserServicePortType;
import sk.stuba.fei.uim.asos.assignment2.ws.Users;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Holder;

@WebService(name = "UserServicePortType", targetNamespace = "users", serviceName = "UserService")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({ObjectFactory.class})
public class UserServicePort implements UserServicePortType {

    private final UserService userService;

    public UserServicePort(UserService userService) {
        this.userService = userService;
    }

    @Override
    public Users getAll() {
        Users users = new Users();
        users.getUser().addAll(this.userService.getAll());
        return users;
    }

    @Override
    public User getOne(long userId) {
        return this.userService.getOne(userId);
    }

    @Override
    public void add(Holder<User> user) {
        this.userService.add(user.value);
    }

    @Override
    public void update(Holder<User> user) {
        this.userService.update(user.value);
    }
}
