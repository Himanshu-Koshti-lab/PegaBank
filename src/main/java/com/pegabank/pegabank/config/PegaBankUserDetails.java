package com.pegabank.pegabank.config;


//
//Core interface which loads user-specific data.
//        It is used throughout the framework as a user DAO and is the strategy used by the DaoAuthenticationProvider.

//
//import com.pegabank.pegabank.model.Person;
//import com.pegabank.pegabank.repository.PersonRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class PegaBankUserDetails implements UserDetailsService {
//
//    @Autowired
//    PersonRepository personRepository;
//
//    //    Custom method to load table data and validate it
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//        String userName, password = null;
//        List<GrantedAuthority> authorities = null;
//        List<Person> personList = personRepository.findByEmail(username);
//        if (personList.isEmpty()) {
//            throw new UsernameNotFoundException(username + "Not Found");
//        } else {
//            userName = personList.get(0).getName();
//            password = personList.get(0).getPassword();
//            authorities = new ArrayList<>();
//            authorities.add(new SimpleGrantedAuthority(personList.get(0).getRole()));  /*Loading roles*/
//        }
//
//        return new User(userName, password, authorities);
//    }
//}
