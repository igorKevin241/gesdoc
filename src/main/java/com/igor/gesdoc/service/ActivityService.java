package com.igor.gesdoc.service;

import com.igor.gesdoc.entity.Activity;
import com.igor.gesdoc.entity.User;
import com.igor.gesdoc.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityService {
    private final ActivityRepository activityRepository;

    @Autowired
    public ActivityService(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }
    public List<Activity> getAllActivities() {
        return activityRepository.findAll();
    }
    public Activity getActivityById(Long activityId) {
        return activityRepository.findById(activityId)
                .orElseThrow(() -> new RuntimeException("Utilisateur non enregistré !"));
    }

    public Activity createActivity(Activity activity) {
        return activityRepository.save(activity);
    }

    public Activity updateActivity(Long activityId, Activity activity) {
        Activity activityUpdated = activityRepository.findById(activityId)
                .orElseThrow(() -> new RuntimeException("Utilisateur non enregistré !"));
        activityUpdated.setLibelle(activity.getLibelle());

        return activityRepository.save(activityUpdated);
    }

    public String deleteActivityById(Long activityId) {
        activityRepository.findById(activityId)
                .orElseThrow(() -> new RuntimeException("Utilisateur non enregistré !"));
        activityRepository.deleteById(activityId);
        return "Le service ID : "+activityId+" a été supprimé !";
    }
}
