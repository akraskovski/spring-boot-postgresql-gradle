package by.kraskovski.converter;

import by.kraskovski.dto.UserDTO;
import by.kraskovski.model.User;
import org.springframework.stereotype.Component;

@Component
public final class UserConverter {
    public User DTOtoUser(UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        return user;
    }

    public UserDTO userToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(user.getPassword());
        return userDTO;
    }
}
