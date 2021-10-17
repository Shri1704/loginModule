package com.example.Login.mapper;

import com.example.Login.dto.AddressDto;
import com.example.Login.dto.UserDto;
import com.example.Login.entity.UsersEntity;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-10-17T14:25:34+0530",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UsersEntity MapUserDtoToUserEntityMapper(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        UsersEntity usersEntity = new UsersEntity();

        usersEntity.setAddress( userDtoAddressAddress( userDto ) );
        usersEntity.setStreet( userDtoAddressStreet( userDto ) );
        usersEntity.setCity( userDtoAddressCity( userDto ) );
        usersEntity.setState( userDtoAddressState( userDto ) );
        usersEntity.setCountry( userDtoAddressCountry( userDto ) );
        usersEntity.setPostalCode( userDtoAddressPostalCode( userDto ) );
        usersEntity.setUserId( userDto.getUserId() );
        usersEntity.setName( userDto.getName() );
        usersEntity.setUserName( userDto.getUserName() );
        usersEntity.setPassword( userDto.getPassword() );
        usersEntity.setAge( userDto.getAge() );
        usersEntity.setEmail( userDto.getEmail() );
        usersEntity.setPhoneNumber( userDto.getPhoneNumber() );

        return usersEntity;
    }

    @Override
    public UserDto MapUserEntityToUserDtoMapper(UsersEntity usersEntity) {
        if ( usersEntity == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setAddress( usersEntityToAddressDto( usersEntity ) );
        userDto.setUserId( usersEntity.getUserId() );
        userDto.setName( usersEntity.getName() );
        userDto.setAge( usersEntity.getAge() );
        userDto.setEmail( usersEntity.getEmail() );
        userDto.setPhoneNumber( usersEntity.getPhoneNumber() );
        userDto.setUserName( usersEntity.getUserName() );
        userDto.setPassword( usersEntity.getPassword() );

        return userDto;
    }

    private String userDtoAddressAddress(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }
        AddressDto address = userDto.getAddress();
        if ( address == null ) {
            return null;
        }
        String address1 = address.getAddress();
        if ( address1 == null ) {
            return null;
        }
        return address1;
    }

    private String userDtoAddressStreet(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }
        AddressDto address = userDto.getAddress();
        if ( address == null ) {
            return null;
        }
        String street = address.getStreet();
        if ( street == null ) {
            return null;
        }
        return street;
    }

    private String userDtoAddressCity(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }
        AddressDto address = userDto.getAddress();
        if ( address == null ) {
            return null;
        }
        String city = address.getCity();
        if ( city == null ) {
            return null;
        }
        return city;
    }

    private String userDtoAddressState(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }
        AddressDto address = userDto.getAddress();
        if ( address == null ) {
            return null;
        }
        String state = address.getState();
        if ( state == null ) {
            return null;
        }
        return state;
    }

    private String userDtoAddressCountry(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }
        AddressDto address = userDto.getAddress();
        if ( address == null ) {
            return null;
        }
        String country = address.getCountry();
        if ( country == null ) {
            return null;
        }
        return country;
    }

    private String userDtoAddressPostalCode(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }
        AddressDto address = userDto.getAddress();
        if ( address == null ) {
            return null;
        }
        String postalCode = address.getPostalCode();
        if ( postalCode == null ) {
            return null;
        }
        return postalCode;
    }

    protected AddressDto usersEntityToAddressDto(UsersEntity usersEntity) {
        if ( usersEntity == null ) {
            return null;
        }

        AddressDto addressDto = new AddressDto();

        addressDto.setAddress( usersEntity.getAddress() );
        addressDto.setStreet( usersEntity.getStreet() );
        addressDto.setCity( usersEntity.getCity() );
        addressDto.setState( usersEntity.getState() );
        addressDto.setCountry( usersEntity.getCountry() );
        addressDto.setPostalCode( usersEntity.getPostalCode() );

        return addressDto;
    }
}
