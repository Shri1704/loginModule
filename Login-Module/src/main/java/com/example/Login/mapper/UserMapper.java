package com.example.Login.mapper;

import com.example.Login.dto.UserDto;
import com.example.Login.entity.UsersEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mappings({
            @Mapping(target ="address",source = "userDto.address.address"),
            @Mapping(target ="street",source = "userDto.address.street"),
            @Mapping(target ="city",source = "userDto.address.city"),
            @Mapping(target ="state",source = "userDto.address.state"),
            @Mapping(target ="country",source = "userDto.address.country"),
            @Mapping(target ="postalCode",source = "userDto.address.postalCode")
    })
    UsersEntity MapUserDtoToUserEntityMapper(UserDto userDto);
    @Mappings({
            @Mapping(source ="usersEntity.address",target = "address.address"),
            @Mapping(source ="usersEntity.street",target = "address.street"),
            @Mapping(source ="usersEntity.city",target = "address.city"),
            @Mapping(source ="usersEntity.state",target = "address.state"),
            @Mapping(source ="usersEntity.country",target = "address.country"),
            @Mapping(source ="usersEntity.postalCode",target = "address.postalCode")
    })
    UserDto MapUserEntityToUserDtoMapper(UsersEntity usersEntity);

    default List<UserDto>MapUserEntityToUserDtoMapper(List<UsersEntity> entityList){
        List<UserDto> userDtoList= new ArrayList<>();
        for(UsersEntity usersEntity:entityList){
            userDtoList.add(MapUserEntityToUserDtoMapper(usersEntity));
        }
        return userDtoList;
    }
}
