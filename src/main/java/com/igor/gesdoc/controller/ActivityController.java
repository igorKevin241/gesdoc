package com.igor.gesdoc.controller;

import com.igor.gesdoc.entity.Activity;
import com.igor.gesdoc.entity.User;
import com.igor.gesdoc.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/service")
public class ActivityController {
    private final ActivityService activityService;

    @Autowired
    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }
    @GetMapping("get-all")
    public List<Activity> getAllActivities(){
        return activityService.getAllActivities();
    }
    @GetMapping("{activityId}")
    public Activity getActivityById(@PathVariable Long activityId){
        return activityService.getActivityById(activityId);
    }

    @PostMapping("create")
    public Activity createActivity(@RequestBody Activity activity){
        return activityService.createActivity(activity);
    }

    @PutMapping("{activityId}")
    public Activity updateActivity(@PathVariable Long activityId, @RequestBody Activity activity){
        return activityService.updateActivity(activityId, activity);
    }
    @DeleteMapping("{activityId}")
    public String deleteActivityById(@PathVariable Long activityId){
        return activityService.deleteActivityById(activityId);
    }
}
