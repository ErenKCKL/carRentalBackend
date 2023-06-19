package ashina.carrental.business.concretes.usersManagers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ashina.carrental.business.abstracts.userServices.UsersService;
import ashina.carrental.dataAccess.abstracts.UsersDaos.UsersDao;
import ashina.carrental.entities.concretes.users.Users;

@Service
public class UsersManager implements UsersService {

    @Autowired
    private UsersDao usersDao;

    @Override
    public List<Users> getAllUsers() {
        return usersDao.findAll();
    }

}
