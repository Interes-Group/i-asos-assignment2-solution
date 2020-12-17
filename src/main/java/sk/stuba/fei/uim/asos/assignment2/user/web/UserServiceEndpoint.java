package sk.stuba.fei.uim.asos.assignment2.user.web;

import sk.stuba.fei.uim.asos.assignment2.user.service.UserService;
import sk.stuba.fei.uim.asos.assignment2.ws.*;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

@WebService(name = "UserServicePortType", targetNamespace = "user-service", serviceName = "UserService")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
        ObjectFactory.class
})
public class UserServiceEndpoint implements UserServicePortType {

    private final UserService userService;

    public UserServiceEndpoint() {
        this.userService = new UserService();
    }

    public UserServiceEndpoint(UserService userService) {
        this.userService = userService;
    }

    @Override
    @WebMethod
    @WebResult(name = "users", targetNamespace = "users", partName = "body")
    public Users all() {
        Users users = new Users();
        users.getUser().addAll(this.userService.getAll());
        return users;
    }

    @Override
    @WebMethod
    @WebResult(name = "user", targetNamespace = "users", partName = "body")
    public User one(@WebParam(name = "user_id", targetNamespace = "users", partName = "parameter") long userId) {
        return this.userService.getOne(userId);
    }

    @Override
    @WebMethod
    @WebResult(name = "user", targetNamespace = "users", partName = "body")
    public User add(@WebParam(name = "user_without_id", targetNamespace = "users", partName = "parameter") UserWithoutId user) {
        return this.userService.add(user);
    }

    @Override
    @WebMethod
    @WebResult(name = "user", targetNamespace = "users", partName = "body")
    public User update(@WebParam(name = "user", targetNamespace = "users", partName = "parameter") User user) {
        return this.userService.update(user);
    }
}
