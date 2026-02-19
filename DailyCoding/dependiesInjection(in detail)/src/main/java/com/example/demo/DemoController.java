package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    // Defined fields using camelCase (standard Java naming convention)
    private final Coach basketballCoach;
    private final Coach basketballCoach2;
    private final Coach trackCoach;
    private final Coach trackCoach2;
    private final Coach swimCoach;

    @Autowired
    public DemoController(
            @Qualifier("basketballCoach") Coach theBasketballCoach,
            @Qualifier("basketballCoach") Coach theBasketballCoach2,
            @Qualifier("trackCoach") Coach theTrackCoach,
            @Qualifier("trackCoach") Coach theTrackCoach2,
            @Qualifier("swimCoach") Coach theSwimCoach) {
        
        // Assigning injected beans to local fields
        this.basketballCoach = theBasketballCoach;
        this.basketballCoach2 = theBasketballCoach2;
        this.trackCoach = theTrackCoach;
        this.trackCoach2 = theTrackCoach2;
        this.swimCoach = theSwimCoach;
    }
    // Endpoint to get daily workout from the swim coach by using the injected swimCoach bean with cofigured name "swimCoach"
    @GetMapping("/workout")
    public String getDailyWorkout() {
        return swimCoach.getDailyWorkout();
    }

    /**
     * If basketballCoach is defined as @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE),
     * this will return false because a new instance is created for every injection.
     */
    @GetMapping("/checkPrototype")
    public String checkPrototype() {
        return "Comparing basketball coaches: " + (basketballCoach == basketballCoach2);
    }

    /**
     * By default, Spring beans are Singletons. This should return true 
     * as both variables point to the same object instance in memory.
     */
    @GetMapping("/checkSingleton")
    public String checkSingleton() {
        return "Comparing track coaches: " + (trackCoach == trackCoach2);
    }
}