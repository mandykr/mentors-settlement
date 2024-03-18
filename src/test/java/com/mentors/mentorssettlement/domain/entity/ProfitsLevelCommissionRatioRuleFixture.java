package com.mentors.mentorssettlement.domain.entity;

import com.mentors.mentorssettlement.domain.entity.ProfitsLevelCommissionRatioRule;
import com.mentors.mentorssettlement.domain.vo.MentorLevel;
import com.mentors.mentorssettlement.domain.vo.ProfitsDuration;
import com.mentors.mentorssettlement.domain.vo.Ratio;
import com.mentors.mentorssettlement.domain.vo.RatioPerLevel;

import java.util.HashMap;
import java.util.Map;

import static com.mentors.mentorssettlement.domain.vo.MentorLevel.*;
import static com.mentors.mentorssettlement.domain.vo.Money.wons;

public class ProfitsLevelCommissionRatioRuleFixture {
    public static HashMap<MentorLevel, Ratio> ratiosTypeA;
    public static HashMap<MentorLevel, Ratio> ratiosTypeB;
    public static HashMap<MentorLevel, Ratio> ratiosTypeC;
    public static HashMap<MentorLevel, Ratio> ratiosTypeD;
    public static ProfitsLevelCommissionRatioRule ratioRule;

    static {
        ratiosTypeA = new HashMap<>();
        ratiosTypeA.put(BEGINNER, new Ratio(2.7));
        ratiosTypeA.put(AMATEUR, new Ratio(2.6));
        ratiosTypeA.put(SEMIPRO, new Ratio(2.5));
        ratiosTypeA.put(PRO, new Ratio(2.4));

        ratiosTypeB = new HashMap<>();
        ratiosTypeB.put(BEGINNER, new Ratio(2.8));
        ratiosTypeB.put(AMATEUR, new Ratio(2.7));
        ratiosTypeB.put(SEMIPRO, new Ratio(2.6));
        ratiosTypeB.put(PRO, new Ratio(2.5));

        ratiosTypeC = new HashMap<>();
        ratiosTypeC.put(BEGINNER, new Ratio(2.9));
        ratiosTypeC.put(AMATEUR, new Ratio(2.8));
        ratiosTypeC.put(SEMIPRO, new Ratio(2.7));
        ratiosTypeC.put(PRO, new Ratio(2.6));

        ratiosTypeD = new HashMap<>();
        ratiosTypeD.put(BEGINNER, new Ratio(3.0));
        ratiosTypeD.put(AMATEUR, new Ratio(2.9));
        ratiosTypeD.put(SEMIPRO, new Ratio(2.8));
        ratiosTypeD.put(PRO, new Ratio(2.7));

        Map<ProfitsDuration, RatioPerLevel> rules = new HashMap<>();
        rules.put(new ProfitsDuration(wons(1), wons(10_000)), new RatioPerLevel(ratiosTypeA));
        rules.put(new ProfitsDuration(wons(10_000), wons(50_000)), new RatioPerLevel(ratiosTypeB));
        rules.put(new ProfitsDuration(wons(50_000), wons(100_000)), new RatioPerLevel(ratiosTypeC));
        rules.put(new ProfitsDuration(wons(100_000), wons(Long.MAX_VALUE)), new RatioPerLevel(ratiosTypeD));

        ratioRule = new ProfitsLevelCommissionRatioRule(rules);
    }
}
