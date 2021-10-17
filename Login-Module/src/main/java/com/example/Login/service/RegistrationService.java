package com.example.Login.service;

import com.example.Login.dao.UserRepository;
import com.example.Login.dto.UserDto;
import com.example.Login.entity.UsersEntity;
import com.example.Login.exception.LoginModuleException;
import com.example.Login.mapper.UserMapper;
import com.example.Login.utils.EmailSenderDto;
import com.example.Login.utils.EmailUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

@Service
public class RegistrationService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    public String registerUser(UserDto userDto) {
        if (userRepository.findByUserName(userDto.getUserName()).isPresent()) {
            throw new LoginModuleException(userDto.getUserName() + " already exists");
        }
        Integer otp=otpGeneration(userDto, null);
        EmailSenderDto emailSenderDto= new EmailSenderDto();
        emailSenderDto.setEmailTo(userDto.getEmail());
        emailSenderDto.setEmailBody("HELLO, OTP FOR ACTIVATION:"+otp);
        emailSenderDto.setEmailSubject("USER Registration");
        emailSenderDto.setEmailName(userDto.getName());
        EmailUtils.sendMail(emailSenderDto);
        return "User created successfully, Activation pending!";
    }

    public List<UserDto> getAllRegisterUsers() {
        return userMapper.MapUserEntityToUserDtoMapper(userRepository.findAll());
    }

    private Integer otpGeneration(UserDto userDto, String password) {
        Random otpGenerator = new Random();
        int otp = otpGenerator.nextInt(999999);
        UsersEntity usersEntity = userMapper.MapUserDtoToUserEntityMapper(userDto);
        usersEntity.setActive(false);
        usersEntity.setVerifier(otp);
        if (password == null || password.isEmpty()) {
            usersEntity.setUserId(UUID.randomUUID());
            usersEntity.setPassword(passwordEncoder.encode(userDto.getPassword()));
        } else {
            usersEntity.setPassword(passwordEncoder.encode(password));
        }
        userRepository.save(usersEntity);
        return otp;
    }

    public UserDto getUserDetails() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String userName;
        if (principal instanceof UserDetails) {
            userName = ((UserDetails) principal).getUsername();
        } else {
            userName = principal.toString();
        }
        Optional<UsersEntity> usersEntityOptional = userRepository.findByUserName(userName);
        if (usersEntityOptional.isPresent()) {
            return userMapper.MapUserEntityToUserDtoMapper(userRepository.findByUserName(userName).get());
        } else {
            throw new UsernameNotFoundException("user not found");
        }

    }

    public String activateAccount(Integer otp, String userName) {
        Optional<UsersEntity> usersEntityOptional = userRepository.findByUserName(userName);
        if (usersEntityOptional.isPresent()) {
            UsersEntity usersEntity = usersEntityOptional.get();
            if (usersEntity.getVerifier().equals(otp)) {
                usersEntity.setActive(true);
                userRepository.save(usersEntity);
                return "Account Activated";
            } else {
                throw new LoginModuleException("OTP doesn't match");
            }
        } else {
            throw new UsernameNotFoundException("user not found");
        }
    }

    public String forgetPassword(String userName) {

        Optional<UsersEntity> usersEntityOptional = userRepository.findByUserName(userName);
        if(usersEntityOptional.isPresent() && usersEntityOptional.get().isActive()){
            UserDto userDto= userMapper.MapUserEntityToUserDtoMapper(usersEntityOptional.get());
            Integer otp= otpGeneration(userDto, LocalDateTime.now().toString());
            EmailSenderDto emailSenderDto= new EmailSenderDto();
            emailSenderDto.setEmailTo(userDto.getEmail());
            emailSenderDto.setEmailBody("HELLO, OTP FOR ACTIVATION:"+otp);
            emailSenderDto.setEmailSubject("USER Registration");
            emailSenderDto.setEmailName(userDto.getName());
            EmailUtils.sendMail(emailSenderDto);
        return "Password reseted, check otp in registered email address";
        }else if(usersEntityOptional.isPresent() && !usersEntityOptional.get().isActive())
        {
            throw new LoginModuleException("Account not activated");
        }else{
            throw new LoginModuleException("user not found");
        }
    }

    public UserDto updateUserDetails(UserDto userDto) {
        UserDto loggedInUserDetails = getUserDetails();
        if (userDto.getUserName() != loggedInUserDetails.getUserName()) {
            throw new LoginModuleException("Logged username doesn't match with request body");
        } else if (!userDto.getName().equals(loggedInUserDetails.getUserName()) || !userDto.getPhoneNumber().equals(loggedInUserDetails.getPhoneNumber())) {
            throw new LoginModuleException("Name/Phone number are not updatable");
        } else {
            UsersEntity usersEntity = userMapper.MapUserDtoToUserEntityMapper(userDto);
            return userMapper.MapUserEntityToUserDtoMapper(userRepository.save(usersEntity));

        }
    }

    public String resetPassword(Integer otp, String userName, String password) {
        Optional<UsersEntity> usersEntityOptional = userRepository.findByUserName(userName);
        if (usersEntityOptional.isPresent()) {
            UsersEntity usersEntity = usersEntityOptional.get();
            if (usersEntity.getVerifier().equals(otp)) {
                usersEntity.setActive(true);
                usersEntity.setPassword(passwordEncoder.encode(password));
                userRepository.save(usersEntity);
                return "Password changed ";
            } else {
                throw new LoginModuleException("OTP doesn't match");
            }
        } else if(usersEntityOptional.isPresent() && !usersEntityOptional.get().isActive()){
            throw new LoginModuleException("Account not activated");
        }else {
            throw new UsernameNotFoundException("user not found");
        }
    }
}
