package com.obj.meeting.controller;

import com.obj.meeting.domain.Meeting;
import com.obj.meeting.service.MeetingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


// Test Commit

@Controller
public class MeetingController {

    private final MeetingService meetingService;

    public MeetingController(MeetingService meetingService) {
        this.meetingService = meetingService;
    }

    @GetMapping("/meetings")
    public String listMeetings(Model model) {
        model.addAttribute("meetings", meetingService.findAll());
        return "meetings";
    }

    @GetMapping("/meetings/new")
    public String showMeetingForm(Model model) {
        model.addAttribute("meeting", new Meeting());
        return "meeting-form";
    }

    @PostMapping("/meetings")
    public String createMeeting(Meeting meeting) {
        meetingService.save(meeting);
        return "redirect:/meetings";
    }

    @GetMapping("/meetings/{id}")
    public String showMeetingDetails(@PathVariable Long id, Model model) {
        Meeting meeting = meetingService.findById(id);
        model.addAttribute("meeting", meeting);
        return "meeting-detail";
    }

    @GetMapping("/meetings/{id}/edit")
    public String showUpdateForm(@PathVariable Long id, Model model) {
        Meeting meeting = meetingService.findById(id);
        model.addAttribute("meeting", meeting);
        return "meeting-form";
    }

    @PostMapping("/meetings/{id}/update")
    public String updateMeeting(@PathVariable Long id, Meeting meeting) {
        meeting.setId(id);
        meetingService.save(meeting);
        return "redirect:/meetings/" + id;
    }

    @PostMapping("/meetings/{id}/delete")
    public String deleteMeeting(@PathVariable Long id) {
        meetingService.deleteById(id);
        return "redirect:/meetings";
    }
}
