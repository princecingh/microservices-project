// Java
package com.lcwd.user.service.external.services;

import com.lcwd.user.service.entities.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name="RATINGSERVICE")
public interface RatingService {

    // Create a rating
    @PostMapping("/ratings")
    Rating createRating(@RequestBody Rating rating);

    // Get single rating by ratingId
    @GetMapping("/ratings/{ratingId}")
    Rating getRating(@PathVariable String ratingId);

    // Get all ratings for a user
    @GetMapping("/ratings/users/{userId}")
    List<Rating> getRatingsByUser(@PathVariable String userId);

    // Update a rating
    @PutMapping("/ratings/{ratingId}")
    Rating updateRating(@PathVariable String ratingId, @RequestBody Rating rating);
}
