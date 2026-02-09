package com.lcwd.user.service.services;

import com.lcwd.user.service.entities.Hotel;
import com.lcwd.user.service.entities.Rating;
import com.lcwd.user.service.entities.User;
import com.lcwd.user.service.exceptions.ResourceNotFoundException;
import com.lcwd.user.service.external.services.HotelService;
import com.lcwd.user.service.external.services.RatingService;
import com.lcwd.user.service.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelService hotelService;

    @Autowired
    private RatingService ratingService;

    @Override
    public User saveUser(User user) {
        // Generate unique user id
        String randomUserId = UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        // Save user to database
        User savedUser = userRepository.save(user);
        if(savedUser != null){
            return savedUser;
        }
        return null;
    }

    @Override
    public User getUser(String userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User with given id not found on server !! : " + userId));


        // http://localhost:8083/ratings/users/8e7ba12f-4728-4187-af24-2569ad19655f
//       ArrayList<Rating> ratings  = restTemplate.getForObject("http://localhost:8083/ratings/users/" + user.getUserId(), ArrayList.class);
//       //  user.setRatings(ratings);
//
//      For each rating, fetch hotel details and set it
//        for (Rating rating : ratings) {
//            Hotel hotel = restTemplate.getForObject("http://localhost:8082/hotels/" + rating.getHotelId(), Hotel.class);
//            rating.setHotel(hotel);
//        }
//        user.setRatings(ratings);


        // Fetch ratings as an array of Rating
//        Rating[] ratingsArray = restTemplate.getForObject(
//                "http://RATINGSERVICE/ratings/users/" + user.getUserId(),
//                Rating[].class
//        );
//        List<Rating> ratings = ratingsArray != null ? List.of(ratingsArray) : new ArrayList<>();

        List<Rating> ratings = new ArrayList<>();
        try {
            ratings = ratingService.getRatingsByUser(user.getUserId());
        } catch (feign.FeignException e) {

        }

        // For each rating, fetch hotel details and set it
        for (Rating rating : ratings) {
          //  Hotel hotel = restTemplate.getForObject("http://HOTELSERVICE/hotels/" + rating.getHotelId(), Hotel.class);

            Hotel hotel = hotelService.getHotel(rating.getHotelId());

            //System.out.println("Hotel fetched: " + hotel);

            rating.setHotel(hotel);

        }

        user.setRatings(ratings);
        if(user != null){
            return user;
        }
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = userRepository.findAll();
        if(users != null && !users.isEmpty()){
            return users;
        }
        return List.of();
    }
}
