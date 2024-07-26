package service.impl;

import domain.model.User;
import domain.repository.UserRepository;
import org.springframework.stereotype.Service;
import service.UserService;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepo;

    public UserServiceImpl(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public User findById(Long id) {
        return userRepo.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate) {
        if (userToCreate.getId() != null && userRepo.existsById(userToCreate.getId())) {
            throw new IllegalArgumentException("This user ID already exists");
        }
        return userRepo.save(userToCreate);
    }

    /*
    @Override
    public User create(User userToCreate) {
        if (userRepo.existsByAccountNumber(userToCreate.getAccountNumber().getNumber())) {
            throw new IllegalArgumentException("This account number already exists");
        }
        return userRepo.save(userToCreate);
    }
    */
}
