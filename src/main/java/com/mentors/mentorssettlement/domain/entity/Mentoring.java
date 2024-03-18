package com.mentors.mentorssettlement.domain.entity;

import com.mentors.mentorssettlement.domain.vo.MentorLevel;
import com.mentors.mentorssettlement.domain.vo.MentoringHour;
import com.mentors.mentorssettlement.domain.vo.MentoringStatus;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Mentoring {
    private MentorLevel mentorLevel;
    private MentoringStatus status;
    private MentoringHour hour;
}
