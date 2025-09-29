package com.obj.meeting.service;

import com.obj.meeting.domain.Meeting;
import com.obj.meeting.repository.MeetingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeetingService {

    private final MeetingRepository meetingRepository;

    public MeetingService(MeetingRepository meetingRepository) {
        this.meetingRepository = meetingRepository;
    }

    public List<Meeting> findAll() {
        return meetingRepository.findAll();
    }

    public Meeting findById(Long id) {
        return meetingRepository.findById(id).orElse(null);
    }

    public Meeting save(Meeting meeting) {
        return meetingRepository.save(meeting);
    }

    public void deleteById(Long id) {
        meetingRepository.deleteById(id);
    }
}
